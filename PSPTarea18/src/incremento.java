public class incremento {
    private int contador;
    private final Object lockA = new Object();

    public void incrementar() {

        synchronized (lockA) {
            for (int i = 0; i < 50; i++) {
                this.contador += 1;
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notifyAll();
        }


    }

    public static void main(String[] args) {
        incremento i = new incremento();

        Thread h1 = new Thread(() -> i.incrementar());
        Thread h2 = new Thread(() -> i.incrementar());
        Thread h3 = new Thread(() -> i.incrementar());
        Thread h4 = new Thread(() -> i.incrementar());
        Thread h5 = new Thread(() -> i.incrementar());
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

    }

}