public class pt1 {

    public static void main ( String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Numero de encargos: ");
        int numeroEncargos = Scanner.nextInt();
        while (numeroEncargos <= 0) {
            System.out.print("Numero de encargos (>0) : ");
           numeroEncargos = Scanner.nextInt(); 
        }

    }
    
}