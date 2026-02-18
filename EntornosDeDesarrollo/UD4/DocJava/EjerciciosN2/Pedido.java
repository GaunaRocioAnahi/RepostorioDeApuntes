package EjerciciosN2;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa una orden de compra realizada por un {@link Cliente}.
 * <p>
 * Puedes agregar productos usando {@link #agregarProducto(String)}.
 * </p>
 *
 * @see Cliente
 * @see PedidoService
 */

public class Pedido {
    /** el cleinte realiza la compra */
    private final Cliente cliente;
    private final List<String> productos = new ArrayList<>();
    /**
     * Crea un pedido asociado a un cliente específico.
     *
     * @param cliente El {@link Cliente} dueño del pedido (no puede ser null).
     * @throws IllegalArgumentException Si el cliente es nulo.
     */
    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser null");
        }

        this.cliente = cliente;
    }
    /**
     * Obtiene el cliente asociado.
     *
     * @return El objeto {@link Cliente}.
     */

    public Cliente getCliente() {
        return cliente;
    }
    /**
     * Añade un producto a la lista.
     *
     * @param nombreProducto El nombre del artículo.
     */

    public void agregarProducto(String nombreProducto) {
        productos.add(nombreProducto);
    }

    public List<String> getProductos() {
        return productos;
    }
}
