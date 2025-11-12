//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int contador = 0;

    public static void main(String[] args) {


        hilo hilo1 = new hilo("hilo1");
        hilo1.start();
        hilo hilo2 = new hilo("hilo2");
        hilo2.start();
        hilo hilo3 = new hilo("hilo3");
        hilo3.start();
        hilo hilo4 = new hilo("hilo4");
        hilo4.start();
        hilo hilo5 = new hilo("hilo5");
        hilo5.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
            hilo5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("El resultado es " + contador);

    }

}