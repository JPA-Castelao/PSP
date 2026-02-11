import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Servidor {

    public static void main(String[] args) {
        try {
            String palabra, palabraLarga;
            String[] palabras;
            byte[] buffer = new byte[1024];

            DatagramSocket socketServidor = new DatagramSocket(6565);

            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);

            socketServidor.receive(paquete);

            palabra = new String(paquete.getData(), 0, paquete.getLength());

            System.out.println(palabra);

            palabra = palabra.replace("[", "");
            palabra = palabra.replace("]", "");

            palabras = palabra.split(",");
            palabraLarga = palabras[0];

            for (String p : palabras) {
                if (p.length() > palabraLarga.length()) {
                    palabraLarga = p;

                }

            }
            int puertoCliente = paquete.getPort();
            InetAddress direccionCliente = paquete.getAddress();

            DatagramPacket respuestaServidor = new DatagramPacket(palabraLarga.getBytes(), palabraLarga.getBytes().length, direccionCliente, puertoCliente);

            socketServidor.send(respuestaServidor);

            socketServidor.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
