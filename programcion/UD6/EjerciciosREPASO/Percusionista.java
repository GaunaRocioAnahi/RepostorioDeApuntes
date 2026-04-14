package UD6.EjerciciosREPASO;

/**
 * CLASE PERCUSIONISTA
 * - Hereda de Musico (Herencia): Ya tiene nombre, edad, nivel y asistencia.
 * - Implementa Asignable (Interfaz): Debe gestionar sus propios instrumentos.
 */
public class Percusionista extends Musico implements Asignable {

    // =====================
    // ATRIBUTOS PROPIOS
    // =====================
    // Definidos según la Parte 6 del enunciado.
    private int numeroInstrumentos;
    private double valorInstrumentos;
    private int potenciaGolpe;
    private int cambiosRitmoCorrectos;

    // =====================
    // CONSTRUCTOR
    // =====================
    // Recibe datos de Persona, Musico y los específicos de Percusionista.
    public Percusionista(String nombre, int edad, int antiguedad, 
                         String instrumentoPrincipal, int nivel, int asistenciaEnsayos, double valorBase,
                         int potenciaGolpe, int cambiosRitmoCorrectos) {
        
        // super() envía los datos necesarios a la clase Musico.
        super(nombre, edad, antiguedad, instrumentoPrincipal, nivel, asistenciaEnsayos, valorBase);

        this.potenciaGolpe = potenciaGolpe;
        this.cambiosRitmoCorrectos = cambiosRitmoCorrectos;
        // Inicializamos los contadores de la interfaz en 0.
        this.numeroInstrumentos = 0;
        this.valorInstrumentos = 0.0;
    }

    // =====================
    // GETTERS Y SETTERS
    // =====================
    public int getNumeroInstrumentos() { return numeroInstrumentos; }
    public double getValorInstrumentos() { return valorInstrumentos; }
    public int getPotenciaGolpe() { return potenciaGolpe; }
    public void setPotenciaGolpe(int potenciaGolpe) { this.potenciaGolpe = potenciaGolpe; }
    public int getCambiosRitmoCorrectos() { return cambiosRitmoCorrectos; }

    // =====================
    // MÉTODOS OVERRIDE
    // =====================

    /**
     * a) calcularAportacion
     * Fórmula: Aportación base de músico + (potencia * 2) + (ritmos * 4) + (valorInst * 0.03).
     */
    @Override
    public double calcularAportacion() {
        return super.calcularAportacion() + (potenciaGolpe * 2) + (cambiosRitmoCorrectos * 4) + (valorInstrumentos * 0.03);
    }

    /**
     * b) puedeParticipar
     * Regla: Debe cumplir lo de músico Y tener potencia de golpe >= 4.
     */
    @Override
    public boolean puedeParticipar() {
        return super.puedeParticipar() && potenciaGolpe >= 4;
    }

    /**
     * c) asignarInstrumento
     * Sigue las mismas reglas de validación que el Trompetista.
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
     * d) quitarInstrumento
     * Resta un instrumento y su valor, asegurando que el valor no sea negativo.
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
     * e) registrarCambioRitmoCorrecto: Suma 1 al contador de ritmos.
     */
    public void registrarCambioRitmoCorrecto() {
        this.cambiosRitmoCorrectos++;
    }

    /**
     * f) aumentarPotencia: Suma la cantidad solo si es positiva.
     */
    public void aumentarPotencia(int cantidad) {
        if (cantidad > 0) {
            this.potenciaGolpe += cantidad;
        }
    }
}