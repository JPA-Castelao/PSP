import java.util.ArrayList;

public class hilo extends Thread {
    String nombre;

    public hilo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {

            for (int i = 1; i <= 8; i++) {
                System.out.println("Soy el bucle " + this.nombre + " Y esta es mi iteraccion nº" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

    }

}
