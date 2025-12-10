package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Scanner;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Criptopepe {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    public static void buscarMoneda(String body) {

        totalMonedas monedas = GSON.fromJson(body, totalMonedas.class);

        List<moneda> listaMonedas = monedas.getMonedas();
        menuBusqueda(listaMonedas);
    }

    public static void menuBusqueda(List<moneda> lista) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quieres buscar por nombre o simbolo?");
        System.out.println("1-Nombre");
        System.out.println("2-Simbolo");
        try {
            sc.nextInt();

        } catch (Exception e) {
            System.out.println("Responda solo 1 o 2");
            System.out.println("1-Nombre");
            System.out.println("2-Simbolo");
            sc.nextInt();

        }


        for (moneda m : lista) {
            if (m.getSymbol().equals("BTC")) {
                System.out.println("Ranking:" + m.getRank());
            }
        }

    }

    public static void peticion() {

        //Definimos los parametros de la petición
        String uriCoinlore = "https://api.coinlore.net/api/tickers/";
        String json = "{\"user\":\"alumno\",\"pass\":\"1234\"}";


        //Definimos la peticion
        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uriCoinlore))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {

            HttpResponse<String> response = cliente.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());
            int codigoStatus = response.statusCode();
            String respuesta = response.body();

            if (codigoStatus == 200) {
                System.out.println("Peticion exitosa");
                System.out.println(response.body());

                buscarMoneda(response.body());

            }


        } catch (Exception e) {
            System.err.println("ERROR AL HACER LA PETICION: " + e.getMessage());
        }


    }


    public static void main(String[] args) {

        peticion();

    }

}
