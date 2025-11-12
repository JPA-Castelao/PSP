public class hilo3o4 extends Thread {
    int acumulador;

    @Override
    public void run() {
        for (int i = 0; i < 1923; i++) {
            if (i % 10 == 3 || i % 10 == 4) {
                acumulador += i;
            }
        }
        System.out.println("Soy el hilo de  TRES O CUATRO y esto es lo que he sumado: " + acumulador);

    }


//    @Override
//    public void run() {
//        for (int i = 0; i < 1923; i++) {
//            if (i % 10 == 3 || i % 10 == 4) {
//                acumulador += i;
//                System.out.println("Soy el hilo de  TRES O CUATRO y esto es lo que he sumado: " + acumulador);
//            } else {
//                try {
//                    this.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//        }
//    }
}
