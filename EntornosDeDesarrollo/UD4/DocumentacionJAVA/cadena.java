public class cadena {
    /**
     * Metodo que invierte una cadena de texto.
     * 
     * 
     */
    public static String revertirCadena(String cadenaTexto) {
        int cadena = cadenaTexto.length();

        String cadenaInvertida="";
        for (int i = 1; i < cadena ; i++){
            cadenaInvertida += cadenaTexto.charArt(cadena -i);
        }
        return cadenaInvertida;
    }
public static void main(String[] args) {
    System.out.println(revertirCadena("hola"));
}
}
