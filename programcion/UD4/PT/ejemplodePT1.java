
import java.util.Scanner;

public class ejemplodePT1 {

    public static void main(String[] args) {
        // Herramienta para leer datos de la consola
        Scanner sc = new Scanner(System.in);

        // --- 1. ENTRADA DE CONFIGURACIÓN INICIAL ---
        System.out.print("Número de encargos: ");
        int numeroEncargos = sc.nextInt();
        while (numeroEncargos <= 0) {
            System.out.print("Número de encargos (debe ser mayor a 0): ");
            numeroEncargos = sc.nextInt();
        }

        System.out.print("Stock de madera (varas): ");
        double stockMadera = sc.nextDouble();
        while (stockMadera <= 0) {
            System.out.print("Stock de madera (debe ser mayor a 0): ");
            stockMadera = sc.nextDouble();
        }

        System.out.print("Stock de acero (kg): ");
        double stockAcero = sc.nextDouble();
        while (stockAcero <= 0) {
            System.out.print("Stock de acero (debe ser mayor a 0): ");
            stockAcero = sc.nextDouble();
        }

        // --- 2. VARIABLES DE SEGUIMIENTO (Tus variables originales) ---
        double maderaGastadaAcumulada = 0, aceroGastadoAcumulado = 0;
        double importeTotal = 0;
        int flechasVendidas = 0, escudosVendidos = 0, espadasVendidas = 0;
        int encargosRegistrados = 0;
        boolean stockSuperado = false;

        // CONSTANTES DE FABRICACIÓN
        final double MADERA_FLECHA = 1, ACERO_FLECHA = 0.05, PRECIO_FLECHA = 2;
        final double MADERA_ESCUDO = 3, ACERO_ESCUDO = 1.5, PRECIO_ESCUDO = 30;
        final double MADERA_ESPADA = 1, ACERO_ESPADA = 1.2, PRECIO_ESPADA = 25;

        // --- 3. BUCLE DE PROCESAMIENTO ---
        for (int i = 1; i <= numeroEncargos && !stockSuperado; i++) {
            System.out.println("\n--- Encargo " + i + " ---");
            
            // Validación del tipo de artículo
            System.out.print("Tipo de artículo (flecha/escudo/espada): ");
            String tipoArticulo = sc.next().toLowerCase();
            while (!tipoArticulo.equals("flecha") && !tipoArticulo.equals("escudo") && !tipoArticulo.equals("espada")) {
                System.out.print("Error. Ingrese (flecha/escudo/espada): ");
                tipoArticulo = sc.next().toLowerCase();
            }

            // Validación de unidades
            System.out.print("Unidades: ");
            int unidades = sc.nextInt();
            while (unidades <= 0) {
                System.out.print("Unidades (debe ser mayor a 0): ");
                unidades = sc.nextInt();
            }

            // Variables temporales para el cálculo del encargo actual
            double maderaNecesaria = 0, aceroNecesario = 0, precioUnitario = 0;

            // Lógica de asignación (reemplaza los if/else múltiples por un switch más limpio)
            switch (tipoArticulo) {
                case "flecha":
                    maderaNecesaria = unidades * MADERA_FLECHA;
                    aceroNecesario = unidades * ACERO_FLECHA;
                    precioUnitario = PRECIO_FLECHA;
                    break;
                case "escudo":
                    maderaNecesaria = unidades * MADERA_ESCUDO;
                    aceroNecesario = unidades * ACERO_ESCUDO;
                    precioUnitario = PRECIO_ESCUDO;
                    break;
                case "espada":
                    maderaNecesaria = unidades * MADERA_ESPADA;
                    aceroNecesario = unidades * ACERO_ESPADA;
                    precioUnitario = PRECIO_ESPADA;
                    break;
            }

            // --- 4. VERIFICACIÓN DE STOCK ---
            if (maderaGastadaAcumulada + maderaNecesaria > stockMadera) {
                System.out.println("¡Alerta! Has superado el stock de madera.");
                stockSuperado = true;
            } else if (aceroGastadoAcumulado + aceroNecesario > stockAcero) {
                System.out.println("¡Alerta! Has superado el stock de acero.");
                stockSuperado = true;
            } else {
                // Si hay stock, actualizamos acumuladores
                maderaGastadaAcumulada += maderaNecesaria;
                aceroGastadoAcumulado += aceroNecesario;
                
                double importeEncargo = unidades * precioUnitario;
                importeTotal += importeEncargo;
                encargosRegistrados++;

                // Contador por tipo
                if (tipoArticulo.equals("flecha")) flechasVendidas += unidades;
                else if (tipoArticulo.equals("escudo")) escudosVendidos += unidades;
                else espadasVendidas += unidades;

                System.out.println("Encargo registrado con éxito.");
            }
        }

        // --- 5. RESUMEN FINAL ---
        double stockMaderaRestante = stockMadera - maderaGastadaAcumulada;
        double stockAceroRestante = stockAcero - aceroGastadoAcumulado;

        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Encargos registrados: " + encargosRegistrados + " de " + numeroEncargos);
        System.out.println("Unidades -> Flecha: " + flechasVendidas + " | Escudo: " + escudosVendidos + " | Espada: " + espadasVendidas);
        System.out.printf("Consumo total -> Madera: %.2f varas | Acero: %.2f kg\n", maderaGastadaAcumulada, aceroGastadoAcumulado);
        System.out.printf("Stock restante -> Madera: %.2f varas | Acero: %.2f kg\n", stockMaderaRestante, stockAceroRestante);
        System.out.printf("Importe total: %.2f monedas\n", importeTotal);

        if (!stockSuperado) {
            System.out.println("Registro completado con éxito.");
        } else {
            System.out.println("Registro interrumpido por superación de stock.");
        }

        sc.close(); // Cerrar el scanner
    }
}