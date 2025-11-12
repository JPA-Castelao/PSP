public class claseThread extends Thread {
    int cabreoLevel;

    /**
     * cosntructor que recibe el nombre del profesor
     * y el limite veces que se va a ejecutar el hilo
     * lo pasa a  la clase padre para inicializarlo
     *
     * @param nombreProfe es el nombre de este hilo
     * @apram cabreoLevel es el limite de ejecuciones
     */
    public claseThread(String nombreProfe, int cabreoLevel) {
        super(nombreProfe);
        this.cabreoLevel = cabreoLevel;
    }

    //Esto es lo que hará el hilo

    @Override
    public void run() {
        int contadorCabeo = 0;
        while (contadorCabeo < cabreoLevel) {
            contadorCabeo++;
            System.out.printf("\n [%s] Cabreo nivel:%d", getName(), contadorCabeo);

            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("\n [%s] Cabreo nivel: %d ... !He llegado a mi limite¡", getName(), contadorCabeo);


    }


    public static void main(String[] args) throws InterruptedException {

        claseThread diego = new claseThread("Diego", 5);
        claseThread manuel = new claseThread("Manuel", 6);
        claseThread araujo = new claseThread("Araujo", 7);
        claseThread damian = new claseThread("Damian", 15);

        diego.start();
        manuel.start();
        araujo.start();
        damian.start();
    }


}


