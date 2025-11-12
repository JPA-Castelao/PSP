public class ingresos extends Thread {

    public void ingresos() {

    }

    @Override
    public void run() {
        int ventas = 5000;
        while (ventas > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            caja.capital += 10;
            ventas--;
        }

    }


}
