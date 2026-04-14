package UD6.EjerciciosREPASO;



public abstract class PersonaAgrupacion {
    private String nombre;
    private int edad;
    private int  antiguedad; 

    public PersonaAgrupacion(String nombre, int edad, int antiguedad) {
        setNombre(nombre);
        setEdad(edad);
        setAntiguedad(antiguedad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return;
        }
        this.nombre = nombre;

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad<0) {
            return;
        }
        this.edad = edad;
    }

    public int  getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad( int antiguedad) {
        if (antiguedad <0) {
            return;
        }
        this.antiguedad = antiguedad;
    }
     ///==== METODOS ABSTRACTOS ====
    public abstract double calcularAportacion();
    public abstract boolean puedeParticipar();
    
   /// === CONCRETOS ===
    public void cumplirAnio(){
        edad++;
    }
    public void antiguedad(){
        antiguedad++;
    }
}
