package programcion.UD4.UD2R2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        ArrayList<Integer> cantidad = new ArrayList<Integer>();
        ArrayList<String> libros = new ArrayList<String>();

        libros.add("El quijote"); cantidad.add(5);
        libros.add("la  biblia");
        Scanner scanner = new Scanner(System.in);

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
            String libroNuevo = Scanner.nextLine();
            Scanner.nextLine();
            System.out.println("ingrese la cantidad");


        }

    }
}
}