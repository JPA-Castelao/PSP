public class hiloPares extends Thread {
    int acumulador = 0;
    @Override
    public void run() {

        for (int i = 0; i < 1923; i += 2) {
            acumulador += i;
        }
        System.out.println("Soy el hilo de  IMPARES y esto es lo que he sumado: " + acumulador);

    }
//        int acumulador = 0;
//        for (int i = 0; i < 1923; i++) {
//            if (i % 2 == 0) {
//                acumulador += i;
//                System.out.println("Soy el hilo de  PARES y esto es lo que he sumado: " + acumulador);
//
//            } else {
//                try {
//                    this.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//        }

    }


