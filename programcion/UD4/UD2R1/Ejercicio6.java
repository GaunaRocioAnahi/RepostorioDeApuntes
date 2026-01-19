package programcion.UD4.UD2R1;

import java.util.ArrayList;

public class Ejercicio6 {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<String>();
        frutas.add("manzana");
        frutas.add("banana");
        frutas.add("naranja");

        // PRIMERO ELIMINAR. EL SET LO REEMPLAZA NO SE UTILIZA. 
        frutas.set(0,"fresa");

        System.out.println(String.join(",",frutas));

    }
}
