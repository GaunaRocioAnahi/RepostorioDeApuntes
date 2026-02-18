package EjerciciosN1;
/**
 * Representa una <strong> Una calculadora Financiera </strong> basica.
 * <p>
 * Esta clase contiene metodos utilitarios para realizar caluculos comunes, relacionados con finanzas.  
 * </p>
 * @author Profesor Luis Miguel 
 * @since 1.0
 */
public class Calculadora {
    /**
     * Calcula el interes simple
     * 
     * @param capital Dinero inicial invertido.
     * @param tasa El interes
     * @param anios El tiempo en años
     * @return la ganancia total 
     * @throws IllegalArgumentEXception los numeros no pueden ser negativos.
     */
    public double calcularInteresSimple(double capital, double tasa, int anios) {
        if (capital < 0 || tasa < 0 || anios < 0) {
            throw new IllegalArgumentException("Los valores no pueden ser negativos");
        }

        return capital * tasa * anios;
    }
    /**
     * Calcula cuanto cuesta algo despues un descuento. 
     * 
     * @param precio el precio actual
     * @param porcentaje el descuento a aplicar.
     * @return el precio rebajado 
     * @throws IllegalArgumentException si el precio es negativo o el porcentaje es invalido
     */

    public double calcularDescuento(double precio, double porcentaje) {
        if (precio < 0 || porcentaje < 0 || porcentaje > 100) {
            throw new IllegalArgumentException("Valores no válidos");
        }

        return precio - (precio * porcentaje / 100);
    }

    /**
     *  Convierte los euros a dolares
     * 
     * @param euros Cantidad de euros
     * @param cambio Cambio de valor de euro a dolares
     * @return total en dolares
     * @throws IllegalArgumentException Si los valores son negativos o ceros
     */
    public double convertirEurosADolares(double euros, double cambio) {
        if (euros < 0 || cambio <= 0) {
            throw new IllegalArgumentException("Valores no válidos");
        }

        return euros * cambio;
    }
}
