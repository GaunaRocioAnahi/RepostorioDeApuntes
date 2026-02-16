package programcion.UD5.Relacion1;

public class Ejercicio7 {
    public static void main(String[] args) {
        Lampara lampara = new Lampara();
        System.out.println("Estado inicial: " + lampara);
        
        lampara.encender();
        System.out.println("Estado actual: " + lampara);
        
        lampara.apagar();
        System.out.println("Estado actual: " + lampara);
        
        lampara.encender();
        System.out.println("Estado actual: " + lampara);
    }
}
class  Lampara {
    // Atributo: estado (puede ser boolean o String)
    boolean estado;  // true = encendida, false = apagada
    
    // Constructor
    Lampara() {
        this.estado = false;  // Empieza apagada
    }
    
    // Método para encender
    void encender() {
        this.estado = true;
        System.out.println("La lámpara está encendida");
    }
    
    // Método para apagar
    void apagar() {
        this.estado = false;
        System.out.println("La lámpara está apagada");
    }
    
    // toString() para ver el estado
    @Override
    public String toString() {
        String estadoTexto = estado ? "encendida" : "apagada";
        return "Lámpara: " + estadoTexto;
    }
}  

    
