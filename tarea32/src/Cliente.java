import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class Cliente {

    public static void main(String[] args) {

        byte[] buffer = new byte[1024];
        String[] listaPalabras = {"gazpacho", "almádena", "capricho", "energúmeno", "pistolero"};
        try {
            DatagramSocket socketCliente = new DatagramSocket();
            InetAddress ipDestino = InetAddress.getByName("localhost");

            String msj = Arrays.toString(listaPalabras).trim();
            buffer = msj.getBytes();
            DatagramPacket paqueteCliente = new DatagramPacket(buffer, buffer.length, ipDestino, 6565);

            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);

            socketCliente.send(paqueteCliente);
            socketCliente.receive(paqueteRecibido);

            String mensajeRecibido = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength());


            System.out.println("LA PALABRA MÁS LARGA ES : " + mensajeRecibido + " LA LONGITUD ES : " + mensajeRecibido.length());
            socketCliente.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
