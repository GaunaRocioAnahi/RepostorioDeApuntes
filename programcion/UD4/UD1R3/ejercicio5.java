package programcion.UD4.UD1R3;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        System.out.print("Ingrese un numero: ");
        numero = scanner.nextInt(); 
        scanner.close();
        if( numero >=10 && numero <=20){
            System.out.println("El nuermo esta en el Rango" + " "+ numero);
        } else{
            System.out.println(" El numero esta fuera del rango" + " " + numero);
        }
    }
}
