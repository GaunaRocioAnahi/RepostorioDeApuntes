package programcion.UD5.Relacion2.Ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        // falta el razonamiento para aplicar el faker. 
    
    // creamos el objeto Supermercado, el "contenedor" de productos
        Supermercado supermercado = new Supermercado();
    
    // Scanner para leer lo que escribe el usuario
        Scanner scanner = new Scanner(System.in);
        
        int opcion=0;

        // el while se repite hasta que el usuario elija salir con 4
        while (opcion != 4) {

            System.out.println("\n--- MENÚ SUPERMERCADO ---");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Vender producto");
            System.out.println("3. Reponer producto");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                // llamamos al método que recorre el ArrayList y muestra cada producto
                supermercado.mostrarInventario();

            } else if (opcion == 2) {
                // pedimos el ID del producto a vender
                System.out.print("Introduce el ID del producto a vender: ");
                String id = scanner.next();

                // pedimos cuántas unidades quiere vender
                System.out.print("Introduce la cantidad a vender: ");
                int cantidad = scanner.nextInt();

                // llamamos al método con el ID y la cantidad
                supermercado.venderProducto(id, cantidad);

            } else if (opcion == 3) {
                // mismo razonamiento que vender pero para reponer
                System.out.print("Introduce el ID del producto a reponer: ");
                String id = scanner.next();

                System.out.print("Introduce la cantidad a reponer: ");
                int cantidad = scanner.nextInt();

                supermercado.reponerProducto(id, cantidad);

            } else if (opcion == 4) {
                System.out.println("Hasta luego!");

            } else {
                System.out.println("Opción no válida, intenta de nuevo.");
            }
        }

        scanner.close();
    }
    }

