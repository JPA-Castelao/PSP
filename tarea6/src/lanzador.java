import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class lanzador {

    public static void lanzador(String host) {

        int exitValue = 1;
        String linea;
        String error = "[OK] ";

       ProcessBuilder pbPing = new ProcessBuilder("ping", "-c", "4", "-i", "1", host);
        try {


            Process pPing = pbPing.start();
            BufferedReader pBreader = new BufferedReader(new InputStreamReader(pPing.getInputStream()));

            while ((linea = pBreader.readLine()) != null) {
                System.out.println(error + linea);
            }

            exitValue=pPing.waitFor();
            if(exitValue==0){
                System.out.println("El código de salida es: " + exitValue);

            }else{
                System.out.println("[ERROR] servicio inexistente ");
                System.out.println("El código de salida es: " + exitValue);
            }

        } catch (IOException e) {
            System.out.println("El código de salida es: " + exitValue);
        } catch (InterruptedException j) {

        }


    }
}