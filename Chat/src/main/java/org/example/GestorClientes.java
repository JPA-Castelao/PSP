package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorClientes extends Thread {

    private Socket cliente;
    private BufferedReader bf;
    private PrintWriter pw;

    public GestorClientes(Socket cliente) {

        this.cliente = cliente;
    }

    public void run() {

        String nickCliente;
        String mensajeCliente;
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
             PrintWriter escritor = new PrintWriter(cliente.getOutputStream(), true);
        ) {


            nickCliente = lector.readLine();
            System.out.printf("\n el usuario %s ha entrado al chat", nickCliente);
            while (true) {

                mensajeCliente = lector.readLine();

                if (!mensajeCliente.equals("/bye")) {
                    escritor.printf("\n %s : %s ", nickCliente, mensajeCliente);
                } else {
                    break;
                }
            }
            cliente.close();

        } catch (IOException e) {
            System.err.println("Error");
        } finally {
            try {
                cliente.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

