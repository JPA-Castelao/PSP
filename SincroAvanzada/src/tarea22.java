import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class tarea22 {


    public static void main(String[] args) {

        parking p = new parking(10);

        trafico t = new trafico(17, p);
        t.crearTrafico();

    }


}

class trafico {

    private ArrayList<Coche> trafico = new ArrayList<>();

    private parking p;
    private int cantidadCoches;

    public trafico(int cantidadCoches, parking p) {
        this.cantidadCoches = cantidadCoches;
        this.p = p;
    }

    public void crearTrafico() {
        for (int i = 1; i <= this.cantidadCoches; i++) {

            Coche c = new Coche(("Coche" + i), p);
            this.trafico.add(c);
        }

        for (Coche c : trafico) {
            c.start();
        }

    }

}


class Coche extends Thread {

    private parking p;

    public Coche(String nombre, parking p) {
        super(nombre);
        this.p = p;

    }

    @Override
    public void run() {
        while (true) {


            try {
                p.entrar(this.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}


class parking {


    private final Semaphore plazas;

    public parking(int numeroPlazas) {
        plazas = new Semaphore(numeroPlazas);
    }


    public void entrar(String IDCoche) throws InterruptedException {
        sleep((int) ((Math.random() * 4) + 1) * 1000L);
        plazas.acquire();
        try {
            System.out.println("HA ENTRADO EL COCHE " + IDCoche);
            System.out.println("QUEDAN " + plazas.availablePermits() + " LIBRES");

        } catch (Exception e) {
            System.err.println("ERROR TIPO:" + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            sleep((int) ((Math.random() * 4) + 1) * 1000L);
            System.out.println("EL COCHE " + IDCoche + " VA A SALIR");
            plazas.release();
        }


    }


}
