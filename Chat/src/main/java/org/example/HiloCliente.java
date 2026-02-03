package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HiloCliente extends Thread {

    BufferedReader lector;

    public HiloCliente(BufferedReader lector) {

        this.lector = lector;
    }

    @Override
    public void run() {
        String mensajeServidor;
        try {

            while ((mensajeServidor = this.lector.readLine()) != null) {
                System.out.println(mensajeServidor);
            }
        } catch (IOException e) {

        } finally {
            try {
                lector.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
