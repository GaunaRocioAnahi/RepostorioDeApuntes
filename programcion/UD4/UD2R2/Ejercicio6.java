package programcion.UD4.UD2R2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio6 {

    public static void mostrarMenu() {
        System.out.println("1-Añadir nueva tarea.");
        System.out.println("2-Marcar una tarea como completada.");
        System.out.println("3-Ver lista de tareas pendientes.");
        System.out.println("4-Ver lista de tareas completadas");
        System.out.println("5-Salir del programa.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Arrays
        ArrayList<String> tarea = new ArrayList<>(Arrays.asList("tarea1", "tarea2", "tarea3"));
        ArrayList<Boolean> completada = new ArrayList<>(Arrays.asList(false, true, false));

        int opcion = 0;

        while (opcion != 5) {
            mostrarMenu();

            opcion = scanner.nextInt();
            scanner.nextLine();
            if (opcion == 1) {
                System.out.println("Añadir tarea nueva:");
                String tareaNueva = scanner.nextLine();
                tarea.add(tareaNueva);
                completada.add(false);// una tarea nueva siempre va a quedar como pendiente.
            } else if (opcion == 2) {
                System.out.println("Ingrese el nombre de la tarea que esta completa: ");
                String buscarTarea = scanner.nextLine();
                int indice = tarea.indexOf(buscarTarea);

                if (indice != -1) {
                    completada.set(indice, true);
                    System.out.println("¡Genial! la tarea " + buscarTarea + "tarea completa");

                } else {
                    System.out.println("Error: No encuentro esa tarea en la lista");
                }

            } else if (opcion == 3) {

                if (tarea.isEmpty()) {
                    System.out.println(" No hay tareas registradas");
                } else {
                    boolean haytareasPendientes = false;

                    for (int i = 0; i < tarea.size(); i++) {
                        if (completada.get(i) == false) {
                            System.out.println(" -" + tarea.get(i));

                            haytareasPendientes = true;
                        }
                    }
                }
            } else if (opcion == 4) {

                if (tarea.isEmpty()) {
                    System.out.println("No hay tareas pendiendte.");
                } else {
                    boolean hayTareasCompletadas = false;

                    for (int i = 0; i < tarea.size(); i++) {
                        if (completada.get(i) == true) {
                            System.out.println(" - " + tarea.get(i));

                            hayTareasCompletadas = true;
                        }
                    }
                }
            }
        }
        System.out.print("saliste del programa");
    }
}
/// podria tener una funcion para opcion 3 y 4. 
/// con el siguiente nombre function mostrarPorEstado( tarea, completada, true )--> para tarea completas en la opcion 4
/// mostrarPorEstado (tarea, completada, false ); --> para tareas pendientes.
/// // Función mágica que sirve para la Opción 3 Y la Opción 4
//public static void mostrarPorEstado(ArrayList<String> tareas, ArrayList<Boolean> ccompletaddas, boolean estadoBuscado) {
//    
//    // Título dinámico
//    if (estadoBuscado == true) {
//        System.out.println("--- LISTA DE COMPLETADAS ---");
//    } else {
//        System.out.println("--- LISTA DE PENDIENTES ---");
//    }
//
//    if (t.isEmpty()) {
//        System.out.println("No hay tareas.");
//        return;
//    }
//
//    // El mismo bucle de siempre
//    for (int i = 0; i < t.size(); i++) {
//        // Aquí comparamos con lo que le mandaste (estadoBuscado)
//        if (c.get(i) == estadoBuscado) {
//            System.out.println(" - " + t.get(i));
//        }
//    }
//}