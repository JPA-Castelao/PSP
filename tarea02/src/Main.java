import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
//metodo para crear o abrir un archivo
    public static void creaArchivo(){

        Scanner sc= new Scanner(System.in);
        System.out.println("nombre del archivo");
        String nombreArchivo=sc.nextLine();
        if((nombreArchivo.trim()).isEmpty()){
            nombreArchivo="ArchivoPorDefecto.txt";
        }

        File rutaArchivo;

        System.out.println("Ruta del archivo");
        String ruta=sc.nextLine();
        if((ruta.trim()).isEmpty()){
            ruta=System.getProperty("user.dir");
        } else  {
            rutaArchivo= new File(ruta);
            if(!rutaArchivo.exists()){
                rutaArchivo.mkdir();
                ruta=rutaArchivo.getAbsolutePath();
            }
        }


        String[] comandos=  {"gnome-text-editor",nombreArchivo};
       ProcessBuilder procesoCreador= new ProcessBuilder(comandos);
       // ProcessBuilder procesoCreador= new ProcessBuilder("gnome-terminal",nombreArchivo);
        procesoCreador.directory(new File(ruta));


        try{
          Process p=  procesoCreador.start();
        }catch (IOException e){

        }
    }
//main

    public static void main(String[] args) {

creaArchivo();

    }



}