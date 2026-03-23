package UD6.Relación1.Ejercicio11;

public abstract class Figura {
    private float area;

    public Figura(){

    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public abstract void calcularArea();
}
