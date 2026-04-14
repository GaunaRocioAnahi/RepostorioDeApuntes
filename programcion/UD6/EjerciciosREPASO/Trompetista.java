package UD6.EjerciciosREPASO;

/**
 * CLASE TROMPETISTA
 * - Hereda de Musico (Herencia): Obtiene nombre, edad, nivel, etc.
 * - Implementa Asignable (Interfaz): Obliga a gestionar instrumentos.
 */
public class Trompetista extends Musico implements Asignable {

    // =====================
    // ATRIBUTOS PROPIOS
    // =====================
    // Definidos según la Parte 5 del enunciado.
    private int numeroInstrumentos;
    private double valorInstrumentos;
    private int resistencia;
    private int numeroSolos;

    // =====================
    // CONSTRUCTOR
    // =====================
    // Debe recibir TODO: los datos del abuelo (Persona), del padre (Musico) y los suyos.
    public Trompetista(String nombre, int edad, int antiguedad, 
                       String instrumentoPrincipal, int nivel, int asistenciaEnsayos, double valorBase,
                       int resistencia, int numeroSolos) {
        
        // Llamada al constructor de Musico. 
        // Nota: numeroInstrumentos y valorInstrumentos empiezan en 0, no hace falta pasarlos.
        super(nombre, edad, antiguedad, instrumentoPrincipal, nivel, asistenciaEnsayos, valorBase);

        this.resistencia = resistencia;
        this.numeroSolos = numeroSolos;
        this.numeroInstrumentos = 0;
        this.valorInstrumentos = 0.0;
    }

    // =====================
    // GETTERS Y SETTERS
    // =====================
    public int getNumeroInstrumentos() { return numeroInstrumentos; }
    public double getValorInstrumentos() { return valorInstrumentos; }
    public int getResistencia() { return resistencia; }
    public void setResistencia(int resistencia) { this.resistencia = resistencia; }
    public int getNumeroSolos() { return numeroSolos; }
    public void setNumeroSolos(int numeroSolos) { this.numeroSolos = numeroSolos; }

    // =====================
    // MÉTODOS OVERRIDE
    // =====================

    /**
     * a) calcularAportacion
     * Usa super.calcularAportacion() para obtener el cálculo base del músico 
     * y le suma los bonus específicos de la trompeta.
     */
    @Override
    public double calcularAportacion() {
        return super.calcularAportacion() + resistencia + (numeroSolos * 3) + (valorInstrumentos * 0.05);
    }

    /**
     * b) puedeParticipar
     * Combina la lógica del padre (asistencia >= 3) con la propia (resistencia >= 5).
     */
    @Override
    public boolean puedeParticipar() {
        return super.puedeParticipar() && resistencia >= 5;
    }

    /**
     * c) asignarInstrumento (de Interfaz Asignable)
     * Verifica que los datos sean válidos antes de actualizar el estado.
     */
    @Override
    public boolean asignarInstrumento(String nombreInstrumento, double valorInstrumento) {
        if (nombreInstrumento == null || nombreInstrumento.isEmpty() || valorInstrumento <= 0) {
            return false;
        }
        this.numeroInstrumentos++;
        this.valorInstrumentos += valorInstrumento;
        return true;
    }

    /**
     * d) quitarInstrumento (de Interfaz Asignable)
     * Resta valores y asegura que el valor económico no sea negativo.
     */
    @Override
    public boolean quitarInstrumento(String nombreInstrumento, double valorInstrumento) {
        if (this.numeroInstrumentos == 0 || valorInstrumento <= 0) {
            return false;
        }
        this.numeroInstrumentos--;
        this.valorInstrumentos -= valorInstrumento;
        if (this.valorInstrumentos < 0) {
            this.valorInstrumentos = 0;
        }
        return true;
    }

    // =====================
    // MÉTODOS PROPIOS
    // =====================

    /**
     * e) registrarSolo: Aumenta el contador de solos.
     */
    public void registrarSolo() {
        this.numeroSolos++;
    }

    /**
     * f) aumentarResistencia: Suma resistencia solo si la cantidad es positiva.
     */
    public void aumentarResistencia(int cantidad) {
        if (cantidad > 0) {
            this.resistencia += cantidad;
        }
    }
}
