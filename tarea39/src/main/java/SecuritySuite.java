import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HexFormat;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SecuritySuite {
    public static void main(String[] args) {

        //auditoria ss = new auditoria("4a630b8e79a0cd2fbae3f58e751abb28d0f4918f76af188d8996f13fabe08af8");
        decodificadorCesar dc = new decodificadorCesar("KRÑD");
    }

    public static class auditoria {

        MessageDigest md;

        {
            try {
                md = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        public auditoria(String contraseña) {

            byte[] contraseñaEnBytes = HexFormat.of().parseHex(contraseña);

            busquedaDiccionario(contraseñaEnBytes);
        }

        public void busquedaDiccionario(byte[] comparar) {

            try (BufferedReader br = new BufferedReader(new FileReader("/home/dam/psp/PSP/tarea39/src/main/diccionario.txt"))) {

                String entrada;
                byte[] entradaEnBytes;
                while ((entrada = br.readLine()) != null) {
                    entradaEnBytes = md.digest((entrada.strip()).getBytes());

                    if (Arrays.equals(comparar, entradaEnBytes)) {
                        System.out.println("¡CONTRASEÑA ENCONTRADA! La clave es:[" + entrada + "]");
                        break;
                    } else {
                        System.out.println("CONTRASEÑA SEGURA");
                        break;
                    }

                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

    }

    public static class decodificadorCesar {


        ArrayList<String> claveDecodificada = new ArrayList<>();


        public void compararPartesClave(char[] palabra) {
            char[] aux = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
            ArrayList<Character> alfabeto = new ArrayList<>();
            for (char c : aux) {

                alfabeto.add(c);
            }
            ArrayList<Character> palabraNueva;
            int longitudAlfabeto = alfabeto.size();


            for (int i = 0; i < longitudAlfabeto; i++) {
                palabraNueva = new ArrayList<>();
                for (char c : palabra) {

                    int nuevaPosicion = (alfabeto.indexOf(c) + i) % longitudAlfabeto;

                    palabraNueva.add(alfabeto.get(nuevaPosicion));
                }

                StringBuilder sb = new StringBuilder();
                for (Character ch : palabraNueva) {
                    sb.append(ch);
                }
                comprobacionAPI(sb.toString());

            }


        }

        public decodificadorCesar(String clave) {
//            //Quitamos los espacios y convertimos la caedena en array de Strings
//            String[] partesClave = clave.toUpperCase().split("//s+");
//
//            char[] caracteresParteClave;
//
//
//            //variable auxiliar para enviar al metodo comprobacionAPI
//            ArrayList<Character> palabraParaComprobar = new ArrayList<>();
//
//            //Recorremos cada elemento del String que formaba la cadena original
//            for (String s : partesClave) {
//                //Convertimos cada String de la cadena en un array de caracteres
//                for (String parte : partesClave) {
//                    caracteresParteClave = parte.toCharArray();
//
//
//                }
//
//
//            }
//
            compararPartesClave(clave.toCharArray());

        }


        public void comprobacionAPI(String palabra) {
            String api = "https://api.languagetool.org/v2/check";
            try {

                String formatoPeticion = "text=" + palabra + "&language=es-ES";
                HttpClient cliente = HttpClient.newHttpClient();
                HttpRequest peticion = HttpRequest.newBuilder().uri(URI.create(api)).header("Content-Type", "application/x-www-form-urlencoded").POST(HttpRequest.BodyPublishers.ofString(formatoPeticion)).build();


                HttpResponse<String> response = cliente.send(peticion, HttpResponse.BodyHandlers.ofString());
                Gson gson = new Gson();

                JsonObject respuesta = gson.fromJson(response.body(), JsonObject.class);
                JsonArray arrayJson = respuesta.getAsJsonArray("matches");

                if (arrayJson.isEmpty()) {
                    System.out.println(palabra + " existe");
                } else {
                    System.out.println(palabra + " no existe");

                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }


}







