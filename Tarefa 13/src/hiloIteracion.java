public class hiloIteracion extends Thread {


    public hiloIteracion(String nombre) {
        super(nombre);
    }


    @Override
    public void run() {
        int numeroRandom = (int) (Math.random() * (10 - 1 + 1)) + 1;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Soy el " + super.getName() + " y esta es mi vuelta " + i+" Mi prioridad es "+this.getPriority());
            try {
                sleep(numeroRandom * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
