package UD6.Repaso1;

abstract class PersonaAgrupacion {
    private String nombre;
    private int edad, antiguedad;

    public PersonaAgrupacion(String nombre, int edad, int antiguedad) {
        setNombre(nombre);
        setEdad(edad);
        setAntiguedad(antiguedad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty() || !nombre.matches(".*[0-9].*")) {
            this.nombre = nombre;
        } else {
            this.nombre = "[Nombre inválido]";
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            this.edad = -1;
        }
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        if (antiguedad >= 0) {
            this.antiguedad = antiguedad;
        } else {
            this.antiguedad = -1;
        }
    }

    public abstract double calcularAportacion();

    public abstract boolean puedeParticipar();

    public void cumplirAnio() {
        this.edad++;
    }

    public void aumentarAntiguedad() {
        this.antiguedad++;
    }
}