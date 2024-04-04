package Ficheros2;

import java.io.IOException;

public class Ejemplo1LecturaLinea {
    public static void main(String[] args) {

        int c, contador = 0;
        while (true) {
            try {
                if (!((c = System.in.read()) != '\n'))
                    break; //me agarra lo que teclle hasta que ponga espacio, y el read me devuelve BYTES que son enteros, se debe hacer cast para ver la letra como tal
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            contador++;
            System.out.println((char) c);
        }


    }
}
