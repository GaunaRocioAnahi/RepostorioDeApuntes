package UD6.EjerciciosREPASO;

// ¿Cómo me doy cuenta de qué tipo de clase es?
// -> NO es abstracta porque el enunciado no lo pide, pero hereda de una.
// -> Musico ES UNA PersonaAgrupacion -> extends (herencia)
// -> Servirá de "Padre" para Trompetista y Percusionista.
public class Musico extends PersonaAgrupacion {

    // =====================
    // ATRIBUTOS PROPIOS
    // =====================
    // Usamos private para cumplir con el encapsulamiento.
    private String instrumentoPrincipal;
    private int nivel;                // Nivel de habilidad del músico
    private int asistenciaEnsayos;    // Contador de cuántas veces ha ensayado
    private double valorBase;         // Valor económico base asignado al músico

    // =====================
    // CONSTRUCTOR
    // =====================
    // Recibe los 3 atributos del padre (PersonaAgrupacion) + los 4 propios de Musico.
    public Musico(String nombre, int edad, int antiguedad, 
                  String instrumentoPrincipal, int nivel, int asistenciaEnsayos, double valorBase) {
        
        // Llamada obligatoria al constructor del padre (PersonaAgrupacion)
        super(nombre, edad, antiguedad);

        // Asignación de los atributos propios de esta clase
        this.instrumentoPrincipal = instrumentoPrincipal;
        this.nivel = nivel;
        this.asistenciaEnsayos = asistenciaEnsayos;
        this.valorBase = valorBase;
    }

    // =====================
    // GETTERS Y SETTERS
    // =====================

    public String getInstrumentoPrincipal() {
        return instrumentoPrincipal;
    }

    public void setInstrumentoPrincipal(String instrumentoPrincipal) {
        this.instrumentoPrincipal = instrumentoPrincipal;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel >= 0) { // Control básico: el nivel no puede ser negativo
            this.nivel = nivel;
        }
    }

    public int getAsistenciaEnsayos() {
        return asistenciaEnsayos;
    }

    public void setAsistenciaEnsayos(int asistenciaEnsayos) {
        if (asistenciaEnsayos >= 0) {
            this.asistenciaEnsayos = asistenciaEnsayos;
        }
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        if (valorBase >= 0) {
            this.valorBase = valorBase;
        }
    }

    // =====================
    // MÉTODOS OVERRIDE (OBLIGATORIOS)
    // =====================

    // Implementación de la fórmula de aportación para un músico genérico
    // Fórmula: valorBase + (nivel * 2) + (asistenciaEnsayos * 1.5)
    @Override
    public double calcularAportacion() {
        return valorBase + (nivel * 2) + (asistenciaEnsayos * 1.5);
    }

    // Regla de participación para músicos
    // El enunciado dice: true si asistenciaEnsayos >= 3
    @Override
    public boolean puedeParticipar() {
        return asistenciaEnsayos >= 3;
    }

    // =====================
    // MÉTODOS PROPIOS
    // =====================

    // Incrementa el contador de asistencia en 1
    public void registrarEnsayo() {
        this.asistenciaEnsayos++;
    }

    // Incrementa el nivel de habilidad en 1
    public void subirNivel() {
        this.nivel++;
    }
}