package programcion.UD4.Repaso;

import java.util.ArrayList;
import java.util.Scanner;

public class RepasoEj1 {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        ArrayList<String> matriculas = new ArrayList<>();
        ArrayList<String> tipos = new ArrayList<>();
        ArrayList<String> extras = new ArrayList<>();
        ArrayList<String> costes = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) {
            // Menú
            System.out.println("1. Añadir revisión");
            System.out.println("2. Listar revisiones");
            System.out.println("3. Mostrar coste (por índice)");
            System.out.println("4. Eliminar revisión");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = Scanner.nextInt();
            Scanner.nextLine(); // Limpiar buffer

            if (opcion == 1){
                System.out.println("Introducir matricula");
            }
}
    }
}