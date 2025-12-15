package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

//clase moeneda
class moneda {

}

class listaMonedas {

}

public class Criptopepe {
//Delcaramos el


    public static int peticionGlobalMonedas() {
        String jsonConsultaGlobal = "{\"coins_count\":2054}";
        HttpClient hc = HttpClient.newHttpClient();
        HttpRequest peticionGlobal = HttpRequest.newBuilder()
                .uri(URI.create("https://api.coinlore.net/api/global/"))
                .GET()
                .build();


        try {
            HttpResponse<String> cuerpoPeticionGlobal = hc.send(peticionGlobal, HttpResponse.BodyHandlers.ofString());

            if (cuerpoPeticionGlobal.statusCode() == 200) {


                JsonObject objetoConsultaGlobal = new Gson().fromJson(jsonConsultaGlobal, JsonObject.class);
                return objetoConsultaGlobal.get("coins_count").getAsInt();

            } else {
                throw new InterruptedException();
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("ERROR AL REALIZAR LA PETICION" + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public static void peticionMoneda() {
        //Declaramos el limite superior de la busqueda usando la funcion anterior
        int limite = peticionGlobalMonedas();
        //Definimos el cliente
        HttpClient clienteMoneda = HttpClient.newHttpClient();
        //definimos la consulta
        HttpRequest peticionMoneda = HttpRequest.newBuilder()
                .uri(URI.create("https://api.coinlore.net/api/tickers/?start=0&limit=" + limite))
                .GET()
                .build();

        try {
            HttpResponse<String> respuestaMoneda = clienteMoneda.send(peticionMoneda, HttpResponse.BodyHandlers.ofString());

            //Definimos el Json
            String jsonMoneda = respuestaMoneda.body();
            //parseamos el cuerpo de la respuesta
            Gson gson = new Gson();
            moneda monedaBuscada = gson.fromJson(jsonMoneda, moneda.class);
            //
            List<moneda> listaMonedas = monedaBuscada.getListaMonedas();

        } catch (IOException | InterruptedException e) {


            System.err.println("ERROR AL REALIZAR LA PETICION" + e.getMessage());
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {


    }
}
