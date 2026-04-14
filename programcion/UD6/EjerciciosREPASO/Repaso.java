package UD6.EjerciciosREPASO;

import java.util.ArrayList;

public class Repaso {
    public static void main(String[] args) {
        
        // 1. CREACIÓN DE OBJETOS (Parte 7.a)
        // Creamos un Director con capacidad para 5 músicos y un plus de 100.0
        Director dir = new Director("Maestro Rodrigo", 50, 20, "Viento", 5, 100.0);
        
        // Creamos Trompetistas (nombre, edad, antiguedad, instrumento, nivel, asistencia, valorBase, resistencia, solos)
        Trompetista t1 = new Trompetista("Luis", 25, 5, "Trompeta sib", 3, 2, 50.0, 6, 2);
        Trompetista t2 = new Trompetista("Ana", 19, 2, "Trompeta Do", 2, 4, 50.0, 4, 1);
        
        // Creamos Percusionistas (nombre, edad, antiguedad, instrumento, nivel, asistencia, valorBase, potencia, ritmos)
        Percusionista p1 = new Percusionista("Carlos", 30, 8, "Timbal", 4, 5, 60.0, 7, 10);
        Percusionista p2 = new Percusionista("Elena", 17, 1, "Caja", 1, 1, 40.0, 3, 2);

        // 2. MODIFICACIÓN DE DATOS (Parte 7.b)
        // Llamamos a los métodos para probar que funcionan y cambian el estado de los objetos.
        t1.registrarEnsayo(); // Ahora tiene 3 ensayos (podrá participar)
        t1.asignarInstrumento("Trompeta de Oro", 500.0);
        t2.subirNivel();
        
        p1.registrarCambioRitmoCorrecto();
        p1.aumentarPotencia(2);
        p2.quitarInstrumento("Baquetas antiguas", 10.0); // No hará mucho porque no tenía, pero prueba la lógica
        
        // Gestión del Director
        dir.asignarMusico(t1);
        dir.asignarMusico(t2);
        dir.asignarMusico(p1);
        dir.expulsarMusico("Ana"); // Quitamos a Ana para probar la expulsión
        dir.asignarMusico(t2);     // La volvemos a añadir

        // 3. LA COLECCIÓN POLIMÓRFICA (Parte 7.c)
        // Creamos una lista que acepta CUALQUIER tipo que herede de PersonaAgrupacion.
        ArrayList<PersonaAgrupacion> listaPersonal = new ArrayList<>();
        listaPersonal.add(dir);
        listaPersonal.add(t1);
        listaPersonal.add(t2);
        listaPersonal.add(p1);
        listaPersonal.add(p2);

        // 4. CÁLCULOS Y LÓGICA DE RECORRIDO (Parte 7.d)
        double sumaTotalAportaciones = 0;
        int contadorPuedenParticipar = 0;

        // Recorremos la lista. No importa si es Director o Músico, 
        // Java sabe qué método calcularAportacion() llamar gracias al Polimorfismo.
        for (PersonaAgrupacion p : listaPersonal) {
            sumaTotalAportaciones += p.calcularAportacion();
            
            if (p.puedeParticipar()) {
                contadorPuedenParticipar++;
            }
        }

        // 5. MOSTRAR RESULTADOS (Parte 7.e)
        System.out.println("--- RESULTADOS FINALES ---");
        
        // Aportación del director (llamada directa)
        System.out.println("Aportación del director: " + dir.calcularAportacion());
        
        // Aportación de cada músico (podemos usar la lista o los objetos)
        System.out.println("Aportación de T1 (Luis): " + t1.calcularAportacion());
        System.out.println("Aportación de T2 (Ana): " + t2.calcularAportacion());
        System.out.println("Aportación de P1 (Carlos): " + p1.calcularAportacion());
        System.out.println("Aportación de P2 (Elena): " + p2.calcularAportacion());
        
        // Datos del director sobre sus músicos asignados
        System.out.println("Músicos asignados al director: " + dir.contarMusicosAsignados());
        System.out.println("Valor total aportación de sus músicos: " + dir.calcularValorTotalAportacionMusicos());
        
        // Resultados globales de la colección
        System.out.println("Suma total aportación de toda la agrupación: " + sumaTotalAportaciones);
        System.out.println("Número total de personas que pueden participar: " + contadorPuedenParticipar);
    }
}
