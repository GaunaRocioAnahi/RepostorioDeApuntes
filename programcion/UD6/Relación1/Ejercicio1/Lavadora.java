package UD6.Relación1.Ejercicio1;

class Lavadora extends Electrodomestico {
    
    // atributos 

    private double capacidadCarga;

    public Lavadora(String marca, String modelo, double capacidadCarga) {
        super(marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }  

    
}
