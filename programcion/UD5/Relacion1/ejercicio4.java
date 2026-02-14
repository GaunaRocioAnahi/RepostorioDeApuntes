package programcion.UD5.Relacion1;

public class ejercicio4 {
    public static void main(String[] args) {
        Auto coche = new Auto("vitara", "nuevo", 150.00);
        System.out.println(coche.velocidadActual);
        coche.acelerar(25.00);
        System.out.println(coche.velocidadActual);
        coche.frenar(50);
        System.out.println(coche.velocidadActual);
    }

}

class Auto {
    String nombre;
    String modelo;
    double velocidadActual;

    Auto(String nombre, String modelo, double velocidadActual) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.velocidadActual = velocidadActual;

    }

    void acelerar(double cantidad) {
        cantidad += velocidadActual;

    }

    void frenar(double cantidad) {
        velocidadActual -= cantidad;

    }
}