package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;


public class Servidor {

    private final ServerSocket servidor;
    private final ExecutorService pool;
    public static List<PrintWriter> listaClientes = new ArrayList<>();

    private int pedirPuerto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el puerto que quieras para el servidor");
        return sc.nextInt();
    }


    public Servidor() {


        try {
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
                GestorClientes gc = new GestorClientes(servidor.accept());
                //Crea un hilo
                pool.execute(gc);
                listaClientes.add(gc.escritor);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RejectedExecutionException e) {
            System.out.println("No puede haber más de 10 clientes conectados");
            throw new RuntimeException(e);
        }


    }


    public static void main(String[] args) {
        Servidor server = new Servidor();
    }
}
