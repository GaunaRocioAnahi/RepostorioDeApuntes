package programcion.UD4.UD2R2;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4F {
    // hacemos una funcion para mostrar el menu ya que es constante que no se cambia
    // y reducimos codigo en mi main.
    public static void mostrarMenu() {
        System.out.println("1.Añadir un nuevo libro y cantidad");
        System.out.println("2.Actualizar la cantidad de libro existente");
        System.out.println("3.Ver el inventario completo");
        System.out.println("4.Salir del programa ");
    }

    public static void mostrarInventario(ArrayList<String> listaLibros, ArrayList<Integer> cantidadLibro) {
        if (listaLibros.isEmpty()) {
            System.out.println("vacio");
            return;
        }
        for (int i = 0; i < listaLibros.size(); i++) {
            System.out.println((i + 1) + "- " + listaLibros.get(i) + ": " + cantidadLibro.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        ArrayList<Integer> cantidad = new ArrayList<Integer>();
        ArrayList<String> libros = new ArrayList<String>();

        libros.add("El quijote");
        cantidad.add(5);
        libros.add("la  biblia");
        cantidad.add(10);
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        while (opcion != 4) {

            mostrarMenu();

            opcion = Scanner.nextInt(); // Este se utiliza para que una vez que puedas dar "Enter".
            Scanner.nextLine(); // Limpia el bufer cuando ingresa la opcion.

            if (opcion == 1) {
                System.out.print("Ingrese un nuevo libro");
                String libroNuevo = Scanner.nextLine();

                System.out.println("ingrese la cantidad");
                int cantidadLibro = Scanner.nextInt();
                Scanner.nextLine();

                libros.add(libroNuevo);
                cantidad.add(cantidadLibro);

            } else if (opcion == 2) {
                System.out.print("Ingrese el nombre del libro a actualizar: ");
                String nombreBusqueda = scanner.nextLine();
                // busqueda si existe, y que poosicion esta.
                // indexOf devuelve el numero de la posicion y si no existe devuelve el -1.
                int indice = libros.indexOf(nombreBusqueda);

                // si el indice no es igual a -1 o sea que el libro existir y continua el bloque
                // de codigo. y -1 no existe no entra a ese bloque de codigo.
                if (indice != -1) {
                    System.out.println("Cantidad actual: ");
                    int nuevaCantidad = scanner.nextInt();
                    cantidad.set(indice, nuevaCantidad);
                    System.out.println("Cantidad de libros actualizadas correctamente");

                } else {
                    System.out.println("Error: El libro no existe en su lista.");
                }

            } else if (opcion == 3) {

                mostrarInventario(libros, cantidad);
                // Verificamos si la lista esta vacia con el isEmpty()
                // if(libros.isEmpty()){
                // System.out.println("No hay libros en el inventario");
                // }else{
                // para ver el inventario completo necesitamos un for por que al ser dos listas
                // separadas necesitas un indice(variable i) que recorra ambas listas a la vez.
                // for ( int i=0 ; i <libros.size(); i++ ){
                // String nombre= libros.get(i); //obtenemos el nombre de la posicion i
                // int stock = cantidad.get(i); //obtenemos la cantidad de la misma posicion
                // anterior i
                // luego lo imprimimos en la siguiente linea.
                // System.out.println((i+1) + " , "+ nombre+ " - Stock: "+ stock);
                // (i+1) esto es para que en la lista me muestre un listado como tal y no un 0
                // al comienzo de la lista.

            }
        }
        System.out.println("¡Haz salido del programa!");
        Scanner.close();
    }
}
