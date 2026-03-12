package UD6.Relación1.Ejercicio1;

class Televisor extends Electrodomestico {
    // atributos 

    private double tamañoPantalla;

    //contructor
    public Televisor(String marca, String modelo, double tamañoPantalla) {
        super(marca, modelo);
        this.tamañoPantalla = tamañoPantalla;
    }

    // getter y setter 
    public double getTamañoPantalla() {
        return tamañoPantalla;
    }

    public void setTamañoPantalla(double tamañoPantalla) {
        this.tamañoPantalla = tamañoPantalla;
    }
    // metodos para mostrar 

    @Override
    public String toString() {
        return "el tamaño de pantalla es de :" + tamañoPantalla; 
    }

}
