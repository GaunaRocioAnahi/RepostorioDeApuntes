package programcion.UD4.Ud1R;

import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroDeCaramelos; 
        int numeroDeNinios;
        int caramelosPorNinio;
        int restoDeCaramelos;

        System.out.print("Ingrese los numeros de caramelos :" );
        numeroDeCaramelos = scanner.nextInt();
        
        System.out.print("¿Cuantos niños hay?");
        numeroDeNinios = scanner.nextInt();
        
        caramelosPorNinio = (numeroDeCaramelos / numeroDeNinios);
        restoDeCaramelos = numeroDeCaramelos % numeroDeNinios;
        scanner.close();

        System.out.println("A cada niño le corresponden : " +  caramelosPorNinio + "\n"+ "caramelos que han sobrado: " + restoDeCaramelos);


    }
}