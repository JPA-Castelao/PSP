import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class interfaz {


   public   void getHost() throws IOException {
        String host="", cadenaHost, salir = "";

        Scanner sc = new Scanner(System.in);


         while(!host.equals("salir")){

            System.out.println("Introduce Host/IP");
            host = sc.nextLine();


            lanzador.lanzador(host);


        }


    }

}
