import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {


    public static void main(String[] args) {
        try {
            InetSocketAddress ia = new InetSocketAddress("localhost", 5777);
            Socket socketCliente = new Socket();
            socketCliente.connect(ia);

            Scanner sc = new Scanner(System.in);


            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(socketCliente.getInputStream())
            );


            PrintWriter pw = new PrintWriter(socketCliente.getOutputStream(), true);


            String mensaje = "";
            while (mensaje.equalsIgnoreCase("adiós") || mensaje != null) {


                System.out.println("Ingrese un mensaje de texto ");
                mensaje = sc.nextLine();
                pw.println((mensaje));
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
