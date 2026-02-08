import java.util.Scanner;

public class PT1conFunction {

    // Esta función es tu "Especialista en pedir números"
    public static int numeroValidoMadera(Scanner scanner, String mensaje) {
        int numero = 0;
        do {
            try {
                System.out.print(mensaje); // Usamos el parámetro 'mensaje'
                numero = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("ERROR: Debes ingresar un número entero válido.");
                numero = -1; // Forzamos el error para repetir
            }
        } while (numero <= 0);

        return numero; // Devuelve el número validado al Jefe
    }

    public static double numeroDecimalAcero(Scanner scanner, String mensaje) {
        double numero = -1;
        do {
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(scanner.nextLine());

            } catch (Exception e) {
                System.out.println("ERROR: Introduce un numero decimal valido. ");
                numero = -1;
            }
        } while (numero <= 0);
        return numero;
    }

    public static String pedirTextoValido(Scanner scanner, String mensaje) {
        String texto = "";
        while (!texto.equals("flecha") && !texto.equals("escudo") && !texto.equals("espada")) {
            System.out.print(mensaje);
            texto = scanner.nextLine().toLowerCase();
            if (!texto.equals("flecha") && !texto.equals("escudo") && !texto.equals("espada")) {
                System.out.println("opcion no valida. intenta de nuevo");
            }
        }
        return texto;
    }

    public static String solicitarTipoArticulo(Scanner scanner) {
        String tipo = "";
        // Mientras NO sea uno de los tres válidos, sigue preguntando
        while (!tipo.equals("flecha") && !tipo.equals("escudo") && !tipo.equals("espada")) {
            System.out.print("Tipo de artículo (flecha/escudo/espada): ");
            tipo = scanner.nextLine().toLowerCase(); // Convertimos a minúsculas
        }
        return tipo;
    }

    public static boolean verificarStockSuperado(int maderaGastada, int maderaAcumulada, int stockDeMadera,
            double aceroGastado, double aceroAcumulado, double stockDeAcero) {

        if (maderaGastada + maderaAcumulada > stockDeMadera) {
            System.out.println("¡Alerta! Has superado el stock de madera");
            return true;
        }
        if (aceroGastado + aceroAcumulado > stockDeAcero) {
            System.out.println("¡Alerta! Has superado el stock de acero");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroDeEncargos = numeroValidoMadera(scanner, "numero de encargos a realizar: ");
        int stockMadera = numeroValidoMadera(scanner, "Stock inicial de madera: ");

        double stockAcero = numeroDecimalAcero(scanner, "Stock inical de Acero: ");
        int stockDeMadera = 0;
        double stockDeAcero = 0;

        // Variables de bucle y cálculos
        int i = 0;
        String tipoArticulo = "";
        int unidades = 0;

        // Acumuladores de gestión (contadores)
        int maderaGastada = 0, maderaAcumulada = 0;
        double aceroGastado = 0, aceroAcumulado = 0;

        // Dinero y estadísticas
        double importeCobrado = 0; // Usamos double por seguridad con precios
        double importeTotal = 0;
        int encargoRegistrado = 0;
        int flechaVendida = 0, escudoVendido = 0, espadaVendida = 0;

        // Stocks finales
        int stockMaderaRestante = 0;
        double stockAceroRestante = 0;

        // Bandera de control
        boolean stockSuperado = false;

        // Constantes
        final double PRECIOFLECHA = 2, PRECIOESCUDO = 30, PRECIOESPADA = 25;
        final int MADERAFLECHA = 1, MADERAESCUDO = 3, MADERAESPADA = 1;
        final double ACEROFLECHA = 0.05, ACEROESCUDO = 1.5, ACEROESPADA = 1.2;
        for (i = 1; i <= numeroDeEncargos && !stockSuperado; i++) {

            System.out.println("\n--- Encargo " + i + " ---");

            // Usamos la función para pedir el texto validado
            tipoArticulo = solicitarTipoArticulo(scanner);

            // Usamos la función para pedir las unidades validadas
            unidades = numeroValidoMadera(scanner, "Unidades (>= 0): ");

            // --- LÓGICA DE CÁLCULO (Igual que tu JS) ---

            if (tipoArticulo.equals("flecha")) {

                maderaGastada = unidades * MADERAFLECHA;
                aceroGastado = unidades * ACEROFLECHA;

                // Verificamos stock
                stockSuperado = verificarStockSuperado(maderaGastada, maderaAcumulada, stockDeMadera, aceroGastado,
                aceroAcumulado, stockDeAcero);

                if (!stockSuperado) {
                    // Si hay stock, procesamos la venta
                    maderaAcumulada += maderaGastada;
                    aceroAcumulado += aceroGastado;
                    importeCobrado = unidades * PRECIOFLECHA;
                    flechaVendida += unidades;
                }

            } else if (tipoArticulo.equals("espada")) {

                aceroGastado = unidades * ACEROESPADA;
                maderaGastada = unidades * MADERAESPADA;

                stockSuperado = verificarStockSuperado(maderaGastada, maderaAcumulada, stockDeMadera, aceroGastado,
                        aceroAcumulado, stockDeAcero);

                if (!stockSuperado) {
                    maderaAcumulada += maderaGastada;
                    aceroAcumulado += aceroGastado;
                    importeCobrado = unidades * PRECIOESPADA;
                    espadaVendida += unidades;
                }

            } else { // Si es ESCUDO

                maderaGastada = unidades * MADERAESCUDO;
                aceroGastado = unidades * ACEROESCUDO;

                stockSuperado = verificarStockSuperado(maderaGastada, maderaAcumulada, stockDeMadera, aceroGastado,
                        aceroAcumulado, stockDeAcero);

                if (!stockSuperado) {
                    maderaAcumulada += maderaGastada;
                    aceroAcumulado += aceroGastado;
                    importeCobrado = unidades * PRECIOESCUDO;
                    escudoVendido += unidades;
                }
            }

            // --- FIN DEL ENCARGO ACTUAL ---

            // Si NO se superó el stock, confirmamos la transacción e imprimimos detalles
            if (!stockSuperado) {
                encargoRegistrado++;
                importeTotal += importeCobrado;

                System.out.println("Artículo: " + tipoArticulo + " | Unidades: " + unidades + " | Importe cobrado: "
                        + importeCobrado);
                System.out.println("Madera gastada: " + maderaGastada + " | Acumulada: " + maderaAcumulada);
                System.out.println("Acero gastado: " + aceroGastado + " kg | Acumulada: " + aceroAcumulado);
            }

        } // Fin del bucle FOR

        // ---------------------------------------------------------
        // 4. RESUMEN FINAL
        // ---------------------------------------------------------

        stockMaderaRestante = stockDeMadera - maderaAcumulada;
        stockAceroRestante = stockDeAcero - aceroAcumulado;

        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Encargos registrados: " + encargoRegistrado + " de " + numeroDeEncargos);
        System.out.println(
                "Unidades -> Flecha: " + flechaVendida + " | Escudo: " + escudoVendido + " | Espada: " + espadaVendida);
        System.out.println("Consumo total -> Madera: " + maderaAcumulada + " varas | Acero: " + aceroAcumulado + " kg");
        System.out.println(
                "Stock restante -> Madera: " + stockMaderaRestante + " varas | Acero: " + stockAceroRestante + " kg");
        System.out.println("Importe total: " + importeTotal + " monedas");

        if (stockSuperado) {
            System.out.println("Registro interrumpido por superación de stock");
        } else {
            System.out.println("Mensaje final: Registro completado con éxito");
        }

        scanner.close();
    } // Fin del main

}
