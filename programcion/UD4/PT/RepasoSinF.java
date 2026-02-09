import java.util.ArrayList;
import java.util.Scanner;

public class RepasoSinF {
    public static void main(String[] args) {
        
        // 1. INICIALIZACIÓN DE VARIABLES Y RECURSOS
        Scanner lectorTeclado = new Scanner(System.in);
        
        // Listas para guardar la información (variables locales dentro del main)
        ArrayList<String> listaNombresA = new ArrayList<>();
        ArrayList<String> listaNombresB = new ArrayList<>();
        ArrayList<String> listaPreferencias = new ArrayList<>();
        ArrayList<String> listaPropuestas = new ArrayList<>();

        int opcionMenu = 0; // Variable para controlar el bucle while

        // 2. BUCLE PRINCIPAL (Mantiene el programa encendido)
        while (opcionMenu != 5) {
            
            // --- PINTAR EL MENÚ (Escrito directamente aquí, sin funciones) ---
            System.out.println("\n=== GESTOR DE PLANES DE SAN VALENTÍN ===");
            System.out.println("1- Añadir plan");
            System.out.println("2- Listar planes");
            System.out.println("3- Evaluar plan (por índice)");
            System.out.println("4- Eliminar plan (por índice)");
            System.out.println("5- Salir");
            System.out.print("Elige una opción: ");

            // Usamos try-catch para evitar que el programa falle si meten letras en el menú
            try {
                opcionMenu = lectorTeclado.nextInt();
                lectorTeclado.nextLine(); // IMPORTANTE: Limpiar el "Enter" del buffer

                // -----------------------------------------------------------
                // OPCIÓN 1: AÑADIR PLAN
                // Consigna: Pedir datos, normalizar a minúsculas y validar que sea correcto.
                // -----------------------------------------------------------
                if (opcionMenu == 1) {
                    System.out.println("\n--- AÑADIR NUEVO PLAN ---");
                    
                    System.out.print("Nombre de la Persona A: ");
                    String nombreA = lectorTeclado.nextLine();
                    
                    System.out.print("Nombre de la Persona B: ");
                    String nombreB = lectorTeclado.nextLine();
                    
                    // Pedimos preferencia y convertimos a minúscula y quitamos espacios
                    System.out.print("Preferencia de B (cena, cine, aventura, relax): ");
                    String preferencia = lectorTeclado.nextLine().trim().toLowerCase();
                    
                    System.out.print("Propuesta de A (cena, cine, aventura, relax): ");
                    String propuesta = lectorTeclado.nextLine().trim().toLowerCase();

                    // VALIDACIÓN: Comprobamos si lo escrito es válido directamente aquí
                    boolean esPreferenciaValida = preferencia.equals("cena") || preferencia.equals("cine") || preferencia.equals("aventura") || preferencia.equals("relax");
                    boolean esPropuestaValida = propuesta.equals("cena") || propuesta.equals("cine") || propuesta.equals("aventura") || propuesta.equals("relax");

                    if (esPreferenciaValida && esPropuestaValida) {
                        // Si todo es correcto, guardamos en las listas
                        listaNombresA.add(nombreA);
                        listaNombresB.add(nombreB);
                        listaPreferencias.add(preferencia);
                        listaPropuestas.add(propuesta);
                        System.out.println("¡Plan guardado correctamente!");
                    } else {
                        System.out.println("ERROR: Has introducido un plan no válido.");
                        System.out.println("Solo se permite: cena, cine, aventura, relax.");
                    }
                }
                
                // -----------------------------------------------------------
                // OPCIÓN 2: LISTAR PLANES
                // Consigna: Mostrar todos los planes guardados con su índice.
                // -----------------------------------------------------------
                else if (opcionMenu == 2) {
                    System.out.println("\n--- LISTA DE PLANES ---");
                    
                    if (listaNombresA.isEmpty()) {
                        System.out.println("No hay planes registrados.");
                    } else {
                        // Recorremos las listas usando un bucle for normal
                        for (int i = 0; i < listaNombresA.size(); i++) {
                            System.out.println("Plan [" + i + "]: " + listaNombresA.get(i) + " y " + listaNombresB.get(i));
                            System.out.println("   - Preferencia B: " + listaPreferencias.get(i));
                            System.out.println("   - Propuesta A:   " + listaPropuestas.get(i));
                        }
                    }
                }
                
                // -----------------------------------------------------------
                // OPCIÓN 3: EVALUAR PLAN
                // Consigna: Pedir índice, comparar preferencia vs propuesta y dar mensaje aleatorio.
                // -----------------------------------------------------------
                else if (opcionMenu == 3) {
                    System.out.println("\n--- EVALUAR PLAN ---");
                    
                    // Mostramos lista rápida para ver los índices (copiamos el bucle de listar)
                    for (int i = 0; i < listaNombresA.size(); i++) {
                        System.out.println("[" + i + "] " + listaNombresA.get(i) + " - " + listaNombresB.get(i));
                    }

                    System.out.print("Introduce el número (índice) a evaluar: ");
                    // Try interno para capturar errores de índice
                    try {
                        int indice = lectorTeclado.nextInt();
                        lectorTeclado.nextLine(); // Limpiar buffer

                        // Obtenemos los datos de las listas
                        String pref = listaPreferencias.get(indice);
                        String prop = listaPropuestas.get(indice);
                        String resultado = "";

                        // LÓGICA DE COMPARACIÓN (La tabla del examen)
                        if (pref.equals(prop)) {
                            resultado = "perfecto";
                        } 
                        else if ((pref.equals("aventura") && prop.equals("relax")) || (pref.equals("relax") && prop.equals("aventura"))) {
                            resultado = "fatal";
                        } 
                        else if (pref.equals("aventura") || prop.equals("aventura")) {
                            resultado = "regular";
                        } 
                        else {
                            resultado = "bien";
                        }

                        // LÓGICA DE MENSAJE ALEATORIO (Dentro del mismo bloque)
                        System.out.println(">>> RESULTADO: " + resultado.toUpperCase() + " <<<");
                        double azar = Math.random(); // Número entre 0.0 y 1.0

                        if (resultado.equals("perfecto")) {
                            if (azar < 0.5) System.out.println("Mensaje: ¡Son almas gemelas!");
                            else System.out.println("Mensaje: ¡El amor triunfa!");
                        } else if (resultado.equals("bien")) {
                            if (azar < 0.5) System.out.println("Mensaje: Lo pasarán bien.");
                            else System.out.println("Mensaje: Un plan correcto.");
                        } else if (resultado.equals("regular")) {
                            if (azar < 0.5) System.out.println("Mensaje: Cuidado con discutir.");
                            else System.out.println("Mensaje: Alguien cederá a la fuerza.");
                        } else if (resultado.equals("fatal")) {
                            if (azar < 0.5) System.out.println("Mensaje: ¡Huyan ahora mismo!");
                            else System.out.println("Mensaje: Mejor quédense en casa.");
                        }

                    } catch (Exception e) {
                        System.out.println("ERROR: El índice no existe o no es válido.");
                        lectorTeclado.nextLine(); 
                    }
                }
                
                // -----------------------------------------------------------
                // OPCIÓN 4: ELIMINAR PLAN
                // Consigna: Borrar los datos de todas las listas según el índice.
                // -----------------------------------------------------------
                else if (opcionMenu == 4) {
                    System.out.println("\n--- ELIMINAR PLAN ---");
                    // Listamos brevemente
                    for (int i = 0; i < listaNombresA.size(); i++) {
                        System.out.println("[" + i + "] " + listaNombresA.get(i));
                    }
                    
                    System.out.print("Introduce el número a borrar: ");
                    try {
                        int indice = lectorTeclado.nextInt();
                        lectorTeclado.nextLine(); // Limpiar buffer

                        // Borramos de TODAS las listas
                        listaNombresA.remove(indice);
                        listaNombresB.remove(indice);
                        listaPreferencias.remove(indice);
                        listaPropuestas.remove(indice);
                        System.out.println("Plan eliminado correctamente.");
                    } catch (Exception e) {
                        System.out.println("ERROR: No se pudo eliminar (índice incorrecto).");
                        lectorTeclado.nextLine();
                    }
                }
                
                // -----------------------------------------------------------
                // OPCIÓN 5: SALIR
                // -----------------------------------------------------------
                else if (opcionMenu == 5) {
                    System.out.println("Saliendo del programa...");
                } 
                
                // OPCIÓN NO VÁLIDA
                else {
                    System.out.println("Opción no válida. Introduce un número del 1 al 5.");
                }

            } catch (Exception e) {
                // Catch del menú principal (si meten letras en vez de números)
                System.out.println("ERROR CRÍTICO: Debes escribir un número entero.");
                lectorTeclado.nextLine(); // Limpiamos el scanner para que no se encasquille
                opcionMenu = 0; // Reiniciamos para seguir en el bucle
            }
        } // FIN DEL BUCLE WHILE

        // 3. CIERRE DE RECURSOS (Solo aquí, al final del todo)
        lectorTeclado.close();
        System.out.println("Fin del examen.");
    }
}
