package programcion.UD4.Repaso;

import java.util.ArrayList;
import java.util.Scanner;

public class RepasoEj1 {
    public static void mostrarMenu() {
        System.out.println("1. Añadir tractor");
        System.out.println("2. Listar tractores");
        System.out.println("3. Evaluar tractor (por indice)");
        System.out.println("4.Eliminar ( por indice)");
        System.out.println("0.salir");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> marcas = new ArrayList<>();
        ArrayList<Integer> potencias = new ArrayList<>();
        ArrayList<String> trabajos = new ArrayList<>();

        int opcion = -1; // la opcion "0" no puede ser por que es la que me hace que salga del programa y
                         // al iniciar con -1 es como tener muchas opcion para iniciar.

        while (opcion != 0) {
            opcion = scanner.nextInt();
            mostrarMenu();
            if (opcion == 1) {
                // pide la marca no pide validacion
                System.out.println("Añada la marca del tractor: ");
                String marcaIngresada = scanner.nextLine();

                // pide la potencia pero la tenemos que validar.

                int potenciaIngresada = 0;
                // Mientras la potencia sea 0 o negativa seguimos preguntando.

                while (potenciaIngresada <= 0) {
                    System.out.print("introduce la pontecia mayor que 0: ");
                    // usamos parseInt para leer texto y convertirlo a numero.
                    // o sino tendriamos que limpiar el bufer
                    String textoPotencia = scanner.nextLine();
                    potenciaIngresada = Integer.parseInt(textoPotencia);

                    // si el usuario puso un negativo o cero avisamos con error.

                    if (potenciaIngresada <= 0) {
                        System.out.println("Erro: la potencia tiene que ser positiva.");
                    }
                }
                // fuera del while validamos el TRABAJO. que sea uno de los 3 tipo.

                String trabajoIngresasdo = "";
                boolean esTrabajoValido = false;

                // mientras que sea false seguimos preguntando.

                while (esTrabajoValido == false) {
                    System.out.print("Introduce el trabajo (arado, transporte, siembra): ");
                    trabajoIngresasdo = scanner.nextLine();
                    // para que valide mayusculas o minustulas ponemos :

                    trabajoIngresasdo = trabajoIngresasdo.toLowerCase();

                    // comprobamos si coincide con alguna de las palabras permitidas:

                    if (trabajoIngresasdo.equals("arado") || trabajoIngresasdo.equals("transporte")
                            || trabajoIngresasdo.equals("siembra")) {
                        esTrabajoValido = true;
                    } else {
                        System.out.println("Error:Tipo de trabajo es desconocido");
                    }

                }
                // guarda las listas

                marcas.add(marcaIngresada);
                potencias.add(potenciaIngresada);
                trabajos.add(trabajoIngresasdo);
            } else if (opcion == 2) {
                // siempre que tenemos una lista verificamos si hay datos primero con isEmpty()
                if (marcas.isEmpty()) {
                    System.out.println("no hay tractores registrados todavia");
                } else {
                    // recorremos para mostrar el listado y lo hacemos con un for.

                    for (int i = 0; i < marcas.size(); i++) {
                        // OBTENER Y MOSTRAR en una linea usamos "i" como indice actual
                        System.out.println(i + "- " + marcas.get(i) + " | Potencia: " + potencias.get(i)
                                + " CV | Trabajo: " + trabajos.get(i));
                    }
                }
            } else if (opcion == 3) {
                if (marcas.isEmpty()) {
                    System.out.println("No hay tractores para evaluar.");
                } else {

                    // Primero mostramos la lista para que el usuario sepa cuál elegir
                    // (Copiamos el bucle for de la opción 2 aquí para ayudar visualmente)
                    for (int i = 0; i < marcas.size(); i++) {
                        System.out.println(i + " -> " + marcas.get(i));
                    }
                    // mienstras que sea menor que 0 o mayo/igual que el tamaño.
                    int indiceElegido = -1;
                    while (indiceElegido < 0 || indiceElegido >= marcas.size()) {
                        System.out.println("introduce el numero del tractor a evaluar: ");
                        String textoIndice = scanner.nextLine();
                        // usar el try catch. si esccriben letras
                        try {
                            indiceElegido = Integer.parseInt(textoIndice);
                        } catch (Exception e) {
                            indiceElegido = -1; // si falla, ponemos -1 para que el bucle se repita.
                        }
                        if (indiceElegido < 0 || indiceElegido >= marcas.size()) {
                            System.out.println("Error: el numero no esta en la lista.");
                        }
                    }
                    // USAMOS EL indice para sacar su informacion
                    String trabajoActual = trabajos.get(indiceElegido);
                    int potenciaActual = potencias.get(indiceElegido);
                    String marcaActual = marcas.get(indiceElegido);
                    // evaluamos el trabajo.
                    // por defecto decimo que no es apto y solo lo cambiamos si cumple.

                    String resultado = "No Apto";

                    if (trabajoActual.equals("arado")) {
                        if (potenciaActual >= 120) {
                            resultado = "Apto";
                        }

                    } else if (trabajoActual.equals("transporte")) {
                        if (potenciaActual >= 90) {
                            resultado = "Apto";
                        }
                    } else if (trabajoActual.equals("siembra")) {
                        if (potenciaActual >= 70) {
                            resultado = "Apto";
                        }
                    }
                    // mostramos el resultado
                    System.out.println("El tractor " + marcaActual + " es: " + resultado);

                    // Mensaje aleatorio.
                    // Math.random() nos da un numero entre 0.0 y 0.999
                    // Si es mayor de 0.5 decimos una frase, si es menor, otra.
                    if (resultado.equals("APTO")) {
                        // Mensajes positivos aleatorios
                        if (Math.random() > 0.5) {
                            System.out.println("Comentario: ¡Una máquina excelente!");
                        } else {
                            System.out.println("Comentario: Este tractor aguantará lo que le echen.");
                        }
                    } else {
                        // Mensajes negativos aleatorios ("NO APTO")
                        if (Math.random() > 0.5) {
                            System.out.println("Comentario: Le falta potencia, se va a calar.");
                        } else {
                            System.out.println("Comentario: Necesitas un motor más grande para esto.");
                        }

                    }

                }
            } else if (opcion == 4) {
                if (marcas.isEmpty()) {
                    System.out.println("No hay tractores para eliminar.");
                } else {

                    // PASO 2: MOSTRAR LA LISTA (Para que el usuario elija)
                    // (recordar qué índice tiene cada uno)
                    System.out.println("Lista actual:");
                    for (int i = 0; i < marcas.size(); i++) {
                        System.out.println(i + " - " + marcas.get(i));
                    }
                }
                // pedimos el indice a borrar
                int indiceBorrar = -1;
                while (indiceBorrar < 0 || indiceBorrar >= marcas.size()) {
                    System.out.println("introduce el indice del tractor a eliminar");
                    String textoIndice = scanner.nextLine();

                    try {
                        indiceBorrar = Integer.parseInt(textoIndice);
                    } catch (Exception e) {
                        indiceBorrar = -1; // si escribe letras formazamos el error para repetir
                    }
                    if (indiceBorrar<0 || indiceBorrar >= marcas.size()) {
                        System.out.println(("Error: indice no valido"));
                    }
                }
                //luego de evaluar lo borramos. 

                // se guarda antes de borrar
                String nombreBorrado = marcas.get(indiceBorrar);

                marcas.remove(indiceBorrar);
                potencias.remove(indiceBorrar);
                trabajos.remove(indiceBorrar);

                //confirmamos el borrado

                System.out.println("tractor elminado: "+ nombreBorrado);
                System.out.println( "quedan "+ marcas.size() + "tractores en la lista");
            } else if( opcion == 0){
                System.out.println("salir del programa");
            }else{
                System.out.println("no es una opcion valida. ");
            }
        }
    }
}
