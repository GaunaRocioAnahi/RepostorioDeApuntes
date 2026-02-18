package EjerciciosN1;
/**
 * 
 * Representa el <strong>Inventario</strong> de un almacén o tienda.
 * <p>
 * Esta clase se encarga de gestionar una lista de productos, permitiendo
 * agregarlos, buscarlos por su código y contar cuántos hay en total.
 * </p>
 * @author Profesor Luis Miguel 
 * @version 1.0
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    /**
     * La lista interna que almacena todos los objetos de tipo Producto.
     * Se usa una ArrayList para poder guardar una cantidad indefinida de productos.
     */
    private final List<Producto> productos = new ArrayList<>();
    /**
     * Constructor por defecto del Inventario.
     * Inicializa la lista vacía.
     */

    /** 
     * Agrega un nuevo producto a la lista del inventario.
     *
     * @param producto El objeto producto que queremos guardar (no debe ser nulo).
     * @throws IllegalArgumentException Si intentas guardar un producto que es null (vacío).
     */

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null");
        }

        productos.add(producto);

    }

    /**
     * Busca un producto dentro de la lista comparando su código.
     * @param codigoidentificador único (String) del producto que buscamos.
     * @return El objeto <code>Producto</code> si se encuentra; de lo contrario, devuelve <code>null</code>.
     */

    public Producto buscarPorCodigo(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }

        return null;
    }
    /**
     * Cuenta la cantidad total de productos almacenados actualmente.
     *
     * @return El número entero (int) que indica cuántos productos hay en la lista.
     */

    public int totalProductos() {
        return productos.size();
    }
}
