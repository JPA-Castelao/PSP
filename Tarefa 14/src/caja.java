public class caja {

    public static double capital=1000;


    public static void main(String[] args) {
        ingresos ingresos1= new ingresos();
        extracciones extracciones1= new extracciones();

        ingresos1.start();

        try {
            ingresos1.join();
            extracciones1.start();
            extracciones1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(capital);

    }


}
