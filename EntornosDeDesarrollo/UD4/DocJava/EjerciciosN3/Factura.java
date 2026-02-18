package EjerciciosN3;

import java.util.ArrayList;
import java.util.List;
/**
 * Documento final que agrupa al cliente y sus compras.
 *
 * @author Profesor Luis Miguel
 * @version 2.0
 */

public class Factura {
    private final Cliente cliente;
    private final List<LineaFactura> lineas = new ArrayList<>();

    /**
     * Inicia una factura para un cliente.
     *
     * @param cliente El usuario a facturar (no puede ser {@code null}).
     * @throws IllegalArgumentException Si el cliente es nulo.
     */

    public Factura(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser null");
        }

        this.cliente = cliente;
    }

    /**
     * Añade una línea a la factura respetando los límites.
     * <p>
     * El máximo de líneas permitidas es <strong>{@value ConstantesFactura#MAX_LINEAS_FACTURA}</strong>.
     * </p>
     *
     * @param linea La línea a agregar.
     * @throws IllegalStateException Si se supera el límite de {@value ConstantesFactura#MAX_LINEAS_FACTURA} líneas.
     */


    public void agregarLinea(LineaFactura linea) {
        if (lineas.size() >= ConstantesFactura.MAX_LINEAS_FACTURA) {
            throw new IllegalStateException("No se pueden añadir más líneas a la factura");
        }

        lineas.add(linea);
    }
    /**
     * Calcula el total con impuestos.
     * <p>
     * Aplica un IVA del <strong>{@value ConstantesFactura#IVA_GENERAL}</strong> al subtotal.
     * </p>
     *
     * @return El total final a pagar.
     */
    public double calcularTotal() {
        double totalSinIva = 0;

        for (LineaFactura linea : lineas) {
            totalSinIva += linea.calcularSubtotal();
        }

        return totalSinIva * (1 + ConstantesFactura.IVA_GENERAL);
    }

    public Cliente getCliente() {
        return cliente;
    }
}
