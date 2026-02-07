import java.util.Scanner;

public class pt1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // variables
        int numeroDeEncargos;
        int stockMadera = 0;
        double stockAcero = 0;
        int maderaGastada = 0, maderaAcumulada = 0;
        double aceroGastado = 0, aceroAcumulado = 0;
        int importeCobrado = 0;
        int encargosRegistrado = 0;
        int flechaVendida = 0, escudoVendido = 0, espadaVendida = 0;
        double stockAceroRestant = 0;
        int stockMaderaRestante = 0;
        double importeTotal = 0;
        String tipoDeArticulo = "";
        int unidades = 0;

        double precioActual = 0; // para calcular el importe

        final int PRECIOFLECHA = 2, PRECIOESCUDO = 30, PRECIOESPADA = 25;
        final int MADERAFLECHA = 1, MADERAESCUDO = 3, MADERAESPADA = 1;
        final double ACEROFLECHA = 0.05, ACEROESCUDO = 1.5, ACEROESPADA = 1.2;

        boolean stockSuperado = false;
        boolean entradaValida = false;

        // Primero pedimos el numeros de encargos.
        do {
            try {
                System.out.print("Numero de encargo:");
                numeroDeEncargos = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (Exception e) {
                numeroDeEncargos = 0;
                System.out.println("Error al leer entero");
                numeroDeEncargos = 0;
                entradaValida = false;
            }
        } while (numeroDeEncargos <= 0);
        // Pedimos el stock de madera.
        do {
            try {
                System.err.print("Ingrese el stock de madera: ");
                stockMadera = Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                System.out.print("Error: Debes ingresar un numero entero");
                stockMadera = 0;
            }
        } while (stockMadera <= 0);
        // Pedimos el stock de Acero.
        do {
            try {
                System.out.print("Ingrese el stock de acero: ");
                stockAcero = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Error: Debes ingresar un numero valido");
                stockAcero = 0;
            }
        } while (stockAcero <= 0);
        // Proceso de encargos.
        for (int i = 1; i <= numeroDeEncargos && !stockSuperado; i++) {
            System.out.println("---- Encargos" + i + "----");
            tipoDeArticulo = "";
            unidades = 0;

            // Seleccion de articulos
            while (!tipoDeArticulo.equals("flecha") && !tipoDeArticulo.equals("escudo")
                    && !tipoDeArticulo.equals("espada")) {
                System.out.print("Tipo de articulo ( flecha/escudo/espada): ");
                tipoDeArticulo = scanner.nextLine().toLowerCase();
            }
            // TRY CATCH DE LOS ARTICULOS.

            do {
                try {
                    System.out.print("Unidades (>=0):");
                    unidades = Integer.parseInt(scanner.nextLine());

                } catch (Exception e) {
                    System.out.println("ERROR: Introduce un numero valido. ");
                    unidades = -1;
                }
            } while (unidades <= 0);

            // tipo de articulo elegido

            if (tipoDeArticulo.equals("flecha")) {
                maderaGastada = unidades * MADERAFLECHA;
                aceroGastado = unidades * ACEROFLECHA;
                precioActual = unidades * PRECIOFLECHA;
                if (maderaGastada + maderaAcumulada > stockMadera) {
                    stockSuperado = true;
                    System.out.println("¡Alerta!HAS SUPERADO EL STOCK DE MADERA.");
                } else if (aceroGastado + aceroAcumulado > stockAcero) {
                    stockSuperado = true;
                    System.out.println("¡Alerta! has superado el stock de acero");

                } else {
                    maderaAcumulada += maderaGastada;
                    aceroAcumulado += aceroGastado;
                    importeCobrado += precioActual;
                    flechaVendida += unidades;
                }
            } else if (tipoDeArticulo.equals("espada")) {
                maderaGastada = unidades * MADERAESPADA;
                aceroGastado = unidades * ACEROESPADA;
                precioActual = unidades * PRECIOESPADA;

                if (maderaGastada + maderaAcumulada > stockMadera) {
                    stockSuperado = true;
                    System.out.print("¡Alerta! Has superado el stock de madera.");

                } else if (aceroGastado + aceroAcumulado > stockAcero) {
                    stockSuperado = true;
                    System.out.print("¡Alerta! Has superado el stock de acero");
                } else {
                    maderaAcumulada += maderaGastada;
                    aceroAcumulado += aceroGastado;
                    importeCobrado += precioActual;
                    espadaVendida += unidades;
                }

            } else {
                maderaGastada = unidades * MADERAESCUDO;
                aceroGastado = unidades * ACEROESCUDO;
                precioActual = unidades * PRECIOESCUDO;
                if (maderaGastada + maderaAcumulada > stockMadera) {
                    stockSuperado = true;
                    System.out.println("¡Alerta!Has superado el stock de madera.");
                } else if (aceroGastado + aceroAcumulado > stockAcero) {
                    stockSuperado = true;
                    System.out.print("¡Alerta! Has superado el stock de acero.");
                } else {
                    maderaAcumulada += maderaGastada;
                    aceroAcumulado += aceroGastado;
                    importeCobrado += precioActual;
                    escudoVendido += unidades;
                }
            }
            // confirmacion de encargo si no hubo error en el stock.
            if (!stockSuperado) {
                encargosRegistrado++;
                importeTotal += importeCobrado; // total de todo.
                System.out.println("Articulo: " + tipoDeArticulo + " |Unidades: " + unidades + "|Importe cobrado: "
                        + importeCobrado);
                System.out.println("Madera gastada: " + maderaGastada + "| Acumulada: " + maderaAcumulada);
                System.out.println("Acero Gastado: " + aceroGastado + " Kg| Acero Acumulado " + aceroAcumulado);
            }
        }

        stockMaderaRestante = stockMadera - maderaAcumulada;
        stockAceroRestant = stockAcero - aceroAcumulado;
        System.out.println("=== Resumen Final ===");
        System.out.println("Encargos registrados:  "+ encargosRegistrado + " de "+ numeroDeEncargos );
        System.out.println("Unidades -> Flecha: " + flechaVendida + " | Escudo: "+ escudoVendido + "| Espada: "+ espadaVendida );
        System.out.println("consumo total -> Madera:   "+ maderaAcumulada + " Varas| Acero :  "+ aceroAcumulado+ " Kg");
        System.out.println("Stock restante -> madera:  "+ stockMaderaRestante + " Varas | Acero :  "+ stockAceroRestant +" Kg" );
        System.out.println("Importe total: "+ importeTotal + " monedas ");

        if (stockSuperado){
            System.out.println("Registro interrumpido por superacion de stock");
        }else{
            System.out.println("Mensaje final : Registro completado con exito");
        }
        scanner.close();
    }

}