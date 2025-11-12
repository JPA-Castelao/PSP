import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class cliente {


    public void bucleConexion() {
        Scanner sc = new Scanner(System.in);
        int salir = 0;
        while (salir == 0) {
            System.out.println("Introduce la direccion de  cliente");
            String ipAdress = sc.nextLine();
            System.out.println("Introduce el puerto");
            int puerto = sc.nextInt();
            conexion(ipAdress, 21);
            conexion(ipAdress, 22);
            conexion(ipAdress, 80);
            conexion(ipAdress, 443);
            conexion(ipAdress, puerto);

            System.out.println("salir? 1-si 0-no");
            salir = sc.nextInt();

        }


    }

    private void conexion(String ipAdress, int port) {


        int tiempoConexion = 500;
        try (Socket sock = new Socket()) {

            SocketAddress remoteAddr = new InetSocketAddress(ipAdress, port);

            sock.connect(remoteAddr, tiempoConexion);

            System.out.println("Puerto  " + port + " : " + " abierto para el cliente " + ipAdress);

        } catch (Exception e) {
            System.err.println("Imposible establecer conexion en el puerto : " + port + " para el cliente: " + ipAdress);
        }

    }
}