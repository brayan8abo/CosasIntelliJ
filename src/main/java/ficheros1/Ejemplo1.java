package ficheros1;

import java.io.File;
import java.io.IOException;

public class Ejemplo1 {
    public static void main(String[] args) throws IOException {


        File miDir = new File("C:\\dir1\\dir2\\dir3\\dir4");

        if (miDir.exists()) {
            System.out.println("Dir SÍ existe");
        } else {
            System.out.println("Dir NO existe");
            if (miDir.mkdirs()) {
                System.out.println("Dir creado");
            } else {
                System.out.println("Directorio NO creado");
            }
        }


        File miFich = new File(miDir, "fich1");

        File miFich2 = new File(miDir, "fich2");

        try {
            if (miFich.createNewFile()) {
                System.out.println("Fichero creado");
                if (miFich.renameTo(miFich2)) {
                    System.out.println("Fichero renombrado");
                } else {
                    System.out.println("Fichero NO renombrado");
                }


            } else {
                System.out.println("Fichero NO creado");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (miFich2.delete()) {
            System.out.println("Fichero borrado");
        } else {
            System.out.println("Fichero NO borrado");
        }

        File[] ficheros = miDir.listFiles();

        for (File f : ficheros) {
            if (f.isFile()) {
                System.out.print("Fichero: ");
            }
            if (f.isDirectory()) {
                System.out.println("Directorio: ");
            }
            System.out.println(f.getAbsolutePath());

        }

    }
}
