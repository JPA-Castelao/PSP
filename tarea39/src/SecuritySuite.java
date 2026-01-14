import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.List;

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

            try (BufferedReader br = new BufferedReader(new FileReader("/home/dam/psp/PSP/tarea39/src/diccionario.txt"))) {

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


        public decodificadorCesar(String clave) {
            String[] claveEnArray = clave.split("//s+");
            char[] elementoClaveEnArray;
            for (String s : claveEnArray) {

                elementoClaveEnArray = s.toCharArray();

                recorrerElementosClave(elementoClaveEnArray);
            }

        }

        public void recorrerElementosClave(char[] elementoARecorrer) {





        }

    }

    public static void main(String[] args) {
        //auditoria ss = new auditoria("4a630b8e79a0cd2fbae3f58e751abb28d0f4918f76af188d8996f13fabe08af8");

    }

}
