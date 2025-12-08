import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {


    public static void main(String[] args) {
        try {

            DatagramSocket ds = new DatagramSocket(8888);

            byte[] datosRecuperados = new byte[1024];
            DatagramPacket paquete = new DatagramPacket(datosRecuperados, datosRecuperados.length);

            ds.receive(paquete);
            System.out.println(" paquete RECIBIDO");

            String mensaje = new String(paquete.getData(), 0, paquete.getLength());
            System.out.println(mensaje + " RECIBIDO");
            ds.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
