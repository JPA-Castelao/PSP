import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente1 {


    public static void main(String[] args) {

        InetSocketAddress ia = new InetSocketAddress("localhost", 5777);
        Scanner sc = new Scanner(System.in);
        String mensaje;
        String respuesta;
        try {
            Socket socketCliente = new Socket();
            socketCliente.connect(ia);

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream())
            );


            PrintWriter pw = new PrintWriter(socketCliente.getOutputStream(), true);


            while (true) {
                System.out.println("Ingrese un mensaje de texto  en el servidor ");
                mensaje = sc.nextLine();
                pw.println(mensaje);
                if (mensaje.equalsIgnoreCase("adiós") || mensaje == null) {
                    break;
                }
                mensaje = lector.readLine();
                System.out.println(mensaje);
            }

            socketCliente.close();

        } catch (
                Exception e) {
            System.err.println("ERROR TIPO: " + e.getMessage());
        }

    }

}



