package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Criptopepe {


        public static void buscarMoneda(String body){

        }


    public static void peticion() {

        HttpClient cliente = HttpClient.newHttpClient();

        String json = "{\"user\":\"alumno\",\"pass\":\"1234\"}";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.coinlore.net/api/global/"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        try {

            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            buscarMoneda(response.body());


        } catch (Exception e) {
            System.err.println("ERROR AL HACER LA PETICION: " + e.getMessage());
        }


    }


    public static void main(String[] args) {

        peticion();

    }

}
