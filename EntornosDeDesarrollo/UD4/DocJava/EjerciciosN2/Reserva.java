package EjerciciosN2;
/**
 * Representa la reserva confirmada de una {@link Sala}.
 * <p>
 * Este objeto vincula una sala específica con el nombre del cliente que la ocupará.
 * Para gestionar estas reservas, se recomienda usar {@link ReservaService}.
 * </p>
 *
 * @see Sala
 * @see ReservaService
 * */
public class Reserva {

    /**
     * La {@link Sala} asociada a esta reserva.
     */


    private final Sala sala;
    private final String nombreCliente;

    /**
     * Crea una nueva reserva asociando una sala y un cliente.
     *
     * @param sala          La {@link Sala} que se desea reservar (no puede ser null).
     * @param nombreCliente El nombre del cliente titular.
     * @throws IllegalArgumentException Si la sala es nula o el nombre del cliente está vacío.
     */

    public Reserva(Sala sala, String nombreCliente) {
        if (sala == null) {
            throw new IllegalArgumentException("La sala no puede ser null");
        }

        if (nombreCliente == null || nombreCliente.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }

        this.sala = sala;
        this.nombreCliente = nombreCliente;
    }

    /**
     * Obtiene la sala reservada.
     *
     * @return El objeto {@link Sala} correspondiente.
     */

    public Sala getSala() {
        return sala;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente como texto.
     */

    public String getNombreCliente() {
        return nombreCliente;
    }
}
