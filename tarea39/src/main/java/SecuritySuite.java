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

        public decodificadorCesar(String clave) {

            String[] aux = clave.toUpperCase().split("//s+");
            ArrayList<String> palabrasClave = new ArrayList<>();
            ArrayList<Character> caracteresClave = new ArrayList<>();

            for (String claveAux : aux) {
                palabrasClave.add(claveAux);
            }
            for (String claveAux : palabrasClave) {
                for (char c : claveAux.toCharArray()) {
                    caracteresClave.add(c);
                }


            }


        }

        public void compararCaracteresClave(ArrayList<Character> lista) {
            ArrayList<Character> palabraDecodificada = new ArrayList<>();
            char[] alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();


            for (char c : alfabeto) {

                for (Character ch : lista) {

                    if (!ch.equals(c)) {
                        palabraDecodificada.add(ch);
                    }
                }


            }


        }

        public boolean comprobacionAPI(String palabra) {
            Gson gson = new Gson();
            try {





            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }


    }


    public static void main(String[] args) {
        //auditoria ss = new auditoria("4a630b8e79a0cd2fbae3f58e751abb28d0f4918f76af188d8996f13fabe08af8");

    }

}
