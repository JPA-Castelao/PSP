package org.example;

import java.io.IOException;
import java.net.*;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Servidor {

    private final ServerSocket servidor;
    private final ExecutorService pool;

    public Servidor() {


        try {
            InetSocketAddress dir = new InetSocketAddress("localhost", 6565);
            pool = Executors.newFixedThreadPool(10);
            servidor = new ServerSocket();
            servidor.bind(dir);
            System.out.println("Servidor esperando clientes");

            while (true) {
                //1.Acepta la conexion
                //2.Crea un hilo
                pool.execute(new GestorClientes(servidor.accept()));
                System.out.printf("\n Nuevo cliente conectado (%s) ");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
