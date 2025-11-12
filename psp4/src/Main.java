//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {


    public static void mostrarDirectorioYUserDir(){

//        if(System.getProperty("os.name").contains("Windows".toLowerCase())) {
//            String rutaActual = System.getProperty("user.dir");
//            System.out.println(rutaActual);
//            System.setProperty("user.dir", "/home");
//            System.out.println(System.getProperty("user.dir"));
//            System.setProperty("user.dir", "/temp");
//            System.out.println(System.getProperty("user.dir"));
//
//        } else  {

            String rutaActual = System.getProperty("user.dir");
            System.out.println(rutaActual);

            System.setProperty("user.dir", "/home");
            System.out.println(System.getProperty("user.dir"));

            System.setProperty("user.dir", "/temp");
            System.out.println(System.getProperty("user.dir"));

        //}
    }
    public static void main(String[] args) {
        mostrarDirectorioYUserDir();

    }
}