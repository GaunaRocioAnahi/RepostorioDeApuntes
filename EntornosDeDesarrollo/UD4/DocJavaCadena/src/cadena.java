package src;
public class cadena {
    /**
     * 
     * @param cadenaTexto
     * @return devuelve la cadena de texto invertida.
     */
    public static String revertirCadena(String cadenaTexto) {
        int cadena = cadenaTexto.length();
        String cadenaInvertida = "";
        for(int i=1; i <cadena; i++){
            cadenaInvertida += cadenaTexto.charAt(i);
        }
        return cadenaInvertida;
    }
    public static void main(String[] args) {
        System.out.println(revertirCadena("hola"));
    }
}
