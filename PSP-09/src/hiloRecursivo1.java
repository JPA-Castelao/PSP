public class hiloRecursivo1 extends Thread {

    int longitudSucesion;

    public hiloRecursivo1(int longitudSucesion) {
        this.longitudSucesion = longitudSucesion;
    }

    @Override
    public void run() {
        hiloRecursivo2 hilo2 = new hiloRecursivo2(this.longitudSucesion);
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
