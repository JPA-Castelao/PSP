import com.sun.tools.javac.Main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

   public static void main(String[] args) {

        try {

            //Instanciamos la clase datagram socket
            DatagramSocket socket = new DatagramSocket();
            //Conseguimos la dirección ip que va a
            InetAddress ip = InetAddress.getByName("localhost");
            byte[] bufferEnvio = "REY SAPO".getBytes();

            DatagramPacket paquete = new DatagramPacket(bufferEnvio, bufferEnvio.length, ip, 8888);

            socket.send(paquete);
            socket.close();

        } catch (Exception e) {
            System.err.println("Mensaje " + e.getMessage());
        }


    }


}
