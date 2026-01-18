package programcion.UD4.Ud1R;

import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        //creamos el Scanner
        Scanner scanner = new Scanner(System.in);
        
        
        Double pesoEnLaTierra; 
        Double pesoEnLaLuna;  
        
        //Lee los datos del usuario ingresados
        System.out.print("Ingrese su peso en la tierra: ");
        pesoEnLaTierra = scanner.nextDouble();
        //Cerramos el Scanner. 
        scanner.close();

        pesoEnLaLuna = pesoEnLaTierra * (0.165);
        
        // Mostramos los datos.
        System.out.println("su peso en la tierra es de : "+ pesoEnLaTierra + "kg" );
        System.out.printf("El peso en la luna es de : %.2f \n", pesoEnLaLuna);
        
    }

}
