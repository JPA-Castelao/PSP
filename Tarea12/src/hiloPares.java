public class hiloPares extends Thread {

    int numero, contador = 0;

    public hiloPares(int numero) {
        this.numero = numero;

    }

    @Override
    public void run() {
        for (int i = 1; i <= 1923; i++) {

            if (i % 2 == 0) {
                System.out.println("Contador de numeros pares: " + contador);
                contador++;

            }else if(i % 2 != 0){
                System.out.println("Esto es impar: " );
                contador++;
            }



        }
        System.out.println("La suma de: " + getName() + "es: " + contador);
    }
}