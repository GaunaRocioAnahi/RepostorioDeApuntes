package UD6.Repaso1;

public class Musico extends PersonaAgrupacion {
    private String instrumentoPrincipal;
    private int nivel;
    private int asistenciaEnsayos;
    private double valorBase;

    public Musico(String nombre, int edad, int antiguedad, String instrumentoPrincipal, int nivel,
            int asistenciaEnsayos, double valorBase) {
        super(nombre, edad, antiguedad);
        setInstrumentoPrincipal(instrumentoPrincipal);
        setNivel(nivel);
        setAsistenciaEnsayos(asistenciaEnsayos);
        setValorBase(valorBase);
    }

    public String getInstrumentoPrincipal() {
        return instrumentoPrincipal;
    }

    public void setInstrumentoPrincipal(String instrumentoPrincipal) {
        if (instrumentoPrincipal == null || instrumentoPrincipal.isEmpty()
                || !instrumentoPrincipal.matches(".*[0-9].*")) {
            this.instrumentoPrincipal = "[Instrumento inválido]";
        } else {
            this.instrumentoPrincipal = instrumentoPrincipal;
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel > 0) {
            this.nivel = nivel;
        } else {
            this.nivel = -1;
        }
    }

    public int getAsistenciaEnsayos() {
        return asistenciaEnsayos;
    }

    public void setAsistenciaEnsayos(int asistenciaEnsayos) {
        if (asistenciaEnsayos >= 0) {
            this.asistenciaEnsayos = asistenciaEnsayos;
        } else {
            this.asistenciaEnsayos = -1;
        }
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        if (valorBase >= 0) {
            this.valorBase = valorBase;
        } else {
            this.valorBase = -1;
        }
    }

    @Override
    public double calcularAportacion() {
        return valorBase + (nivel * 2) + (asistenciaEnsayos * 1.5);
    }

    @Override
    public boolean puedeParticipar() {
        boolean puedeParticipar;

        if (asistenciaEnsayos >= 3) {
            puedeParticipar = true;
        } else {
            puedeParticipar = false;
        }

        return puedeParticipar;
    }

    public void registrarEnsayo() {
        asistenciaEnsayos++;
    }

    public void subirNivel() {
        nivel++;
    }
}