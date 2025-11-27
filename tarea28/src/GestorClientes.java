import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestorClientes extends Thread {

    private Socket socket;

    String mensaje;

    String respuesta;

    public GestorClientes(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)

        ) {
            while (true) {
                mensaje = br.readLine();
                if (mensaje == null || mensaje.equalsIgnoreCase("adiós")) {
                    break;
                }
                respuesta = "ECO: " + mensaje;
                pw.println(respuesta);

            }

            System.out.println("El servidor ha respondido");

        } catch (IOException e) {
            System.out.println("ERROR TIPO " + e.getMessage());
        } finally {

            try {

                socket.close();
                System.out.println("Cliente desconectado");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }


}
