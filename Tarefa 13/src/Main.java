//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        hiloIteracion hilo1 = new hiloIteracion("hilo 1");
        hiloIteracion hilo2 = new hiloIteracion("hilo 2");
        hiloIteracion hilo3 = new hiloIteracion("hilo 3");
        hiloIteracion hilo4 = new hiloIteracion("hilo 4");
        hilo1.setPriority(Thread.MAX_PRIORITY);
        hilo2.setPriority(Thread.MIN_PRIORITY);
        hilo3.setPriority(Thread.NORM_PRIORITY);
        hilo4.setPriority(Thread.NORM_PRIORITY);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

    }
}