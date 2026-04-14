package UD6.EjerciciosREPASO;

// Una interfaz es un contrato
// quien la implemente esta OBLIGADO a escribir estos metodos
public interface Asignable {
    // devuelve true si la asignacion se realizo correctamente
    // devuelve false si algo salio mal
    // recibe el nombre del instrumento y su valor
    boolean asignarInstrumento(String nombreInstrumento, double valorInstrumento);
    
    // devuelve true si la asignacion se realizo correctamente
    // devuelve false si algo salio mal
    // recibe el nombre del instrumento y su valor
    boolean quitarInstrumento(String nombreInstrumento, double valorInstrumento);
}
