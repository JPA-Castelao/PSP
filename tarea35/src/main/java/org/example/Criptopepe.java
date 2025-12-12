package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Criptopepe {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    static Scanner sc = new Scanner(System.in);


    public static void mostrarDatosMonedaPorSimbolo(List<moneda> lista) {

        String nombre;
        try {
            System.out.println("Introduce el simbolo de la moneda");
            nombre = sc.nextLine();
            for (moneda m : lista) {
                if (m.getSymbol().equals(nombre)) {
                    System.out.println("Nombre: " + m.getName());
                    System.out.println("Simbolo: " + m.getSymbol());
                    System.out.println("Precio en $: " + m.getPrice_usd());
                    System.out.println("Posicion en el ranking: " + m.getRank());
                    System.out.println("Variacion 24h: " + m.getPercent_change_24h());
                } else {
                    throw new Exception();
                }
                break;
            }
        } catch (Exception e) {
            System.err.println("MONEDA NO ECONTRADA: " + e.getMessage());
        }


    }

    public static void mostrarDatosMonedaPorNombre(List<moneda> lista) {

        String nombre;
        try {
            System.out.println("Introduce el nombre de la moneda");

            nombre = sc.nextLine();

            for (moneda m : lista) {

                if (m.getName().equals(nombre)) {

                    System.out.println("Nombre: " + m.getName());
                    System.out.println("Simbolo: " + m.getSymbol());
                    System.out.println("Precio en $: " + m.getPrice_usd());
                    System.out.println("Posicion en el ranking: " + m.getRank());
                    System.out.println("Variacion 24h: " + m.getPercent_change_24h());
                } else {
                    throw new Exception();
                }
                break;


            }
        } catch (Exception e) {
            System.err.println("MONEDA NO ECONTRADA: " + e.getMessage());
        }

    }

    public static void buscarMoneda(String body) {

        totalMonedas monedas = GSON.fromJson(body, totalMonedas.class);

        List<moneda> listaMonedas = monedas.getMonedas();
        menuBusqueda(listaMonedas);
    }


    public static void menuBusqueda(List<moneda> lista) {
        int opcion = 0;

        do {
            try {

                System.out.println("Quieres buscar por nombre o simbolo?");
                System.out.println("1-Nombre");
                System.out.println("2-Simbolo");
                opcion = sc.nextInt();
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Introduce solo 1 o 2");
                opcion = sc.nextInt();
                sc.nextLine();
            }


        } while (opcion != 1 && opcion != 2);

        switch (opcion) {
            case 1:
                mostrarDatosMonedaPorNombre(lista);
                break;
            case 2:
                mostrarDatosMonedaPorSimbolo(lista);
                break;
            default:
                System.out.println("nombre o simbolos desconocidos");

        }


    }

    public static void peticion() {

        //Definimos los parametros de la petición
        String uriCoinlore = "https://api.coinlore.net/api/tickers/";


        //Definimos la peticion
        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uriCoinlore)).header("Content-Type", "application/json").GET().build();

        try {

            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
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
