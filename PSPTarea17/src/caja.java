public class caja {

    private static double capital = 1000.00;

    public synchronized void ingresar() {

        for (int i = 0; i < 5000; i++) {
            System.out.println("Saldo actual: " + capital);
            capital += 10.00;
            try {
                wait(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("SALDO ACTUAL: " + capital);

    }

    public synchronized void extraer() {
        for (int i = 0; i < 3000; i++) {
            System.out.println("Saldo actual: " + capital);
            capital -= 10.00;
            try {
                wait(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("SALDO ACTUAL: " + capital);

    }

    public static void main(String[] args) {

        caja c = new caja();
        Thread h1 = new Thread(() -> c.ingresar());
        Thread h2 = new Thread(() -> c.extraer());
        h1.start();
        h2.start();


    }


//    private final Object lockA = new Object();
//
//    void ingresar() {
//        synchronized (lockA) {
//            capital += 50000.00;
//        }
//    }
//
//    void extraer() {
//        synchronized (lockA) {
//            capital -= 30000.00;
//        }
//    }
//
//    public static void main(String[] args) {
//
//        caja c = new caja();
//
//        Thread h1 = new Thread(() -> c.ingresar(), "Hilo1");
//        Thread h2 = new Thread(() -> c.extraer(), "Hilo2");
//
//        h1.start();
//        h2.start();
//        System.out.println(c.capital);
//    }


}
