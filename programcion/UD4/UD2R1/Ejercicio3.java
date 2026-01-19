package programcion.UD4.UD2R1;

import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<String>();
        colores.add("rojo");
        colores.add("verde");
        colores.add("azul");

        // colores.remove("azul");
        // System.out.println(colores);

        // mostrar el mensaje con for each-

        String mensaje = "";
        for (String color : colores) {
            mensaje += "--";
        }
        mensaje = mensaje.substring(0, mensaje.length() - 1);
        System.out.println(mensaje);

    }
}
