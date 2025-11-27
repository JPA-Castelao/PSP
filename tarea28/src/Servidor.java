import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Servidor {


    public static void main(String[] args) {


        try {
            InetSocketAddress direccionIp = new InetSocketAddress("localhost", 5777);

            ServerSocket socketServidor = new ServerSocket();
            socketServidor.bind(direccionIp);

            System.out.println("Iniciando conexion al servidor");

            while (true) {
                Socket cliente = socketServidor.accept();
                System.out.println("Cliente conectado");
                GestorClientes hilo = new GestorClientes(cliente);
                hilo.start();

            }


        } catch (Exception e) {
            System.out.println("ERROR TIPO " + e.getMessage());
        }
    }


}
