package EjerciciosN3;
/**
 * Define las constantes globales para el sistema de facturación.
 * <p>
 * Aquí se centralizan valores como impuestos y límites de líneas para
 * facilitar el mantenimiento del código.
 * </p>
 *
 * @author Profesor Luis Miguel
 * @version 1.0
 */
public class ConstantesFactura {
    /**
     * El Impuesto sobre el Valor Añadido (IVA) general.
     * <p>
     * Actualmente configurado en: <strong>{@value}</strong>.
     * </p>
     */
    
    public static final double IVA_GENERAL = 0.21;
    /**
     * El número máximo de líneas de detalle que caben en una factura.
     * <p>
     * Límite actual: <strong>{@value}</strong> líneas.
     * </p>
     */
    public static final int MAX_LINEAS_FACTURA = 20;
}
