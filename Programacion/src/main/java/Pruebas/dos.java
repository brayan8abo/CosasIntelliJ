//package Pruebas;
//
//public class dos {
//    Una interfaz en programación es un conjunto de métodos abstractos que una clase debe implementar. No proporciona la implementación de estos métodos, sino solo sus firmas. Las interfaces permiten definir un contrato que las clases deben cumplir, garantizando que implementarán ciertos métodos. Esto es especialmente útil para asegurar que diferentes clases pueden ser usadas de manera intercambiable si implementan la misma interfaz.
//    Beneficios de las Interfaces
//
//    Desacoplamiento: Permiten reducir la dependencia entre componentes del sistema, promoviendo un diseño más modular y flexible.
//    Polimorfismo: Facilitan la implementación del polimorfismo, permitiendo que diferentes clases sean tratadas de la misma manera si implementan la misma interfaz.
//            Flexibilidad: Facilitan la modificación del comportamiento del sistema sin cambiar el código que depende de las interfaces, lo que mejora la capacidad de extensión y mantenimiento del código.
//    Claridad y Documentación: Proporcionan una manera clara y formal de definir cómo las clases deben interactuar, actuando como documentación y mejorando la comprensión del código.
//    Pruebas y Mocks: Hacen más fácil la creación de mocks y stubs para pruebas unitarias, ya que se puede implementar la interfaz sin necesidad de una implementación completa.
//
//    Ejemplo de Interfaz en Java
//
//    En Java, una interfaz se define con la palabra clave interface. Aquí tienes un ejemplo:
//
//    java
//
//    // Definición de la interfaz
//    interface Animal {
//        void hacerSonido();
//    }
//
//    // Implementación de la interfaz en una clase
//    class Perro implements Animal {
//        @Override
//        public void hacerSonido() {
//            System.out.println("Guau");
//        }
//    }
//
//    // Implementación de la interfaz en otra clase
//    class Gato implements Animal {
//        @Override
//        public void hacerSonido() {
//            System.out.println("Miau");
//        }
//    }
//
//    // Clase principal para probar las implementaciones
//    public class Main {
//        public static void main(String[] args) {
//            Animal miPerro = new Perro();
//            Animal miGato = new Gato();
//
//            miPerro.hacerSonido();  // Salida: Guau
//            miGato.hacerSonido();   // Salida: Miau
//        }
//    }
//
//    Explicación
//
//    Interfaz Animal: Define un método hacerSonido que todas las clases que implementen esta interfaz deben definir.
//
//    Clase Perro: Implementa la interfaz Animal y proporciona una implementación específica del método hacerSonido.
//
//    Clase Gato: También implementa la interfaz Animal y proporciona su propia implementación del método hacerSonido.
//
//    Clase Main: Es la clase principal que contiene el método main. Aquí se crean instancias de Perro y Gato, que son tratadas como objetos de tipo Animal. Esto demuestra cómo se puede usar polimorfismo para llamar al método hacerSonido de manera uniforme.
//
//    Este ejemplo muestra cómo las interfaces permiten definir un contrato que las clases pueden implementar, proporcionando flexibilidad y mejorando la capacidad de mantener y extender el código.
//    ChatGPT puede cometer errores. C
//}
