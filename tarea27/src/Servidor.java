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

            Socket socket = socketServidor.accept();
            System.out.println("Conectando al servidor");


            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String mensaje = "";
            //BUeno en este caso != null si está bien ¿no?
            while (mensaje.equalsIgnoreCase("adiós") || mensaje != null) {
                mensaje = lector.readLine();
                System.out.println(mensaje);
                pw.println("ECO: " + mensaje);

            }

            socket.close();
            socketServidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
