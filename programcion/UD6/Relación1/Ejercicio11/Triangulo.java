package UD6.Relación1.Ejercicio11;

public class Triangulo extends Figura{ // extends cuando hereda. 
    private float base;
    private float altura;

    public Triangulo(float altura, float base) {
        this.altura = altura;
        this.base = base;
    }
    
    public void calcularArea(){
        setArea(base*altura/2);
    }

    @Override
    public String toString() {
        return "Triangulo [toString()=" + super.toString() + "]";
    }

    
}
