//package Pruebas;
//
//public class ola {
//    public static void main(String[] args) {
//
//        La herencia en programación es un concepto fundamental en la programación orientada a objetos (POO). Permite que una clase (llamada subclase o clase derivada) herede atributos y métodos de otra clase (llamada superclase o clase base). Esto facilita la reutilización de código y la creación de estructuras jerárquicas de clases.
//                Beneficios de la Herencia
//
//        Reutilización de Código: Permite reutilizar código existente en lugar de escribirlo de nuevo, lo que ahorra tiempo y reduce errores.
//        Mantenimiento Simplificado: Al tener un código común en una superclase, cualquier cambio en esa clase se propaga a todas las subclases, facilitando el mantenimiento y la actualización del código.
//                Organización y Jerarquía: Facilita la organización del código mediante una estructura jerárquica, donde las relaciones entre clases son claras y bien definidas.
//                Extensibilidad: Las clases existentes pueden ser extendidas para crear nuevas funcionalidades sin modificar el código original.
//                Polimorfismo: Permite tratar objetos de diferentes clases derivadas de la misma superclase como si fueran del tipo de la superclase, simplificando el manejo de objetos distintos de manera uniforme.
//
//        Ejemplo de Herencia en Python
//
//        class Animal {
//    private String nombre;
//
//    public Animal(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void hacerSonido() {
//        System.out.println("El animal hace un sonido");
//    }
//}
//
//// Clase derivada
//class Perro extends Animal {
//    public Perro(String nombre) {
//        super(nombre);
//    }
//
//    @Override
//    public void hacerSonido() {
//        System.out.println("Guau");
//    }
//}
//
//// Clase derivada
//class Gato extends Animal {
//    public Gato(String nombre) {
//        super(nombre);
//    }
//
//    @Override
//    public void hacerSonido() {
//        System.out.println("Miau");
//    }
//}
//
//// Clase principal para probar las clases anteriores
//public class Main {
//    public static void main(String[] args) {
//        Animal miPerro = new Perro("Rex");
//        Animal miGato = new Gato("Whiskers");
//
//        System.out.println(miPerro.getNombre() + " dice:");
//        miPerro.hacerSonido();  // Salida: Guau
//
//        System.out.println(miGato.getNombre() + " dice:");
//        miGato.hacerSonido();  // Salida: Miau
//    }
//}
//
//Explicación
//
//    Clase Animal: Es la clase base que tiene un constructor para inicializar el nombre del animal, un método getNombre para obtener el nombre, y un método hacerSonido que simplemente imprime un mensaje genérico. Este método será sobrescrito por las clases derivadas.
//
//    Clase Perro: Es una clase derivada que extiende Animal. Tiene su propio constructor que llama al constructor de la clase base usando super(nombre). El método hacerSonido es sobrescrito para proporcionar la implementación específica para perros.
//
//    Clase Gato: Similar a Perro, esta clase extiende Animal y sobrescribe el método hacerSonido para proporcionar la implementación específica para gatos.
//
//    Clase Main: Es la clase principal que contiene el método main. Aquí se crean instancias de Perro y Gato, y se llaman a sus métodos hacerSonido para demostrar la funcionalidad de la herencia.
//
//Este ejemplo demuestra cómo la herencia permite a las clases derivadas reutilizar el código de la clase base y también sobrescribir métodos para proporcionar comportamientos específicos.

