package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;


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

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (RejectedExecutionException e) {
            System.out.println("No puede haber más de 10 clientes conectados");
            throw new RuntimeException(e);
        }


    }

    public void gestionMensajes() {

    }

    public static void main(String[] args) {
        Servidor server = new Servidor();
    }
}
