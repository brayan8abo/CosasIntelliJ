package ficheros.ficheros1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;



public class Ejemplo2Listar implements FilenameFilter {

    String extension;
    Ejemplo2Listar(String extension){
        this.extension=extension;
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        String rutaDirectorio = "C:/dir1";
        File directorio = new File(rutaDirectorio);

        System.out.println("Introducir extensión");
        String extension = leer.nextLine();

        Ejemplo2Listar filtro = new Ejemplo2Listar(extension); /*objeto*/

        File[] archivosTXT = directorio.listFiles(filtro);
        for (File file : archivosTXT) {
            System.out.println(file.getAbsolutePath());

        }


    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(extension); // pasa a minusculas, y me busca lo que termine en .rtf o como le ponga
    }
}
