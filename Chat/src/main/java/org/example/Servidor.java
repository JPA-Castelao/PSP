package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;


public class Servidor {

    private ServerSocket servidor;
    private ExecutorService pool;
    //para que la lista esté sincronizada
    //como synchronized pero para variables
    public static List<PrintWriter> listaClientes = Collections.synchronizedList(new ArrayList<>());
    public static List<String> listaNicks = Collections.synchronizedList(new ArrayList<>());

    private int pedirPuerto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el puerto que quieras para el servidor");
        return sc.nextInt();
    }

    public static void reenviar(String mensaje) {
        synchronized (listaClientes) {

            for (PrintWriter escritor : listaClientes) {
                escritor.println(mensaje);
            }
        }
    }

    public Servidor() {

        //hook de cierre
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            reenviar("EL SERVIDOR VA A CERRAR");


            reenviar("EL SERVIDOR SE HA CERRADO");

            pool.shutdown();

            try {
                if (servidor != null) servidor.close();
            } catch (Exception e) {
                System.out.println("Cerror cerrado correctamente");
            }
        }));


        try {
            Socket cliente = new Socket();

            //pedimos el puerto que va a usar el servidor
            //ip hardcodeada a localhost pq es un server interno de la empresa
            InetSocketAddress dir = new InetSocketAddress("localhost", pedirPuerto());
            pool = Executors.newFixedThreadPool(10);
            servidor = new ServerSocket();
            servidor.bind(dir);
            //Muestra la cantidad de clientes conectados
            if (listaClientes.isEmpty()) {
                System.out.print("\n No hay clientes conectados ");
            }
            while (true) {
                //Acepta la conexion
                try {


                    cliente = servidor.accept();
                    GestorClientes gc = new GestorClientes(cliente);
                    //Crea un hilo
                    pool.execute(gc);


                } catch (RejectedExecutionException e) {
                    System.out.println("No puede haber más de 10 clientes conectados");
                    PrintWriter rejection = new PrintWriter(cliente.getOutputStream(), true);
                    rejection.println("SERVIDOR LLENO ESPERE");
                    rejection.close();
                }
            }


        } catch (IOException e) {

        } finally {
            reenviar("EL SERVIDOR SE HA CERRADO");

            pool.shutdown();
        }


    }


    public static void main(String[] args) {
        Servidor server = new Servidor();
    }
}
