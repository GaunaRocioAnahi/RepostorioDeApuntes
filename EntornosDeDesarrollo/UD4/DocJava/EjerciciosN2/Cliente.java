package EjerciciosN2;
/**
 * Representa un cliente registrado en el sistema.
 * <p>
 * Los clientes son necesarios para crear un {@link Pedido}.
 * </p>
 *
 * @author Profesor Luis Miguel
 * @see Pedido
 */

public class Cliente {
    
    private final String id;
    private final String nombre;
    /**
     * Crea un nuevo cliente.
     *
     * @param id     Identificador único.
     * @param nombre Nombre real del cliente.
     * @throws  Si los datos están vacíos.
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
}
