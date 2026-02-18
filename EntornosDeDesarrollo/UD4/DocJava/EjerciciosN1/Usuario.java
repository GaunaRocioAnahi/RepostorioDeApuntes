package EjerciciosN1;

/**
 * <strong> class para Usuario de cuenta bancaria </strong>
 * <p>
 * Esta clase almacenan la informacion personal basica del cliente.
 * </p>
 * 
 * @author profesor Luis Miguel
 * @version 1.0
 */
public class Usuario {
    /**
     * atributo de las clases de Usuarios
     */
    private final String nombre;
    private final String dni;

    /**
     * Crea un obejeto Usuario con los datos obligatorios
     * 
     * @param nombre nombre de usuario
     * @param dni    dni del usuario
     * @throws IllegalArgumentException control de error para que el nombre y DNI no
     *                                  sea un campo vacio.
     * 
     */

    public Usuario(String nombre, String dni) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (dni == null || dni.isBlank()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }

        this.nombre = nombre;
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del usuario
     * 
     * @return  el nombre actual
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Obtine el Dni del usuario
     * 
     * @return el DNI actual 
     */
    public String getDni() {
        return dni;
    }
}
