package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class GestorClientes extends Thread {

    private Socket cliente;
    private BufferedReader bf;

    private String nickCliente;
    public static PrintWriter escritor;

    public GestorClientes(Socket cliente) {

        this.cliente = cliente;
    }

    public void run() {

        try {
            escritor = new PrintWriter(cliente.getOutputStream());
            bf = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            Servidor.listaClientes.add(escritor);
            nickCliente = bf.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("\n El usuario %s se ha conectado\n Hay %d usuarios conectados", Servidor.listaClientes.size());

    }


}