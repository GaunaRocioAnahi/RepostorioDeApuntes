package EjerciciosN2;

/**
 * Representa una sala física disponible para eventos.
 * <p>
 * Este es el recurso principal que se necesita para crear una {@link Reserva}.
 * Sin una sala válida, no se pueden registrar eventos en el {@linkplain ReservaService sistema}.
 * </p>
 *
 * @see Reserva
 * @see ReservaService
 */

public class Sala {
    
    private final String codigo;
    private final int capacidad;
    /**
     * Crea una nueva sala con un identificador y un aforo máximo.
     *
     * @param codigo    El identificador único de la sala (no puede estar vacío).
     * @param capacidad El número máximo de personas permitidas.
     * @throws IllegalArgumentException Si el código es nulo o la capacidad no es positiva.
     */

    public Sala(String codigo, int capacidad) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero");
        }

        this.codigo = codigo;
        this.capacidad = capacidad;
    }
    /**
     * Obtiene el código de identificación.
     *
     * @return El código (ej: "A1", "Sala-Magna").
     */

    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene la capacidad máxima.
     * <p>
     * Este valor limita cuántas personas pueden asistir, dato importante para la {@link Reserva}.
     * </p>
     *
     * @return Un número entero con la capacidad.
     */

    public int getCapacidad() {
        return capacidad;
    }
}
