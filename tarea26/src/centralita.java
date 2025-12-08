import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class centralita {

    public void centralita() {

    }

    public void conectar() {
        try {
            ServerSocket ss = new ServerSocket(6666);

            Socket socketCliente = ss.accept();

            System.out.println("La IP del cliente es " + socketCliente.getInetAddress());


            socketCliente.close();
            ss.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
