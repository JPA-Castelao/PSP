public class hiloRecursivo2 extends Thread {
    int longitudSucesion;

    public int fib1 = 1, fib2 = 1, fib3 = fib1 + fib2;

    public hiloRecursivo2(int longitudSucesion) {
        this.longitudSucesion = longitudSucesion;

    }

    @Override
    public void run() {

        for (int i = 0; i < this.longitudSucesion; i++) {
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib1 + fib2;
        }


    }
}