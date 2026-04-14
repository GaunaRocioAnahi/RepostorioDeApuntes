package UD6.Repaso1;

public class Trompetista extends Musico implements Asignable {
    private int numeroInstrumentos;
    private double valorInstrumentos;
    private int resistencia;
    private int numeroSolos;

    public Trompetista(String nombre, int edad, int antiguedad, String instrumentoPrincipal, int nivel,
            int asistenciaEnsayos, double valorBase, int numeroInstrumentos, double valorInstrumentos, int resistencia,
            int numeroSolos) {
        super(nombre, edad, antiguedad, instrumentoPrincipal, nivel, asistenciaEnsayos, valorBase);
        setNumeroInstrumentos(numeroInstrumentos);
        setValorInstrumentos(valorInstrumentos);
        setResistencia(resistencia);
        setNumeroSolos(numeroSolos);
    }

    public int getNumeroInstrumentos() {
        return numeroInstrumentos;
    }

    public void setNumeroInstrumentos(int numeroInstrumentos) {
        if (numeroInstrumentos > 0) {
            this.numeroInstrumentos = numeroInstrumentos;
        } else {
            this.numeroInstrumentos = -1;
        }
    }

    public double getValorInstrumentos() {
        return valorInstrumentos;
    }

    public void setValorInstrumentos(double valorInstrumentos) {
        if (valorInstrumentos > 0.0) {
            this.valorInstrumentos = valorInstrumentos;
        } else {
            this.valorInstrumentos = -1;
        }
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        if (resistencia > 0) {
            this.resistencia = resistencia;
        } else {
            this.resistencia = -1;
        }
    }

    public int getNumeroSolos() {
        return numeroSolos;
    }

    public void setNumeroSolos(int numeroSolos) {
        if (numeroSolos >= 0) {
            this.numeroSolos = numeroSolos;
        } else {
            this.numeroSolos = -1;
        }
    }

    @Override
    public double calcularAportacion() {
        return super.calcularAportacion() + resistencia + (numeroSolos * 3) + (valorInstrumentos * 0.05);
    }

    @Override
    public boolean puedeParticipar() {
        boolean puedeParticipar;

        if (super.puedeParticipar() && resistencia >= 5) {
            puedeParticipar = true;
        } else {
            puedeParticipar = false;
        }

        return puedeParticipar;
    }

    @Override
    public boolean asignarInstrumento(String nombreInstrumento, double valorInstrumento) {
        boolean seHaAsignado;

        if (nombreInstrumento == null || nombreInstrumento.isEmpty() || valorInstrumento <= 0) {
            seHaAsignado = false;
        } else {
            numeroInstrumentos++;
            valorInstrumentos += valorInstrumento;
            seHaAsignado = true;
        }

        return seHaAsignado;
    }

    @Override
    public boolean quitarInstrumento(String nombreInstrumento, double valorInstrumento) {
        boolean seHaQuitado;

        if (numeroInstrumentos == 0 || valorInstrumento <= 0) {
            seHaQuitado = false;
        } else {
            numeroInstrumentos--;
            valorInstrumentos -= valorInstrumento;

            if (valorInstrumentos < 0) {
                valorInstrumentos = 0;
            }

            seHaQuitado = true;
        }

        return seHaQuitado;
    }

    public void registrarSolo() {
        numeroSolos++;
    }

    public void aumentarResistencia(int cantidad) {
        if (cantidad > 0) {
            resistencia += cantidad;
        }
    }
}