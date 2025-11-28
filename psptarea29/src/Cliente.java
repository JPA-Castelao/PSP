import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        InetSocketAddress dir = new InetSocketAddress("localhost", 7000);
        Scanner sc = new Scanner(System.in);
        try {
            Socket cliente = new Socket();
            cliente.connect(dir);
            PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);

            String operacion = "";
            String operando1;
            String operando2;
            while (!operacion.equalsIgnoreCase(" ")) {
                System.out.println("Introduce una operacion o  \"\" para salir");
                System.out.println("-1 Suma");
                operacion = sc.nextLine();
                System.out.println("Introduce el operando 1");
                operando1 = sc.nextLine();
                System.out.println("Introduce el operando 2");
                operando2 = sc.nextLine();
                pw.println(operacion);
                pw.println(operando1);
                pw.println(operando2);
            }

        } catch (Exception e) {
            System.err.println("ERROR DE CLIENTE: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }


}
