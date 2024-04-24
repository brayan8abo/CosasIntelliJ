package ficheros.ficheros1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Ejemplo3Listar {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        String rutaDirectorio = "C:/dir1";
        File directorio = new File(rutaDirectorio);
        System.out.println("Dame una extension para buscar");
        String extensionDeseada = leer.nextLine();


//        File[] archivosTXT = directorio.listFiles(new FilenameFilter() {
//                                                      @Override
//                                                      public boolean accept(File dir, String name) {
//                                                          return name.toLowerCase().endsWith(extensionDeseada); // pasa a minusculas, y me busca lo que termine en .rtf o como le ponga
//                                                      }
//                                                  }
//
//        );

        File[] archivosTXT = directorio.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt")); // lo mismo que el metodo, pero mas sencillo, lo que esta en el directorio.ListFiles((dir,name) son los parametros que usa el metodo accept



        for (File file : archivosTXT) {
            System.out.println(file.getAbsolutePath());

        }
    }
}
