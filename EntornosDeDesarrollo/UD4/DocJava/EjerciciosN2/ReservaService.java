package EjerciciosN2;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona el registro y almacenamiento de las reservas del sistema.
 * <p>
 * Esta clase actúa como un almacén en memoria para objetos de tipo {@link Reserva}.
 * </p>
 * * @see Reserva
 * @see Sala
 */

public class ReservaService {

    /**
     * Lista interna que almacena todas las reservas registradas.
     */

    private final List<Reserva> reservas = new ArrayList<>();

    /**
     * Registra una {@link Reserva} que ya ha sido creada previamente.
     * <p>
     * Este es el método recomendado para añadir reservas al sistema.
     * </p>
     * * @param reserva El objeto {@link Reserva} a guardar.
     * @see Reserva#Reserva(Sala, String)
     */

    public void registrarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    /**
     * Crea y registra una reserva en un solo paso (Método antiguo).
     * * @param sala    La {@link Sala} donde se realiza el evento.
     * @param cliente El nombre del cliente.
     * @return El objeto {@link Reserva} recién creado.
     * * @deprecated Este método mezcla la creación y el registro, lo cual no es flexible.
     * <br> Se recomienda crear la reserva manualmente y luego usar 
     * {@link #registrarReserva(Reserva)}.
     */

    /**
     * Método antiguo para crear reservas.
     */
    @Deprecated
    public Reserva crearReserva(Sala sala, String cliente) {
        Reserva reserva = new Reserva(sala, cliente);
        reservas.add(reserva);
        return reserva;
    }


    /**
     * Obtiene el listado completo de reservas.
     * * @return Una lista de objetos {@link Reserva}.
     */

    public List<Reserva> getReservas() {
        return reservas;
    }
}
