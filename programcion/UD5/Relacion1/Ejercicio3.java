package programcion.UD5.Relacion1;

public class Ejercicio3 {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("pablo", "Tecnologia", 6.8);
        System.out.println(alumno);
    }

}

class Alumno {
    String nombre;
    String materia;
    double calificacion;

    Alumno(String nombre, String materia, double calificacion) {
        this.nombre = nombre;
        this.materia = materia;
        this.calificacion = calificacion;
    }

    boolean aprobo() {

        return calificacion >= 6;
    }
    @Override
    public String toString(){
        // me va a mostrar esta cadena si la llamo en el main.
        // es recomendable para facilitar la depuracion del codigo. 
        // se ve la informacion completa del objeto. 
        String mensajeAporbado = (this.aprobo())? "esta apobado" : "Esta suspendo";

        return "nombre: " + this.nombre + "| materia:  "+ this.materia + "| calificacion : " + this.calificacion + " | " + mensajeAporbado;
    }
}
