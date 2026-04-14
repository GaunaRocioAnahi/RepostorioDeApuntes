package UD6.Repaso1;

import java.util.ArrayList;

public class Director extends PersonaAgrupacion implements GestionHumana {
    private String especialidad;
    private int maximoMusicos;
    private ArrayList<PersonaAgrupacion> musicosAsignados;
    private double plusDireccion;

    public Director(String nombre, int edad, int antiguedad, String especialidad, int maximoMusicos,
            ArrayList<PersonaAgrupacion> musicosAsignados, double plusDireccion) {
        super(nombre, edad, antiguedad);
        setEspecialidad(especialidad);
        setMaximoMusicos(maximoMusicos);
        setMusicosAsignados(musicosAsignados);
        setPlusDireccion(plusDireccion);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isEmpty() || !especialidad.matches(".*[0-9].*")) {
            this.especialidad = especialidad;
        } else {
            this.especialidad = "[Especialidad inválida]";
        }
    }

    public int getMaximoMusicos() {
        return maximoMusicos;
    }

    public void setMaximoMusicos(int maximoMusicos) {
        if (maximoMusicos > 0) {
            this.maximoMusicos = maximoMusicos;
        } else {
            this.maximoMusicos = -1;
        }
    }

    public ArrayList<PersonaAgrupacion> getMusicosAsignados() {
        return musicosAsignados;
    }

    public void setMusicosAsignados(ArrayList<PersonaAgrupacion> musicosAsignados) {
        if (musicosAsignados != null && !musicosAsignados.isEmpty()) {
            this.musicosAsignados = musicosAsignados;
        } else {
            this.musicosAsignados = new ArrayList<>();
        }
    }

    public double getPlusDireccion() {
        return plusDireccion;
    }

    public void setPlusDireccion(double plusDireccion) {
        if (plusDireccion > 0.0) {
            this.plusDireccion = plusDireccion;
        } else {
            this.plusDireccion = -1;
        }
    }

    @Override
    public double calcularAportacion() {
        return super.getAntiguedad() * 10 + plusDireccion + (musicosAsignados.size() * 5);
    }

    @Override
    public boolean puedeParticipar() {
        boolean puedeParticipar;

        if (super.getEdad() >= 18) {
            puedeParticipar = true;
        } else {
            puedeParticipar = false;
        }

        return puedeParticipar;
    }

    @Override
    public boolean asignarMusico(PersonaAgrupacion persona) {
        boolean seHaAsignado;

        if (persona == null || musicosAsignados.contains(persona) || musicosAsignados.size() >= maximoMusicos) {
            seHaAsignado = false;
        } else {
            musicosAsignados.add(persona);
            seHaAsignado = true;
        }

        return seHaAsignado;
    }

    @Override
    public boolean expulsarMusico(String nombre) {
        boolean seHaExpulsado = false;

        for (int i = 0; i < musicosAsignados.size(); i++) {
            if (musicosAsignados.get(i).getNombre().equals(nombre)) {
                musicosAsignados.remove(i);
                seHaExpulsado = true;
            }
        }

        return seHaExpulsado;
    }

    public int contarMusicosAsignados() {
        return musicosAsignados.size();
    }

    public double calcularValorTotalAportacionMusicos() {
        double valorTotal = 0;

        for (PersonaAgrupacion musico : musicosAsignados) {
            valorTotal += musico.calcularAportacion();
        }

        return valorTotal;
    }
}