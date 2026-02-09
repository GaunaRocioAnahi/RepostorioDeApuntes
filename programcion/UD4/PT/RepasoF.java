import java.util.ArrayList;
import java.util.Scanner;

public class RepasoF {
    // funcion para mostrar el menu
    public static void mostrarMenu() {
        System.out.println("1- Añadir plan");
        System.out.println("2- Listar plan");
        System.out.println("3- Evaluar plan");
        System.out.println("4- Eliminar plan");
        System.out.println("5- Salir");
    }

    // Función para mostrar el resultado final
    public static void mensajeAleatorio(String resultado) {
        System.out.println(" RESULTADO: " + resultado.toUpperCase() + " <<<");
        double azar = Math.random();

        if (resultado.equals("perfecto")) {
            if (azar < 0.5)
                System.out.println("¡Son almas gemelas!");
            else
                System.out.println("¡Triunfo total del amor!");
        } else if (resultado.equals("bien")) {
            if (azar < 0.5)
                System.out.println("Lo pasarán bien.");
            else
                System.out.println("Un plan sólido.");
        } else if (resultado.equals("regular")) {
            if (azar < 0.5)
                System.out.println("Cuidado con las discusiones.");
            else
                System.out.println("Al menos están juntos.");
        } else if (resultado.equals("fatal")) {
            if (azar < 0.5)
                System.out.println("¡Huyan! Saldrá mal.");
            else
                System.out.println("Mejor quedarse en casa.");
        }
    }

    // funcion para la opcion 1 que es añadir lista de plan.
    public static void aniadirPlan(Scanner scanner, ArrayList<String> listaNombrePersonaA,
            ArrayList<String> listaNombrePersonaB, ArrayList<String> listaPreferenciasB,
            ArrayList<String> listaPropuestaA) {
        System.out.println("Añadir plan");

        System.out.print("Nombre de la persona A: ");
        String nombreIngresadaA = scanner.nextLine();

        System.out.print("Nombre de la Persona B: ");
        String nombreIngresadoB = scanner.nextLine();

        System.out.print("preferencias de B (cena, cine, aventura, relax): ");
        String preferenciaIngresada = scanner.nextLine().toLowerCase().trim();

        System.out.print("Propuesta de A (Cena, cine, aventura, relax): ");
        String propuestaIngresada = scanner.nextLine().toLowerCase().trim();

        boolean esPreferenciaValida = preferenciaIngresada.equals("cena") || preferenciaIngresada.equals("cine")
                || preferenciaIngresada.equals("aventura") || preferenciaIngresada.equals("relax");

        boolean esPropuestaValida = propuestaIngresada.equals("cena") ||
                propuestaIngresada.equals("cine") ||
                propuestaIngresada.equals("aventura") ||
                propuestaIngresada.equals("relax");

        // si ambas son verdaderas guardamos sino no.

        if (esPreferenciaValida && esPropuestaValida) {
            listaNombrePersonaA.add(nombreIngresadaA);
            listaNombrePersonaB.add(nombreIngresadoB);
            listaPreferenciasB.add(preferenciaIngresada);
            listaPropuestaA.add(propuestaIngresada);

            System.out.println("Guardado");
        } else {
            System.out.print("Error, el plan escrito no existe");
        }
    }

    public static void listarPlanes(ArrayList<String> nombreA, ArrayList<String> nombreB,
            ArrayList<String> preferenciaDeB, ArrayList<String> propuestaDeA) {
        // verificamos que la lista no este vasia
        if (nombreA.isEmpty()) {
            System.out.println("No hay planes registrados.");
        } else {
            for (int i = 0; i < nombreA.size(); i++) {
                System.out.println("Plan [" + i + "]: " + nombreA.get(i) + " y " + nombreB.get(i));
                System.out.println("   - Preferencia B: " + preferenciaDeB.get(i));
                System.out.println("   - Propuesta A:   " + propuestaDeA.get(i));
            }
        }

    }

    public static void evaluarPlan(Scanner scanner, ArrayList<String> nombreDeA, ArrayList<String> nombreDeB,
            ArrayList<String> propuestaA, ArrayList<String> preferenciaB) {
        // todo esto dentro de un try para evaluar.
        try {
            int indice = scanner.nextInt();
            scanner.nextLine();

            String preferencia = preferenciaB.get(indice);
            String propuesta = propuestaA.get(indice);
            String resultado = "";
            if (preferencia.equals(propuesta)) {
                resultado = "perfecto";
            } else if ((preferencia.equals("aventura") && propuesta.equals("relax")) ||
                    (preferencia.equals("relax") && propuesta.equals("aventura"))) {
                resultado = "fatal";
            } else if (preferencia.equals("aventura") || propuesta.equals("aventura")) {
                resultado = "regular"; // Si hay aventura y no es igual ni relax, es regular
            } else {
                resultado = "bien";
            }

            mensajeAleatorio(resultado);

        } catch (Exception e) {
            // Este catch captura si el usuario pone un índice que no existe
            // O si escribe letras en vez de números
            System.out.println("ERROR: Índice incorrecto o datos no válidos.");
            scanner.nextLine(); // Limpiamos scanner por si acaso
        }

    }

    public static void eliminarPlan(Scanner tec, ArrayList<String> nA, ArrayList<String> nB, ArrayList<String> pB,
            ArrayList<String> pA) {
        listarPlanes(nA, nB, pB, pA);
        System.out.print("Índice a borrar: ");

        try {
            int indice = tec.nextInt();
            tec.nextLine();

            // Al borrar, borramos de las 4 listas
            nA.remove(indice);
            nB.remove(indice);
            pB.remove(indice);
            pA.remove(indice);
            System.out.println("Plan eliminado.");

        } catch (Exception e) {
            System.out.println("ERROR: No se pudo eliminar. Índice no válido.");
            tec.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // arrays
        ArrayList<String> personaA = new ArrayList<>();
        ArrayList<String> personaB = new ArrayList<>();
        ArrayList<String> peferenciaPersonaB = new ArrayList<>();
        ArrayList<String> propuestaPersonaA = new ArrayList<>();

        int opcion = 0;

        while (opcion != 5) {
            mostrarMenu();

            opcion = scanner.nextInt();

            scanner.nextLine();// limpiar bufer.
            if (opcion == 1) {
                aniadirPlan(scanner, personaA, personaB, peferenciaPersonaB, propuestaPersonaA);
            } else if (opcion == 2) {
                listarPlanes(personaA, personaB, peferenciaPersonaB, propuestaPersonaA);
            } else if (opcion == 3) {
                evaluarPlan(scanner, personaA, personaB, propuestaPersonaA, peferenciaPersonaB);
                ;

            } else if (opcion == 4) {
                eliminarPlan(scanner, personaA, personaB, peferenciaPersonaB, propuestaPersonaA);

            } else if (opcion == 5) {
                System.out.println("saliendo del programa...");

            } else {
                System.out.println("Opcion incorrecta");
            }

        }
        scanner.close();
    }
}


/// para añadir el control de errores fijate bien en hacerlo dentro del boocle while. despues de mosrtrarMenu();  try{ opcion = nextline();  luego del ultimo else añadimos el catch(Exception e ) {} catch (Exception e) {
                // Si ocurre un error (meter letras en el menú), caemos aquí
                //System.out.println("ERROR CRÍTICO: Debes introducir un número entero.");
                //scanner.nextLine(); // Importante: Limpiar la basura del scanner para no hacer bucle infinito
                //opcion = 0; // Reiniciamos opción para que el bucle siga
           // }}}
