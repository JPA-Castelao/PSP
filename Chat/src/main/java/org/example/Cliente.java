package org.example;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private String ip;
    private int puerto;
    private String nick;

    public void pedirIpPuertoNick() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una ip para conectarte al servidor");
        this.ip = sc.nextLine();
        System.out.println("Introduce un puerto para conectarte al servidor");
        this.puerto = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce un nick para conectarte al servidor");
        this.nick = sc.nextLine();

    }

    public Cliente() {
        BufferedReader lector;
        PrintWriter escritor;
        try {

            pedirIpPuertoNick();
            InetSocketAddress dir = new InetSocketAddress(this.ip, this.puerto);
            Socket socket = new Socket();
            socket.connect(dir);
            System.out.println("Conectado a la sala de chat");

            lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            escritor = new PrintWriter(socket.getOutputStream(), true);

            escritor.println(this.nick);

            while (true) {
                mensajeCliente = lector.readLine();
                if (!mensajeCliente.equals("/bye")) {
                    escritor.printf("\n %s : %s ", nickCliente, mensajeCliente);

                } else {
                    break;
                }
            }
            cliente.close();


        } catch (Exception e) {
            System.err.println("Imposible conectar al servidor");
        }


    }

    public static void main(String[] args) {

    }


}



