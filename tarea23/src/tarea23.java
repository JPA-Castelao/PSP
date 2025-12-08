import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class tarea23 {

    public static void main(String[] args) {

        superMercado sm = new superMercado(4);

        creadorClientes cc = new creadorClientes(20, sm);


    }


}

class creadorClientes {

    ArrayList<cliente> clientes = new ArrayList<>();

    public creadorClientes(int numeroClientes, superMercado sm) {
        crearClientes(numeroClientes, sm);
    }

    public void crearClientes(int numeroClientes, superMercado sm) {

        for (int i = 1; i <= numeroClientes; i++) {

            cliente c = new cliente(i, sm);
            clientes.add(c);
        }

        for (cliente c : clientes) {
            c.start();
        }


    }
}


class cliente extends Thread {

    public int importe;

    private superMercado sm;

    public cliente(int numeroCliente, superMercado sm) {

        super(("cliente" + numeroCliente));
        this.sm = sm;


    }

    @Override
    public void run() {

        this.importe = ((int) ((Math.random() * 100) + 1));

        try {
            sm.supermerk2(this.getName(), importe);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}


class superMercado {

    private Semaphore cajas;

    public int Resultados;

    public superMercado(int numeroCajas) {
        cajas = new Semaphore(numeroCajas);
    }

    public void supermerk2(String nombreCliente, int importe) throws InterruptedException {

        sleep(((int) ((Math.random() * 4) + 1)) * 1000L);
        if (cajas.availablePermits() > 0) {
            cajas.acquire();
            System.out.println("HAY " + cajas.availablePermits() + " CAJAS LIBRES ");

            try {


                System.out.println("EL CLIENTE " + nombreCliente + " ESTÁ SIENDO ATENDIDO ");
                Resultados += importe;
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("EL CLIENTE " + nombreCliente + " ABANDONA EL SUPERMERCADO ");
                System.out.println("IMPORTE TOTAL HASTA EL MOMENTO " + Resultados);

                cajas.release();
            }
        } else {
            System.out.println("EL CLIENTE " + nombreCliente + " DEBE ESPERAR POR UNA CAJA LIBRE ");

        }

    }


}