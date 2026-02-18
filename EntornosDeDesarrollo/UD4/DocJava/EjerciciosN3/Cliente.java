package EjerciciosN3;
/**
 * Representa al comprador o usuario del sistema.
 *
 * @author Profesor Luis Miguel
 * @version 1.0
 */

public class Cliente {
    private final String id;
    private final String nombre;
    /**
     * Crea un nuevo cliente validando los datos.
     *
     * @param id     Identificador único (no puede ser {@code null}).
     * @param nombre Nombre real (no puede ser {@code null} ni estar vacío).
     * @throws IllegalArgumentException Si el {@code id} o {@code nombre} son inválidos.
     */

    public Cliente(String id, String nombre) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id no puede estar vacío");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
        
    }
    /**
     * {@inheritDoc}
     * <p>
     * Devuelve una representación en texto del cliente (su nombre).
     * </p>
     */
    @Override
    public String toString() {
        return nombre;
    }
}
