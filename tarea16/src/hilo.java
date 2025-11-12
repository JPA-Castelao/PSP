public class hilo extends Thread {

    public hilo(String nombre) {
        super.setName(nombre);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50; i++) {

                sleep(100);

                Main.contador += 1;

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
