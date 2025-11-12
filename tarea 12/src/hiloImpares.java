public class hiloImpares extends Thread {
    int acumulador = 0;
    @Override
    public void run() {
        for (int i = 0; i < 1923; i++) {
            acumulador += i;

        }
        System.out.println("Soy el hilo de  IMPARES y esto es lo que he sumado: " + acumulador);

    }



//        for (int i = 0; i < 1923; i++) {
//            if (i % 2 != 0) {
//                acumulador += i;
//                System.out.println("Soy el hilo de  IMPARES y esto es lo que he sumado: " + acumulador);
//            }else{
//                try {
//                    this.sleep(100);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//
//        }
    //}




    }

