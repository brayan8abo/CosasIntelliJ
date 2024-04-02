package ficheros1;

import java.io.File;

public class Ejemplo1 {
    public static void main(String[] args) {


        File miDir = new File("C:\\dir1");

        if (miDir.exists()){
            System.out.println("Dir existe");
        } else {
            System.out.println("Dir no existe");
        }
    }
}
