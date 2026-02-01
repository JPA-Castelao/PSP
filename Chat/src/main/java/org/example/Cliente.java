package org.example;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private Scanner sc = new Scanner(System.in);
    public String nick;

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

    public void pedirNick() {
        String nick;
        System.out.println("Introduce un nick para conectarte al servidor");
        this.nick = sc.nextLine();
    }


    public Cliente() {

        //Inentamos establecer conexion al servidor
        InetSocketAddress dir = new InetSocketAddress(pedirIp(), pedirPuerto());
        try {
            Socket socket;
            socket = new Socket();
            socket.connect(dir);
            //OBLIGATORIO
            System.out.println("Conectado a la sala de chat");
            pedirNick();
            logicaCliente(socket);


        } catch (Exception e) {
            System.err.println("Error al conectar a la sala de chat");
        }


    }

    public void logicaCliente(Socket socket) {

        String mensaje;
        String nick = this.nick;
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream())); PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);

        ) {
            while (true) {
                System.out.println(lector.readLine());
                mensaje = sc.nextLine();
                escritor.print(mensaje);
                if (mensaje.equals("/bye")) {
                    throw new Exception("cerrar");
                }
                sc.nextLine();
            }


        } catch (Exception e) {

        } finally {
            try {
                socket.close();
                System.err.println("Se ha cerrado el cliente");

            } catch (Exception e) {

            }
        }


    }


    public static void main(String[] args) {

    }


}



