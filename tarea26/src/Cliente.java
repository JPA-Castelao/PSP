import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public static void main(String[] args) {
    try {
        InetSocketAddress ia = new InetSocketAddress("localhost", 6000);
        Socket socketCliente = new Socket();
        socketCliente.connect(ia);

        BufferedReader lector = new BufferedReader(
                new InputStreamReader(socketCliente.getInputStream())
        );

        String mensaje1 = lector.readLine();
        String mensaje2 = lector.readLine();
        String mensaje3 = lector.readLine();

        System.out.println("Servidor dice+ " + mensaje1);
        System.out.println("Servidor dice+ " + mensaje2);
        System.out.println("Servidor dice+ " + mensaje3);
        socketCliente.close();

    } catch (
            Exception e) {

        System.err.println("EL MENSAJE ES " + e.getMessage());
    }

}





