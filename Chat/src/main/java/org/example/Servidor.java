package org.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Servidor {

    private final ServerSocket servidor;
    private final ExecutorService pool;

    public Servidor() {


        try {
            pool = Executors.newFixedThreadPool(10);
            servidor = new ServerSocket(6565);
            System.out.println("Servidor esperando clientes");

            while (true) {

                //1.Acepta la conexion
                //2.Crea un hilo

                pool.execute(new GestorClientes(servidor.accept()));
                System.out.printf("\n Nuevo cliente conectado (%s) ");


            }


        } catch (IOException e) {
            pool.shutdown();
            throw new RuntimeException(e);
        }

    }


}
