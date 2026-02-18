package EjerciciosN3;
/**
 * Servicio encargado de la lógica de negocio relacionada con los pedidos.
 * <p>
 * Actúa como intermediario para crear instancias y realizar cálculos financieros.
 * </p>
 *
 * @author Profesor Luis Miguel
 * @version 2.0
 */

public class PedidoService {
    /*
     * Crea un pedido vacío listo para agregar productos.
     *
     * @return Una nueva instancia de la clase {@code Pedido}.
     */
    public Pedido crearPedido() {
        return new Pedido();
    }

    /**
     * Devuelve el importe total del pedido aplicando los impuestos vigentes.
     * <p>
     * Este cálculo delega en el objeto pedido, aplicando el IVA actual del
     * <strong>{@value ConstantesPedido#IVA}</strong> (definido en la configuración global).
     * </p>
     *
     * @param pedido         El objeto {@code Pedido} sobre el que calcular.
     * @param precioUnitario El coste unitario (tipo {@code double}) de los productos.
     * @return El precio final calculado.
     */
    public double obtenerTotal(Pedido pedido, double precioUnitario) {
        return pedido.calcularTotal(precioUnitario);
    }
}
