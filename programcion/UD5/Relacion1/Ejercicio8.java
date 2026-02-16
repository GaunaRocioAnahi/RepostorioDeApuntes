package programcion.UD5.Relacion1;

public class Ejercicio8 {
    public static void main(String[] args) {
        Televisor tv = new Televisor(5, 20);
        System.out.println("Estado inicial: " + tv);

        tv.subirVolumen();
        tv.subirVolumen();
        tv.subirVolumen();
        System.out.println("Después de subir volumen 3 veces: " + tv);

        tv.bajarVolumen();
        System.out.println("Después de bajar volumen: " + tv);

        tv.cambiarCanal(10);
        System.out.println("Después de cambiar a canal 10: " + tv);

        tv.cambiarCanal(25);
        System.out.println("Después de cambiar a canal 25: " + tv);
    }
}

class Televisor {
    // Atributos
    int canalActual;
    int volumen;

    // Constructor
    Televisor(int canalActual, int volumen) {
        this.canalActual = canalActual;
        this.volumen = volumen;
    }

    // Método para subir volumen
    void subirVolumen() {
        if (volumen < 100) { // Límite máximo de volumen
            volumen++;
        } else {
            System.out.println("Volumen al máximo");
        }
    }

    // Método para bajar volumen
    void bajarVolumen() {
        if (volumen > 0) { // Límite mínimo de volumen
            volumen--;
        } else {
            System.out.println("Volumen al mínimo");
        }
    }

    // Método para cambiar canal
    void cambiarCanal(int nuevoCanal) {
        this.canalActual = nuevoCanal;
    }

    // toString() para mostrar canal y volumen
    @Override
    public String toString() {
        return "TV - Canal: " + canalActual + ", Volumen: " + volumen;
    }
}