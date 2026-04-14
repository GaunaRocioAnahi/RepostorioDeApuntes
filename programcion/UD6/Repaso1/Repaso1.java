package UD6.Repaso1;

import java.util.ArrayList;
import java.util.Arrays;

public class Repaso1 {

    public static String cuantosPuedenParticipar(ArrayList<PersonaAgrupacion> musicosAsignados) {
        int numeroPersonasPuedenParticipar = 0;

        for (PersonaAgrupacion musico : musicosAsignados) {
            if (musico.puedeParticipar()) {
                numeroPersonasPuedenParticipar++;
            }
        }

        return "El número de músicos que pueden participar es de: " + numeroPersonasPuedenParticipar;
    }

    public static void mostrarAportacionCadaMusico(ArrayList<PersonaAgrupacion> musicosAsignados) {
        for (PersonaAgrupacion musico : musicosAsignados) {
            System.out.println(
                    "La aportación del músico/a " + musico.getNombre() + " es : "
                            + String.format("%.2f", musico.calcularAportacion()));
        }
    }

    public static String calcularValorTotalColeccion(ArrayList<PersonaAgrupacion> todos) {
        double valorTotal = 0;

        for (PersonaAgrupacion persona : todos) {
            valorTotal += persona.calcularAportacion();
        }

        return "El valor total de la colección es : " + String.format("%.2f", valorTotal);
    }

    public static void main(String[] args) {
        Trompetista trompetista1 = new Trompetista("Clara", 25, 2, "Saxo", 1, 2, 1, 1, 90, 5, 1);
        Trompetista trompetista2 = new Trompetista("Raúl", 30, 4, "Tuba", 6, 3, 5, 2, 200, 8, 2);
        Percusionista percusionista1 = new Percusionista("Esteban", 35, 7, "Tambor", 7, 8, 9, 3, 271.90, 9, 10);
        Percusionista percusionista2 = new Percusionista("Josefina", 40, 10, "Timbal", 10, 13, 10, 4, 150.85, 10, 11);
        Percusionista percusionista3 = new Percusionista("Marta", 55, 16, "Bombo", 10, 23, 14, 5, 500, 11, 21);
        ArrayList<PersonaAgrupacion> musicosAsignados = new ArrayList<>(
                Arrays.asList(trompetista1, trompetista2, percusionista1, percusionista2));
        Director director = new Director("Samuel", 45, 19, "Saxofón", 5, musicosAsignados, 1.5);
        ArrayList<PersonaAgrupacion> todos = new ArrayList<>(
                Arrays.asList(trompetista1, trompetista2, percusionista1, percusionista2, percusionista3, director));

        trompetista1.registrarEnsayo();
        trompetista2.registrarEnsayo();
        trompetista2.registrarEnsayo();
        percusionista1.registrarEnsayo();
        percusionista1.registrarEnsayo();
        percusionista2.registrarEnsayo();

        percusionista2.subirNivel();
        percusionista2.subirNivel();
        trompetista1.subirNivel();

        percusionista1.asignarInstrumento("Pandereta", 15.5);
        trompetista1.asignarInstrumento("Saxofón", 99.99);
        trompetista2.asignarInstrumento("Trombón", 101.25);
        trompetista2.asignarInstrumento("Tromba", 100);

        trompetista2.quitarInstrumento("Trombón", 101.25);

        trompetista1.registrarSolo();
        trompetista2.registrarSolo();

        percusionista1.registrarCambioRitmoCorrecto();
        percusionista1.registrarCambioRitmoCorrecto();
        percusionista2.registrarCambioRitmoCorrecto();

        trompetista1.aumentarResistencia(3);
        trompetista2.aumentarResistencia(5);

        percusionista1.aumentarPotencia(1);
        percusionista2.aumentarPotencia(3);

        director.asignarMusico(percusionista3);
        director.expulsarMusico("Josefina");

        System.out.println(
                "La aportación del director " + director.getNombre() + " es: "
                        + String.format("%.2f", director.calcularAportacion()));
        mostrarAportacionCadaMusico(musicosAsignados);
        System.out.println(
                "Músicos asignados al director " + director.getNombre() + " : " + director.contarMusicosAsignados());
        System.out.println("El valor aportado total de todos los músicos es de: "
                + String.format("%.2f", director.calcularValorTotalAportacionMusicos()));
        System.out.println(calcularValorTotalColeccion(todos));
        System.out.println(cuantosPuedenParticipar(musicosAsignados));
    }
}