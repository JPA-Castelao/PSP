import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    InetSocketAddress dir = new InetSocketAddress("localhost", 7000);

    public static void main(String[] args) {
        int operacion, operando1, operando2;
        try {
            ServerSocket server = new ServerSocket(7000);
            System.out.println("Servidor ");
            Socket socket = server.accept();
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            while (true) {
                Socket ConexionCliente = server.accept();
                operacion = Integer.parseInt(bf.readLine());
                operando1 = Integer.parseInt(bf.readLine());
                operando2 = Integer.parseInt(bf.readLine());

                Calculadora calculadora = new Calculadora(socket, operacion, operando1, operando2);
            }

        } catch (IOException e) {
            System.err.println("IMPOSIBLE CONECTAR AL SERVIDOR: " + e.getMessage());

            throw new RuntimeException(e);
        }


    }


}
