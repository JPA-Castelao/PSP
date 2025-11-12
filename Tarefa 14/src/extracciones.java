public class extracciones extends Thread {

    public void extracciones() {

    }

    @Override
    public void run() {

        int pagos = 3000;
        while (pagos > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            caja.capital -= 10;
            pagos--;
        }


    }


}
