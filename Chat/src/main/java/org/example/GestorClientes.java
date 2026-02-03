package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorClientes extends Thread {

    private Socket cliente;
    private BufferedReader bf;

    private String nickCliente;
    public PrintWriter escritor;

    public GestorClientes(Socket cliente) {

        this.cliente = cliente;
    }

    public void gestionMensajes(BufferedReader bf) throws IOException {
        String mensajeRecibido;
        while ((mensajeRecibido = bf.readLine()) != null) {


            switch (mensajeRecibido) {
                case "/list":
                    //syncronizamos la lista de nicks para recorrerla tranquilamente
                    synchronized (Servidor.listaNicks) {
                        for (String nick : Servidor.listaNicks) {
                            //Usamos el mismo printWriter del usuario para que solo el reciba la lista
                            escritor.println("El usuario " + nick + " está conectado");
                        }
                    }

                    break;
                case "/bye":
                    return;
                case "/ping":
                    escritor.println("pong");
                    break;
                default:
                    Servidor.reenviar(String.format("\n%s: %s", nickCliente, mensajeRecibido));
                    break;
            }

        }
    }

    public void run() {

        try {
            escritor = new PrintWriter(cliente.getOutputStream(), true);
            bf = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            //Añadimos el printwriter de este cliente a la lista de clientes, lo que sirve para el conteo y para el broadcasting
            Servidor.listaClientes.add(escritor);
            //El nick es el primer mensaje que envia el cliente recien creado de forma autómatica. Lo recogemos
            nickCliente = bf.readLine();
            //añadimos el nick a una lista para luego obtener todos los usuarios conectados
            Servidor.listaNicks.add(nickCliente);
            Servidor.reenviar(String.format("\n NUEVO CLIENTE CONECTADO (%s) ACTUALMENTE HAY %d CLIENTES CONECTADOS", nickCliente, Servidor.listaClientes.size()));
            gestionMensajes(bf);

        } catch (IOException e) {
            System.out.printf("DESCONEXION DEL SERVIDOR\n");
        } finally {
            try {
                cliente.close();
                Servidor.listaClientes.remove(escritor);
                Servidor.listaNicks.remove(nickCliente);
                Servidor.reenviar(String.format("\n  (%s) SE HA DESCONECTADO", nickCliente));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }


}