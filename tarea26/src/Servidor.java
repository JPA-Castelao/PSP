import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public static void main(String[] args) {


    try {
        InetSocketAddress direccionIp = new InetSocketAddress("localhost", 6000);

        ServerSocket socketServidor = new ServerSocket();
        socketServidor.bind(direccionIp);

        Socket socket = socketServidor.accept();
        socket.connect(direccionIp);
        System.out.println("Conectando al servidor");


        PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);


        escritor.println("Mensaje 1 al servidor");
        escritor.println("Mensaje 2 al servidor");
        escritor.println("Mensaje 3 al servidor");

        socket.close();
        socketServidor.close();

    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}


