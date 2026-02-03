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
    private PrintWriter pw;

    private String nickCliente;
    private List<PrintWriter> listaEscritores;

    public GestorClientes(Socket cliente) {

        this.cliente = cliente;
    }

    public void run() {


    }

}