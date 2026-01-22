package programcion.UD4.UD1R3;

import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double numero1;
        Double numero2;
        String operador;
        Double resultado = 0.0;

        System.out.print("Introduce un numero");
        numero1 = scanner.nextDouble();

        System.out.print("Introduce otro numero");
        numero2 = scanner.nextDouble();

        System.out.print("Intróduce un operador:");
        operador = scanner.nextLine();

        scanner.close();

        if ( operador.equals("+")){
            resultado = numero1 + numero2;
        }else if (operador.equals("-")) {
            resultado = numero1 - numero2;
        }else if (operador.equals("*")) {
            resultado = numero1 * numero2;
        }else if (operador.equals("/")) {
            resultado = numero1 / numero2;
            
        }else{
            System.out.print("Operador incorrecto");
        }
System.out.print("El resultado es de  "+ numero1 + operador + numero2 + " es "+ resultado );
    }
}
