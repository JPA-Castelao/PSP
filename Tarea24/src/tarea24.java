import java.net.*;

public class tarea24 {

    public void nombre(String nombreDominio) {

        try {
            InetAddress ip = InetAddress.getByName(nombreDominio);
            System.out.println("La IP de " + nombreDominio + " es " + ip.getHostAddress());

            InetAddress local = InetAddress.getLocalHost();
            System.out.println("La IP local es : " + local.getHostAddress());
            System.out.println("El hoest local es : " + local.getHostName());
        } catch (UnknownHostException e) {
            System.err.println("ERROR TIPO" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        tarea24 t = new tarea24();
        t.nombre("www.google.com");

    }


}
