package EjerciciosN3;

/**
 * Representa un pedido en curso que contiene una lista de productos.
 * <p>
 * Gestiona la adición de productos respetando los límites definidos en la configuración.
 * </p>
 *
 * @author Profesor Luis Miguel
 * @version 1.2
 */

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final List<String> productos = new ArrayList<>();

    /**
     * Añade un producto a la lista si no se ha superado el límite.
     * <p>
     * El número máximo de productos permitidos es <strong>{@value ConstantesPedido#MAX_PRODUCTOS}</strong>.
     * Si intentas añadir más, se lanzará un error.
     * </p>
     *
     * @param nombreProducto El nombre del producto a añadir (ej: {@code "Zapatos"}).
     * @throws IllegalStateException Si la lista ya contiene {@value ConstantesPedido#MAX_PRODUCTOS} elementos.
     */


    public void agregarProducto(String nombreProducto) {
        if (productos.size() >= ConstantesPedido.MAX_PRODUCTOS) {
            throw new IllegalStateException("No se pueden añadir más productos");
        }

        productos.add(nombreProducto);
    }

    /**
     * Obtiene la lista actual de productos.
     *
     * @return Una {@code List<String>} con los nombres de los productos.
     */

    public List<String> getProductos() {
        return productos;
    }

    /**
     * Calcula el precio total del pedido aplicando impuestos.
     * <p>
     * La fórmula utilizada es:
     * {@code (cantidad * precioUnitario) * (1 + IVA)}.
     * <br>
     * Actualmente el IVA aplicado es de <strong>{@value ConstantesPedido#IVA}</strong>.
     * </p>
     *
     * @param precioUnitario El precio individual de cada producto.
     * @return El total calculado como un número decimal ({@code double}).
     */

    public double calcularTotal(double precioUnitario) {
        return productos.size() * precioUnitario * (1 + ConstantesPedido.IVA);
    }
}
