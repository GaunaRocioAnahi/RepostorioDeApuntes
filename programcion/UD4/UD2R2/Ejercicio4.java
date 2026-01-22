package programcion.UD4.UD2R2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        ArrayList<Integer> cantidadDeLibros = new ArrayList<Integer>();
        ArrayList<String> titulosDeLibros = new ArrayList<String>();

        int opcion = 0;
        while (opcion !=4) {

        System.out.println("1.Añadir un nuevo libro y cantidad" );
        System.out.println("2.Actualizar la cantidad de libro existente");
        System.out.println("3.Ver el inventario completo");
        System.out.println("4.Salir del programa ");
        opcion=Scanner.nextInt();
        Scanner.nextLine();

        if (opcion == 1) {
            System.out.print("Ingrese un nuevo libro");
            String libroNuevo = scanner.nextLine();
            scanner.nextLine();


        }

    }
}
}