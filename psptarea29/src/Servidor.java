import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {


    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(7000);
            System.out.println("Servidor ");




            while (true) {
                Socket ConexionCliente = server.accept();


                Calculadora calculadora= new Calculadora()
            }

        } catch (IOException e) {
            System.err.println("IMPOSIBLE CONECTAR AL SERVIDOR: " + e.getMessage());

            throw new RuntimeException(e);
        }


    }


}
