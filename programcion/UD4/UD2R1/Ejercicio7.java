package programcion.UD4.UD2R1;

import java.util.ArrayList;

public class Ejercicio7 {
    public static void main(String[] args) {
        ArrayList<String> dias =  new ArrayList<>();
        dias.add("L");  
        dias.add("M");  
        dias.add("M");  
        dias.add("J");  
        dias.add("V");  
        dias.add("S");  
        dias.add("D");
        
        dias.set(dias.size()-1,"Domingo(FIN DE SEMANA)");
        System.out.println(String.join("-", dias));
    }
}
