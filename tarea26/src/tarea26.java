import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class tarea26 {


    public void conectar() {
        try {
            ServerSocket socketServidor = new ServerSocket(6666);
            Socket socketCliente = socketServidor.accept();

            System.out.println("LA IP DEL CLIENTE ES:" + socketCliente.getInetAddress());
            socketCliente.close();
            socketServidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public class Cliente {

        public static void main(String[] args) {
            InetSocketAddress direccionIp = new InetSocketAddress("localhost", 6666);

            try {
                Socket socketCliente = new Socket();
                socketCliente.connect(direccionIp);
                System.out.println("Conectando al servidor");

                OutputStream OutputCliente = socketCliente.getOutputStream();

                PrintWriter escritor = new PrintWriter(OutputCliente);


                escritor.write("Mensaje 1 al servidor");
                escritor.write("Mensaje 2 al servidor");
                escritor.write("Mensaje 3 al servidor");


                socketCliente.close();


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


    }

    public class Servidor {
        public static void main(String[] args) {
            try {
                InetSocketAddress dir = new InetSocketAddress("localhost", 70000);
                ServerSocket servidor = new ServerSocket();
                servidor.bind(dir);
                System.out.println("Esperando conexiones...");
                Socket socket = servidor.accept();

                BufferedReader bf = new BufferedReader(socket.getInputStream());


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        tarea26 tarea = new tarea26();
        tarea.conectar();
    }
}
