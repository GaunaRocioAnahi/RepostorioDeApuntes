package UD6.EjerciciosREPASO;

// contrato para quien pueda gestionar musicos
// en tu ejercicio solo Director la implementa

public interface GestionHumana {
    // recibe una PersonaAgrupacion y la añade
    // devuelve true si se añadio correctamente
    // devuelve false si algo salio mal
    boolean asignarMusico(PersonaAgrupacion persona);

    // recibe el nombre de la persona a expulsar
    // devuelve true si la encontro y la elimino
    // devuelve false si no la encontro
    boolean expulsarMusico(String nombre);
}
