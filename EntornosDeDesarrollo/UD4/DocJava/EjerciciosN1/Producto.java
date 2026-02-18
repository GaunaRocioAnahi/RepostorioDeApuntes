package EjerciciosN1;
/**
 * <strong> representa un producto con su codigo y precio</strong>
 * 
 * @author Profesor Luis Miguel
 * @version 1.0
 */
public class Producto {
    /**
     * atributos de la clase Producto
     */
    private final String codigo;
    private final String nombre;
    private double precio;
    /**
     * 
     * Crea un objeto con los datos obligatorios del producto
     * 
     * @param codigo codigo del producto 
     * @param nombre nombre del producto
     * @param precio precio actual del producto
     * @throws IllegalArgumentException el codigo no puede estar vacio, el nombre no puede estar vacio y el precio negativo
     */

    public Producto(String codigo, String nombre, double precio) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    /**
     * Obtengo el codigo del producto
     * @return codigo del producto
     */

    public String getCodigo() {
        return codigo;
    }
/**
 * Obtengo el nombre del producto
 * @return nombre del producto
 */
    public String getNombre() {
        return nombre;
    }
    /**
     * Obtengo el precio del producto
     * @return precio del producto
     */

    public double getPrecio() {
        return precio;
    } 
    /**
     * cambia el precio del producto actual
     * 
     * @param nuevoPrecio cambia el precio del producto a uno nuevo
     * @throws IllegalArgumentException el precio no puede ser negativo.
     */

    public void cambiarPrecio(double nuevoPrecio) {
        if (nuevoPrecio < 0) {
            throw new IllegalArgumentException("El nuevo precio no puede ser negativo");
        }

        this.precio = nuevoPrecio;
    }
}
