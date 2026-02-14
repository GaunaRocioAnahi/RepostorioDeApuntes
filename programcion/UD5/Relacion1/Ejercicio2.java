package programcion.UD5.Relacion1;

public class Ejercicio2 {

    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria(120, "Miguel");
        // tengo el mismo println para ver como cambia el saldo en cada paso. 
        System.out.println(cuenta1.saldo);
        cuenta1.depositar(200);
        System.out.println(cuenta1.saldo);
        cuenta1.retirar(400);
        System.out.println(cuenta1.saldo); // muestra el mismo saldo de 320, asegura que no sea negativo.

    }

}

class CuentaBancaria {
    String titular;
    Double saldo;

    CuentaBancaria(double saldo, String titular) {
        this.titular = titular;
        this.saldo = saldo;
    }

    // usamos un acumulador += para acumular la cantidad al saldo
    void depositar(double cantidad) { // es void por que no devuelve nada como el return si devolcia lo declaramos
                                      // con double
        saldo += cantidad;
    }

    void retirar(double cantidad) {
        if (cantidad < saldo) {
            saldo -= cantidad;
        }
    }
}
