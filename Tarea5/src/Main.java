import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void getCodigoFinalizacion() {
        Scanner sc = new Scanner(System.in);
        String[] listaComando;
        String comando;
        String salir="";
        ProcessBuilder pb;




        while(!salir.equals("salir")){
            System.out.println("Introduce Comando");
            comando = sc.nextLine();
            listaComando = (comando.split(" "));

            pb = new ProcessBuilder(listaComando);

            try {
           pb.inheritIO();
           Process p= pb.start();
           int exitCode= p.waitFor();


           System.out.println("Nombre:"+pb.command().get(0));
            System.out.println("Codigo salida: "+ exitCode);
                System.out.println("salir?");
                salir = sc.nextLine();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

        }




    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        getCodigoFinalizacion();

    }
}