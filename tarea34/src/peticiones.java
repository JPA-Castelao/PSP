import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class peticiones {


    public static void peticiones(String ruta1, String ruta2) {
        try {

            //Creamos el cliente
            HttpClient cliente = HttpClient.newHttpClient();

            //Creamos la peticion 1

            HttpRequest peticion1 = HttpRequest.newBuilder().uri(URI.create(ruta1)).GET().build();

            //Creamos la peticion 2
            HttpRequest peticion2 = HttpRequest.newBuilder().uri(URI.create(ruta2)).GET().build();

            //Recogemos la peticion 1 y ponemos el temporizador
            long tiempoInicio = System.nanoTime();

            HttpResponse<byte[]> respuesta1 = cliente.send(peticion1, HttpResponse.BodyHandlers.ofByteArray());

            long tiempoFin = System.nanoTime();

            long tiempoPeticion1 = tiempoFin - tiempoInicio;

            //Recogemos la peticion 2 y ponemos el temporizador

            tiempoInicio = System.nanoTime();

            HttpResponse<String> respuesta2 = cliente.send(peticion2, HttpResponse.BodyHandlers.ofString());
            tiempoFin = System.nanoTime();
            char[] cArray = respuesta2.body().toCharArray();

            long tiempoPeticion2 = tiempoFin - tiempoInicio;


            System.out.println("Tiempo peticion1: " + tiempoPeticion1);
            System.out.println("Numero bytes peticion1 : " + respuesta1.body().length);

            System.out.println("Tiempo peticion2: " + tiempoPeticion2);
            System.out.println("Numero caracteres peticion1 : " + cArray.length);


            if (tiempoPeticion1 >= tiempoPeticion2) {
                if (tiempoPeticion1 == tiempoPeticion2) {
                    System.out.println("HAN TARDADO LO MISMO " + tiempoPeticion1);

                } else {
                    System.out.println("LA GANADORA ES PETICION1 " + tiempoPeticion1);

                }
            } else {
                System.out.println("LA GANADORA ES PETICION2 " + tiempoPeticion2);

            }

        } catch (Exception e) {

        }


    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la  url 1");
        String url1 = sc.nextLine();
        System.out.println("Introduce la  url 2");
        String url2 = sc.nextLine();

        peticiones(url1, url2);

    }
}
