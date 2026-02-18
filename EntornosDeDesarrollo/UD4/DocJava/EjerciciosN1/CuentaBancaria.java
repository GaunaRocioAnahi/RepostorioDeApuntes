package EjerciciosN1;
    /**
     * <strong> class de cuenta bancaria  </strong>
     * almacena la cuenta bancaria del usuario. 
     * @author profesor Luis Miguel
     * @version 1.0
     */
public class CuentaBancaria {
    /** Atributo de las clases Cuenta bancaria */
    private final Usuario titular;
    private double saldo;
    /**
     *  Crea un objeto de la clase Cuenta bancaria
     * 
     * 
     * @param titular nombre del usuario titular
     * @param saldoInicial saldo inicial de la cuenta
     * @throws IllegalArgumenteException el saldo no puede ser negativo y el campo nombre no puede estar vacio. 
     */

    public CuentaBancaria(Usuario titular, double saldoInicial) {
        if (titular == null) {
            throw new IllegalArgumentException("El titular no puede ser null");
        }

        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }

        this.titular = titular;
        this.saldo = saldoInicial;

    }
    /**
     * Obtiene el titular de la cuenta.
     * @return nombre del titular.
     */

    public Usuario getTitular() {
        return titular;
    }
    /**
     * Obtiene el saldo disponible
     * @return saldo actual de la cuenta
     */

    public double getSaldo() {
        return saldo;
    }
    /**
     * saldo de la cuenta ingresada
     * 
     * @param cantidad cantidad de dinero a ingresar
     * @throws IllegalArgumentException la cantidad es 0 o negativa
     */

    public void ingresar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
// esto indica el acumulador de ingreso
        saldo += cantidad;
    }
    /**
     * retiro de dinero de la cuenta 
     * @param cantidad cantidad de dinero al retirar
     * @throws IllegalArgumentException si la cantidad es negativa y si no hay suficiente saldo
     */

    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }

        if (cantidad > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        saldo -= cantidad;
    }
}
