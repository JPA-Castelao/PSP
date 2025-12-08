import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Scanner;

public class Cliente {


    public static void peticion(String url) {
        //Cracion del cliente
        HttpClient cliente = HttpClient.newHttpClient();

        Path ruta = Paths.get("E:\\DAM\\PSP\\tarea33\\src\\inspector.html");

        //Crear petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .timeout(Duration.ofSeconds(5000))
                .headers("Cabecera", "content-type")
                .build();
        try {
            //ENviar y reciir respuesta
            HttpResponse<Path> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofFile(ruta));

            //Procesar resultados

            if (response.statusCode() == 200) {
                System.out.println("Codigo de estado: " + response.statusCode());
                System.out.println("Cabecera: " + response.body());
            } else {
                throw new Exception("Error al realizar peticion");
            }


        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una url");
        String url = sc.nextLine();
        peticion(url);

    }

}