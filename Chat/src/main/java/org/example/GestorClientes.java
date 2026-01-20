package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class GestorClientes extends Thread {

    private Socket cliente;


    public GestorClientes(Socket cliente) {

        this.cliente = cliente;


    }

    public void run() {

        try {

            cliente.close();
            System.out.println("Cliente desconectado");
        } catch (IOException e) {
            System.err.println("Error con cliente:" + e.getMessage());
        } finally {
            try {
                cliente.close();
                System.out.println("Cliente desconocido");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
