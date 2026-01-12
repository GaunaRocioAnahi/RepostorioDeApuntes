import java.util.Scanner;

public class pt1 {

    public static void main ( String[] args) {
        
        Scanner scanner = new Scanner (System.in);
        System.out.print("Numero de encargos: ");
        int numeroEncargos = Scanner.nextInt();
        scanner.nextLine();
        while (numeroEncargos <= 0) {
            System.out.print("Numero de encargos (>0) : ");
            numeroEncargos = Scanner.nextInt(); 
        }
        
        System.out.print( "Stock de maderas :");
        int stockMadera = Scanner.nextInt();
        While (stockMadera <= 0) {
            System.out.print( "Stock de maderas (>0) :");
            stockMadera = Scanner.nextInt();
        }
        
        System.out.print("Stock de acero (kg): ");
        double stockAcero = Scanner.nextDouble();
        while (stockAcero <= 0) {
            System.out.print("Stock de acero (> 0): ");
            stockAcero = Scanner.nextDouble();
        }

        double maderaGatada = 0, maderaGastadaAcumulada = 0;
        int aceroGastado = 0, aceroGastadoAcumulado = 0;
        double importe = 0;
        int stockMaderaRestante = 0, stockAceroRestante = 0;
        int flechasVendidas = 0, escudosVendidos = 0, espadasVendidas = 0;






    }

}