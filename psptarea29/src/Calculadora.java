import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.InputMismatchException;

public class Calculadora extends Thread {

    private Socket socket;
    private int tipoOperacion;
    private int operando1, operando2;

    public Calculadora(Socket socket, int tipoOperacion, int operando1, int operando2) {
        this.socket = socket;
        this.tipoOperacion = tipoOperacion;
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    @Override
    public void run() {
        try (
                BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)
        ) {

            switch (this.tipoOperacion) {
                case 1:
                    operacionSuma(this.operando1, this.operando2);
                    System.out.printf("\n EL RESULTADO DE LA SUMA ES: %d ", (this.operando1 + this.operando2));
                    break;
            }


        } catch (IOException e) {
            System.err.println("ERROR TIPO" + e.getMessage());
        } finally {
            try {
                socket.close();
                System.out.println("CLIENTE DESCONECTADO");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public int operacionSuma(int numero1, int numero2) {

        return numero1 + numero2;

    }


}
