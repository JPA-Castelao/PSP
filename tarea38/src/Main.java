import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.Scanner;
import java.security.MessageDigest;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String contraseña, BD, contraseña2;
        System.out.println("Introduce una contrañesa");
        contraseña = sc.nextLine();


        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(contraseña.getBytes());
            byte[] resumen = md.digest();
            md.reset();

            BD = HexFormat.of().formatHex(resumen);
            System.out.println(BD);


            System.out.println("Usuario registrado, inicie sesión");
            System.out.println("Introduce contraseña");
            contraseña2 = sc.nextLine();
            md.update(contraseña2.getBytes());
            byte[] resumen2 = md.digest();
            BD = HexFormat.of().formatHex(resumen2);
            System.out.println(BD);

            if (Arrays.equals(resumen, resumen2)) {
                System.out.println("ACCESO CONCEDIDO");
            } else {
                System.out.println("ERROR: Credenciales inválidas.");
            }

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }
}