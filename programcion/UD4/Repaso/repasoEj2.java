package programcion.UD4.Repaso;

import java.util.ArrayList;
import java.util.Scanner;

public class repasoEj2{
    public static void main(String[] args) {
        // 1. HERRAMIENTAS
        Scanner sc = new Scanner(System.in);

        // 2. BASE DE DATOS (4 Listas Paralelas)
        // Guardamos: Matrícula, Tipo ("basica"/"completa"), Cantidad de extras, y Coste
        // final ($)
        ArrayList<String> matriculas = new ArrayList<>();
        ArrayList<String> tiposRevision = new ArrayList<>();
        ArrayList<Integer> numExtras = new ArrayList<>();
        ArrayList<Double> costesFinales = new ArrayList<>();

        int opcion = -1;

        System.out.println("--- GESTIÓN TALLER DE TRACTORES ---");

        // 3. BUCLE PRINCIPAL DEL MENÚ
        while (opcion != 0) {
            System.out.println("\n1. Añadir revisión");
            System.out.println("2. Listar revisiones");
            System.out.println("3. Mostrar coste detallado (por índice)");
            System.out.println("4. Eliminar revisión");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            // Leemos la opción como texto y convertimos a número para evitar errores
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                opcion = -1; // Si escriben letras, forzamos error
            }

            // --- OPCIÓN 1: AÑADIR REVISIÓN ---
            if (opcion == 1) {
                System.out.println("\n--- NUEVA REVISIÓN ---");

                // A. PEDIR MATRÍCULA
                System.out.print("Matrícula: ");
                String mat = sc.nextLine().trim().toUpperCase(); // Convertimos a mayúsculas para que quede bonito

                // B. PEDIR TIPO (Validación: solo 'basica' o 'completa')
                String tipo = "";
                boolean tipoValido = false;
                while (tipoValido == false) {
                    System.out.print("Tipo (basica / completa): ");
                    tipo = sc.nextLine().trim().toLowerCase(); // A minúsculas para comparar fácil

                    if (tipo.equals("basica") || tipo.equals("completa")) {
                        tipoValido = true; // Semáforo verde
                    } else {
                        System.out.println("Error: Solo aceptamos 'basica' o 'completa'.");
                    }
                }

                // C. PEDIR EXTRAS (Validación: número positivo o cero)
                int extras = -1;
                while (extras < 0) {
                    System.out.print("Número de servicios extra: ");
                    try {
                        extras = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        extras = -1; // Si falla, repite el bucle
                    }
                    if (extras < 0)
                        System.out.println("Error: No puede ser negativo.");
                }

                // D. CÁLCULOS (El corazón del ejercicio)
                double costeTotal = 0.0;

                // 1. Precio Base
                if (tipo.equals("basica")) {
                    costeTotal = 60.0;
                } else {
                    costeTotal = 120.0;
                }

                // 2. Sumar Extras (15€ cada uno)
                costeTotal = costeTotal + (extras * 15.0);

                // 3. Aplicar Descuento (Si termina en PAR)
                // Cogemos el último caracter de la matrícula
                char ultimaLetra = mat.charAt(mat.length() - 1);
                boolean hayDescuento = false;

                // Verificamos si es un dígito numérico (0-9)
                if (Character.isDigit(ultimaLetra)) {
                    // Convertimos ese caracter a número matemático
                    int ultimoNumero = Character.getNumericValue(ultimaLetra);

                    // Si el resto de dividir por 2 es cero, es PAR
                    if (ultimoNumero % 2 == 0) {
                        costeTotal = costeTotal * 0.90; // Aplicamos 10% descuento (se queda en el 90%)
                        hayDescuento = true;
                    }
                }

                // E. GUARDAR EN LAS 4 LISTAS
                matriculas.add(mat);
                tiposRevision.add(tipo);
                numExtras.add(extras);
                costesFinales.add(costeTotal);

                System.out.print("Revisión guardada. Coste final: " + costeTotal + "€");
                if (hayDescuento)
                    System.out.print(" (¡Descuento aplicado!)");
                System.out.println();
            }

            // --- OPCIÓN 2: LISTAR ---
            else if (opcion == 2) {
                System.out.println("\n--- LISTADO DE REVISIONES ---");
                if (matriculas.isEmpty()) {
                    System.out.println("No hay revisiones registradas.");
                } else {
                    // Recorremos con 'i' todas las listas a la vez
                    for (int i = 0; i < matriculas.size(); i++) {
                        System.out.println(i + " -> " + matriculas.get(i) + " | " +
                                tiposRevision.get(i) + " | Extras: " +
                                numExtras.get(i) + " | Coste: " + costesFinales.get(i) + "€");
                    }
                }
            }

            // --- OPCIÓN 3: CONSULTAR COSTE DETALLADO ---
            else if (opcion == 3) {
                System.out.println("\n--- CONSULTAR COSTE ---");
                if (matriculas.isEmpty()) {
                    System.out.println("No hay datos.");
                } else {
                    // Pedir Índice con Validación
                    int indice = -1;
                    while (indice < 0 || indice >= matriculas.size()) {
                        System.out.print("Introduce el índice de la revisión: ");
                        try {
                            indice = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            indice = -1;
                        }

                        if (indice < 0 || indice >= matriculas.size()) {
                            System.out.println("Índice no válido.");
                        }
                    }

                    // Sacar datos para mostrar el mensaje
                    double precio = costesFinales.get(indice);
                    String mat = matriculas.get(indice);

                    // Volvemos a comprobar lo del descuento solo para el mensaje
                    char ultima = mat.charAt(mat.length() - 1);
                    boolean tuvoDescuento = false;
                    if (Character.isDigit(ultima)) {
                        if (Character.getNumericValue(ultima) % 2 == 0)
                            tuvoDescuento = true;
                    }

                    System.out.println("Revisión de: " + mat);
                    System.out.println("Total a pagar: " + precio + "€");
                    if (tuvoDescuento) {
                        System.out.println("NOTA: Se aplicó un 10% de descuento por matrícula par.");
                    } else {
                        System.out.println("NOTA: Sin descuento (matrícula impar o no numérica).");
                    }
                }
            }

            // --- OPCIÓN 4: ELIMINAR ---
            else if (opcion == 4) {
                System.out.println("\n--- ELIMINAR REVISIÓN ---");
                if (matriculas.isEmpty()) {
                    System.out.println("No hay nada que borrar.");
                } else {
                    // Mostramos lista primero para ayudar
                    for (int i = 0; i < matriculas.size(); i++) {
                        System.out.println(i + " -> " + matriculas.get(i));
                    }

                    int indiceBorrar = -1;
                    while (indiceBorrar < 0 || indiceBorrar >= matriculas.size()) {
                        System.out.print("Índice a borrar: ");
                        try {
                            indiceBorrar = Integer.parseInt(sc.nextLine());
                        } catch (Exception e) {
                            indiceBorrar = -1;
                        }

                        if (indiceBorrar < 0 || indiceBorrar >= matriculas.size()) {
                            System.out.println("Error: Índice incorrecto.");
                        }
                    }

                    // BORRAR DE TODAS LAS LISTAS (Sincronizado)
                    String borrado = matriculas.get(indiceBorrar); // Guardamos nombre para despedirnos

                    matriculas.remove(indiceBorrar);
                    tiposRevision.remove(indiceBorrar);
                    numExtras.remove(indiceBorrar);
                    costesFinales.remove(indiceBorrar);

                    System.out.println("Revisión de " + borrado + " eliminada correctamente.");
                }
            }

            // --- SALIR ---
            else if (opcion == 0) {
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opción desconocida.");
            }
        }
    }
}
