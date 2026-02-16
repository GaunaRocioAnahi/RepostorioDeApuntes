package programcion.UD5.Relacion2.Ejercicio1;

import java.util.ArrayList;

public class Ejercicio1 {
    public static void main(String[] args) {

        Estudiante alfredo = new Estudiante("alfredo", 22, "STEM001");
        System.out.println("alfredo");
        Estudiante cristobal = new Estudiante("Cristobal", 22, "STEM002");
        Estudiante tomas = new Estudiante("Tomas", 55, "STEM003");
        Estudiante estudianteABuscar;
        alfredo.setNombre("alfredo");
        System.out.println(alfredo.getNombre());
        alfredo.setEdad(10);
        System.out.println(alfredo.getEdad());

        Universidad ugr = new Universidad();
        System.out.println(ugr);
        ugr.agregarEstudiante(alfredo);
        ugr.agregarEstudiante(cristobal);

        System.out.println(ugr.mostrarEstudiantes());
        System.out.println("***************");
        System.out.println(ugr.mostrarEstudianteCompleto());

        Universidad uma = new Universidad();
        uma.agregarEstudiante(cristobal);
        uma.agregarEstudiante(tomas);

        estudianteABuscar = ugr.buscarEstudiante("STEM001");
        System.out.println(estudianteABuscar);

        Universidad uco = new Universidad();
        Estudiante estudianteAleatorio;
        final int NUMEROESTUDIANTES = 100;
        // aca importamos en este for el archivo faker faker.nombreCompleto

        for(int i = 0; i < NUMEROESTUDIANTES; i++) {
            estudianteAleatorio = new Estudiante(null, i, null)
        }

    }
}
