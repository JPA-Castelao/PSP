import java.util.ArrayList;

public class hiloFib extends Thread {
    int longitudSucesion;
    int contador = 0;

    public hiloFib(int longitudSucesion) {
        this.longitudSucesion = longitudSucesion;
    }


    @Override
    public void run() {

        int[] contador = new int[3];
        contador[0] = 1;
        contador[1] = 1;
        contador[2] = contador[1] + contador[0];
        System.out.printf("\n El fibonacci %d es %d", 1, contador[0]);
        System.out.printf("\n El fibonacci %d es %d", 2, contador[1]);
        for (int i = 3; i < this.longitudSucesion; i++) {
            contador[0] = contador[1];
            contador[1] = contador[2];
            contador[2] = contador[1] + contador[0];
            System.out.printf("\n El fibonacci %d es %d", i, contador[2]);
        }

        System.out.println("El  Fibonacci ha contado hasta: " + contador);
    }
}
