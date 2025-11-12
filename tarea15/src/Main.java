//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        hilo hilo1 = new hilo("hilo1");
        hilo hilo2 = new hilo("hilo2");
        hilo hilo3 = new hilo("hilo3");


        hilo3.start();
        try {
           hilo3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("FIn del programa");

    }
}