package UD6.Repaso1;

public class Percusionista extends Musico implements Asignable {
    private int numeroInstrumentos;
    private double valorInstrumentos;
    private int potenciaGolpe;
    private int cambiosRitmoCorrectos;

    public Percusionista(String nombre, int edad, int antiguedad, String instrumentoPrincipal, int nivel,
            int asistenciaEnsayos, double valorBase, int numeroInstrumentos, double valorInstrumentos,
            int potenciaGolpe, int cambiosRitmoCorrectos) {
        super(nombre, edad, antiguedad, instrumentoPrincipal, nivel, asistenciaEnsayos, valorBase);
        setNumeroInstrumentos(numeroInstrumentos);
        setValorInstrumentos(valorInstrumentos);
        setPotenciaGolpe(potenciaGolpe);
        setCambiosRitmoCorrectos(cambiosRitmoCorrectos);
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

    public int getPotenciaGolpe() {
        return potenciaGolpe;
    }

    public void setPotenciaGolpe(int potenciaGolpe) {
        if (potenciaGolpe > 0) {
            this.potenciaGolpe = potenciaGolpe;
        } else {
            this.potenciaGolpe = -1;
        }
    }

    public int getCambiosRitmoCorrectos() {
        return cambiosRitmoCorrectos;
    }

    public void setCambiosRitmoCorrectos(int cambiosRitmoCorrectos) {
        if (cambiosRitmoCorrectos >= 0) {
            this.cambiosRitmoCorrectos = cambiosRitmoCorrectos;
        } else {
            this.cambiosRitmoCorrectos = -1;
        }
    }

    @Override
    public double calcularAportacion() {
        return super.calcularAportacion() + (potenciaGolpe * 2) + (cambiosRitmoCorrectos * 4)
                + (valorInstrumentos * 0.03);
    }

    @Override
    public boolean puedeParticipar() {
        boolean puedeParticipar;

        if (super.puedeParticipar() && potenciaGolpe >= 4) {
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

    public void registrarCambioRitmoCorrecto() {
        cambiosRitmoCorrectos++;
    }

    public void aumentarPotencia(int cantidad) {
        if (cantidad > 0) {
            potenciaGolpe += cantidad;
        }
    }
}