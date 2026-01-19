package programcion.UD4.UD2R1;

import java.util.ArrayList;

public class Ejercicio8 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(100);
        numeros.add(200);
        numeros.add(300);

        int variableTemporal = numeros.get(0);

        numeros.set(0, numeros.getLast());
        numeros.set(2, variableTemporal);
// ingresar el for each- para el mensaje.
//for ( int numero :  numeros){
//    mensaje += 
//}
//
  }
}
