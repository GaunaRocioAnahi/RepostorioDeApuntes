package programcion.UD4.UD2R1;

import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Integer> numero = new ArrayList<Integer>();
        numero.add(5);
        numero.add(10);
        numero.add(15);
        numero.add(20);

        // Asi no se hace.
       // Integer ultimoNumero = numero.get(2);
       // System.out.println(primerNumero);
       // Integer primerNumero = numero.get(0);
       
       // System.out.println(ultimoNumero);


        System.out.println(numero.get(0));
        System.out.println(numero.get(numero.size()-1));
    }
}
