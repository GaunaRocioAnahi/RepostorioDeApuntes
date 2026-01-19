package programcion.UD4.UD2R1;

import java.util.ArrayList;

public class Ejercicio5 {
    public static void main(String[] args) {
        ArrayList<String> animales = new ArrayList<String>();
        animales.add("perro");
        animales.add("gato");
        animales.add(0, "loro");
        animales.add(1, "tortuga");

        animales.remove(0);

        System.out.println(String.join(",",animales));
    }
}
