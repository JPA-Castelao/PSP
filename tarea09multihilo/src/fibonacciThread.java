public class fibonacciThread extends Thread{
private int n;
    /**
     * Cosntructor que inicializa la clase fibonacciThread
     * @param n es el limite de la sucesion
     */

    public fibonacciThread(int n){
        super("Fibonacci");
    }

    /**
     * Sobreescritura del metodo run()
     */
    @Override

    public void run(){
       int[] arrayFN=new int[]{1,1};
      int acumuladorFN=0;
        for(int i=2;i<n;i++){
            acumuladorFN
        }
    }
}
