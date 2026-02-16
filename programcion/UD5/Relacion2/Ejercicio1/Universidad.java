package programcion.UD5.Relacion2.Ejercicio1;

import java.util.ArrayList;

public class Universidad {

    ArrayList<Estudiante> alumnado;

    // constructor para que sea un array

    Universidad() {
        this.alumnado = new ArrayList<>();
    }

    // cabecera de la function para agregar un estudiantes en Universidad.
    // como parametros usamos la class estudiante

    public void agregarEstudiante(Estudiante estudiante) {
        // llega un estudiante y agrega un estudiante
        this.alumnado.add(estudiante);

    }
    // mostramos todos los alumnos

    public String mostrarEstudiantes() {

        String lista = "";
        for (Estudiante estudiante : alumnado) {
            lista += estudiante.getNombre();
            // getnombre solo accedo al nombre.
        }
        return lista;
    }

    public String mostrarEstudianteCompleto(){
        String lista="";

        for (Estudiante estudiante : alumnado) {
            lista += estudiante +"||\n";
            
        }
        return lista;
    }

    // funcion para buscar estudiante.
    // devuelve el estudiante si lo encuentra en otro caso
    public Estudiante buscarEstudiante (String numeroDeMatricula){
        // para guardar al estudiante encontrado

        Estudiante estudianteEncontrado = null;
        for (Estudiante estudiante : alumnado) {
            if (estudiante.getNumeroDeMatricula().equals(numeroDeMatricula))
                estudianteEncontrado = estudiante;
        }
        return estudianteEncontrado;

    }

}
