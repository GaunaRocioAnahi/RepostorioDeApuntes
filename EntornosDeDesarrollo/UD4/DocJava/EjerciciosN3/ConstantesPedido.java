package EjerciciosN3;
/**
 * Clase de utilidad que contiene las constantes de configuración para los pedidos.
 * <p>
 * Aquí se definen los límites y tasas que se aplicarán en todo el sistema.
 * </p>
 *
 * @author Profesor Luis Miguel
 * @version 1.0
 */

public class ConstantesPedido {
    
    /**
     * El número máximo de productos permitidos en un solo pedido.
     * <p>
     * El valor actual configurado es: <strong>{@value}</strong>.
     * </p>
     */

    public static final int MAX_PRODUCTOS = 10;

    /**
     * El porcentaje de Impuesto sobre el Valor Añadido (IVA) a aplicar.
     * <p>
     * Se representa como un decimal. Valor actual: {@code {@value}}.
     * (Es decir, un 21%).
     * </p>
     */

    public static final double IVA = 0.21;
}
