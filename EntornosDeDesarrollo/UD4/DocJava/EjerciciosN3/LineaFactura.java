package EjerciciosN3;

/**
 * Representa una línea de detalle dentro de una factura.
 *
 * @author Tu Nombre
 * @version 1.1
 */

public class LineaFactura {
    private final String concepto;
    private final double precioUnitario;
    private final int cantidad;
    
    /**
     * Constructor para una línea de producto.
     *
     * @param concepto       Descripción del producto (no puede ser {@code null}).
     * @param precioUnitario Coste por unidad (debe ser {@code >= 0}).
     * @param cantidad       Número de unidades (debe ser {@code > 0}).
     */

    public LineaFactura(String concepto, double precioUnitario, int cantidad) {
        if (concepto == null || concepto.isBlank()) {
            throw new IllegalArgumentException("El concepto no puede estar vacío");
        }

        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio unitario no puede ser negativo");
        }

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }

        this.concepto = concepto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    /**
     * Calcula el precio total de la línea.
     * <p>
     * Fórmula: {@code precioUnitario * cantidad}.
     * </p>
     *
     * @return El subtotal como {@code double}.
     */

    public double calcularSubtotal() {
        return precioUnitario * cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
