package programcion.PT.PT5Exam;

import java.util.ArrayList;
import java.util.Scanner;

public class PT5 {
    //===== GESTIÓN DE ZOOLÓGICO =====
//1. Mostrar todos los animales
//2. Buscar un animal por código
//3. Agregar ejemplares a un animal
//4. Retirar ejemplares de un animal
//5. Eliminar un animal
//6. Salir

    public static void main(String[] args) {

        // Creamos un scanner para leer la opcion del menu
        Scanner scanner = new Scanner(System.in);
        // Definimos variables. 
        final int MAXANIMALES = 1000;
        final int SALIR = 6;
        int opcion = 0;
        String codigoABuscar = "";
        Animal animalEncontrado = null;
        int cantidadModificada = 0;
        String mensajeMenu = "====GESTION DE ZOOLOGICO =====\n\n"
                + "   1. Mostrar todos los animales.\n"
                + "   2. Buscar un animal por codigo.\n"
                + "   3. Agregar ejemplares a un animal\n"
                + "   4. Retirar ejemplares de un animal.\n"
                + "   5. Eliminar un animal\n"
                + "   6. Salir.\n";
        // creamos y llenamos el array de animales. 
        ArrayList<Animal> animales = new ArrayList<>();
        for (int i = 0; i < MAXANIMALES; i++) {
            animales.add(new Animal("ANIMAL" + i, i + 15, i + 23 * i * 0.35));
        }
        // creamos el objeto zoologico usando el constructor de zoologico que recibe un array de animales.
        Zoologico zoo1 = new Zoologico(animales);

        // hacemos un bucle while para mostrar el menu hasta que el usuario quiera salir. 
        while (opcion != SALIR) {
            System.out.println(mensajeMenu);
            System.out.print("Ingrese una opcion: ");
            // Leemos la opcion del menu. y lo limpiamos con el nextLine.
            opcion = scanner.nextInt();
            scanner.nextLine();
            // iniciamos con la opcion 1. mostrar todos los animales. 

            if (opcion == 1) {
                System.out.println(zoo1.mostrarTodosLosAnimales());

                // Opcion 2. Buscar un animal por codigo.
            } else if (opcion == 2) {
                System.out.println("Ingrese el codigo del animal a buscar:  ");
                codigoABuscar = scanner.nextLine();

                // Si lo encuentra, devuelve el animal encontrado.
                animalEncontrado = zoo1.buscarAnimal(codigoABuscar);

                if (animalEncontrado != null) {
                    System.out.println("Animal encontrado: \n" + animalEncontrado);
                } else {
                    System.out.println("Animal no encontrado: " + codigoABuscar);
                }

                //Opcion 3. Agregar ejemplares a un animal.
            } else if (opcion == 3) {
                System.out.println("Ingrese el codigo del animal del ejemplar agregado: ");
                codigoABuscar = scanner.nextLine();
                System.out.println("Ingrese la cantidad de ejemplares a agregar: ");
                cantidadModificada = scanner.nextInt();
                scanner.nextLine();

                // Devolvemos true si puedo sumarlos.
                if (zoo1.agregarEjemplares(codigoABuscar, cantidadModificada)) {
                    System.out.println("Se han agregado " + cantidadModificada + " ejemplares.");
                } else {
                    System.out.println("Animal no encontrado: " + codigoABuscar);
                }
                // Opcion 4. Retirar ejemplares de un animal.
            } else if (opcion == 4) {

                System.out.println("Ingrese el codigo del animal a retirar: ");
                codigoABuscar = scanner.nextLine();
                System.out.println("Ingrese la cantidad a retirar: ");
                cantidadModificada = scanner.nextInt();
                scanner.nextLine();

                //Buscamos al animal, para saber si existe. 
                animalEncontrado = zoo1.buscarAnimal(codigoABuscar);

                if (animalEncontrado != null) {
                    // CUMPLE : "Si no existe: Animal no encontrado"
                    System.out.println("Animal no encontrado.");
                }else{
                    // El animal existe, ahora comprobamos si hay animales para retirar. 
                    //Comparamos lo que pide el usuario con la cantidad de ejemplares que hay.
                    if(cantidadModificada > animalEncontrado.getCantidad()){
                        //CUMPLE: si se intenta retirat mas de lo disponible...
                        System.out.println("No se puede retirar mas ejemplares de los disponibles. ");
                    }else{
                        // Si todo es correcto, procedemos retirar.
                        zoo1.retirarEjemplares(codigoABuscar, cantidadModificada);
                        System.out.println("Se han retirado los ejemplares.");
                    }
                }
                // Opcion 5. Eliminar un animal. 
            } else if (opcion == 5) {
                System.out.println("ingrese el codigo del animal a eliminar: ");
                codigoABuscar = scanner.nextLine();

                //Usamos retirarAnimal que solo borra si la cantidad es 0.
                if (zoo1.eliminarAnimal(codigoABuscar)) {
                    System.out.println("El animal con el codigo " + codigoABuscar + " ha sido eliminado.");
                } else {
                    System.out.println("No se ha podido eliminar el animal con el codigo " + codigoABuscar);
                }

            } else if (opcion == SALIR) {
                System.out.println("Saliendo del programa...");
            } else {
                System.out.println("Opcion no valida. Por favor, ingrese una opcion del 1 al " + SALIR);
            }

        }
        scanner.close();
    }

}
