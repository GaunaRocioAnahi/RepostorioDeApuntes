package programcion.UD4.Ud1R;

import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroDeCaramelos; 
        int numeroDeNinios;
        int caramelosPorNinio;
        int restoDeCaramelos;

        System.out.println("Ingrese los numeros de caramelos :");
        System.out.println("¿Cuantos niños hay?");
        
        numeroDeCaramelos = scanner.nextInt();
        numeroDeNinios = scanner.nextInt();
        
        caramelosPorNinio = (numeroDeCaramelos / numeroDeNinios);
        restoDeCaramelos = numeroDeCaramelos % numeroDeNinios;
        scanner.nextInt();
        scanner.close();

        System.out.println("A cada niño le corresponden :" + caramelosPorNinio + "caramelos que han sobrado " + restoDeCaramelos);


    }
}