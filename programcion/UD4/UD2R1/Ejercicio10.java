package programcion.UD4.UD2R1;

import java.util.ArrayList;

public class Ejercicio10 {
    public static void main(String[] args) {
        ArrayList<String> pila = new ArrayList<String>();
        pila.add("10");
        pila.add("20");
        pila.add("30");

        System.out.println("Cliente atendido:"+ pila.get(pila.size()-1));
        System.out.println("Cliente Testantes" + pila);

    }
}

