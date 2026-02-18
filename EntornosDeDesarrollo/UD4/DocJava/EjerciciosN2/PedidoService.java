package EjerciciosN2;
/**
 * Servicio encargado de la gestión y creación de pedidos.
 *
 * @see Pedido
 */
public class PedidoService {
    /**
     * Crea un pedido nuevo para un cliente de forma segura.
     *
     * @param cliente El {@link Cliente} que hace el pedido.
     * @return Un nuevo objeto {@link Pedido}.
     */
    public Pedido crearPedidoParaCliente(Cliente cliente) {
        return new Pedido(cliente);
    }

    /**
     * Este método queda obsoleto y se mantiene solo por compatibilidad.
     */
    @Deprecated
    public Pedido crearPedido(Cliente cliente) {
        return new Pedido(cliente);
    }
}
