package UD6.Ejemplo;

public class Main {
    public static void main(String[] args) {

        Perro p = new Perro("Sora", "Podenco", 17.5);
        p.ladrar();
    }

}

class Animal {
    private String nombre;
    private double peso;

    public Animal(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
        System.out.println("Constructor de animal");
    }

    void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}

class Perro extends Animal {

    String raza;

    public Perro(String nombre, String raza, double peso) {
        super(nombre, peso);
        this.raza = raza;
        System.out.println("Constructor de perro");

    }


    void ladrar() {
        super.hacerSonido();
        System.out.println("GUAU");
    }

}

class Gato extends Animal {

    String raza;

    public Gato(String nombre, String raza, double peso) {
        super(nombre, peso);
        this.raza = raza;
        System.out.println("Constructor de gato");
    }

    void maullar() {
        super.hacerSonido();
        System.out.println("MIAU");
    }

}
