package org.example;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private Scanner sc = new Scanner(System.in);
    public static String nick;

    public String pedirIp() {
        String ip;
        System.out.println("Introduce una ip para conectarte al servidor");
        ip = sc.nextLine();
        sc.nextLine();
        return ip;
    }

    public int pedirPuerto() {
        int puerto;
        System.out.println("Introduce un puerto para conectarte al servidor");
        puerto = sc.nextInt();
        sc.nextLine();
        return puerto;
    }

    public String pedirNick() {
        System.out.println("Introduce un nick para conectarte al servidor");
        return nick = sc.nextLine();
    }


    public Cliente() {

        //Inentamos establecer conexion al servidor
        InetSocketAddress dir = new InetSocketAddress(pedirIp(), pedirPuerto());
        try {
            Socket socket = new Socket();
            socket.connect(dir);
            //OBLIGATORIO
            System.out.println("Conectado a la sala de chat");
            logicaCliente(socket);


        } catch (Exception e) {
            System.err.println("Error al conectar a la sala de chat");
        }


    }

    public void logicaCliente(Socket socket) {

        String mensaje;
        try (
                PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);

                BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {

            HiloCliente hc = new HiloCliente(lector);

            hc.start();
            while (true) {
                mensaje = sc.nextLine();
                escritor.println(mensaje);
                if (mensaje.equals("/bye")) {
                    break;
                }
            }

        } catch (Exception e) {


        } finally {
            try {
                if (!socket.isClosed()) {
                    socket.close();
                }
                System.err.println("Se ha cerrado el cliente");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    public static void main(String[] args) {

        Cliente c = new Cliente();
    }


}