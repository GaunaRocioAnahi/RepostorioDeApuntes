# Para mi main

```java
public class Proyecto2 {

    public static void main(String[] args) {
        // 1. CREAR EL CINE (Rellenamos los datos que pide el enunciado)
        Cine miCine = new Cine("MAD001", "Stemos Gran Vía", "Madrid", "España");

        // 2. CREAR LAS SALAS (Cada una con su ID y capacidad)
        Sala sala1 = new Sala("S-01", 100);
        Sala sala2 = new Sala("S-02", 50);

        // 3. METER LAS SALAS DENTRO DEL CINE (Para que el cine sepa que existen)
        miCine.agregarSala(sala1);
        miCine.agregarSala(sala2);
        // MOSTRAR DATOS DEL CINE
        System.out.println("------ INFORMACIÓN DEL CINE ------");
        
        // Aquí usamos los métodos que tienen el operador ternario para que, 
        // si hay un error, salga el mensaje entre corchetes [ ].
        System.out.println(miCine.mostrarId());     // Muestra: ID: MAD001
        System.out.println(miCine.mostrarNombre()); // Muestra: Cine: Stemos Gran Vía
        System.out.println(miCine.mostrarCiudad()); // Muestra: Ciudad: Madrid
        System.out.println(miCine.mostrarPais());   // Muestra: País: España
        System.out.println("\n------ LISTADO DE SALAS ------");

        // Recorremos la lista de salas que tiene el cine
        for (Sala salaAuxiliar : miCine.getListaSalas()) {
            
            // 1. Mostramos el ID de la sala
            System.out.print(salaAuxiliar.mostrarId() + " | ");
            
            // 2. Mostramos la capacidad
            System.out.print(salaAuxiliar.mostrarCapacidad() + " | ");
            
            // 3. Mostramos la disponibilidad (Si está libre u ocupada ahora)
            // Este método mostrarEstado() usa un ternario para ver si la lista de proyecciones está vacía.
            System.out.println(salaAuxiliar.mostrarEstado());
        }
    }
}

```


para incrementar el numero de salas pero con un nombre predeterminado. 
puedo modificar el set de salas como setCantidadSala ("S-+ cantidad++");

esto iria en el main para probar

```java
public class Proyecto5 {
    public static void main(String[] args) {
        
        // Creamos una lista para guardar nuestros cines de prueba
        ArrayList<Cine> misCinesDePrueba = new ArrayList<>();

        // --- PASO 1: CREAR 3 CINES USANDO UN BUCLE ---
        for (int i = 1; i <= 3; i++) {
            // Creamos un cine. El código "CINE-X" se genera solo en el constructor.
            Cine nuevoCine = new Cine("Stemos Cinema " + i, "Ciudad " + i, "País " + i);
            
            // --- PASO 2: AGREGAR 3 SALAS A ESTE CINE ESPECÍFICO ---
            for (int j = 1; j <= 3; j++) {
                // Creamos una sala con capacidad aleatoria (ej: 50, 100, 150...)
                Sala nuevaSala = new Sala(j * 50); 
                
                // Metemos la sala en el cine que acabamos de crear
                nuevoCine.agregarSala(nuevaSala);
            }

            // Guardamos el cine ya configurado en nuestra lista de prueba
            misCinesDePrueba.add(nuevoCine);
        }

        // --- PASO 3: MOSTRAR TODO PARA VER SI FUNCIONA ---
        System.out.println("=== REPORTE DE GESTIÓN STEMOS ===");

        // Recorremos la lista de cines (usamos el nombre que inventamos: cineActual)
        for (Cine cineActual : misCinesDePrueba) {
            System.out.println("\n" + cineActual.toString());
            
            // Ahora, por cada cine, recorremos sus salas (usamos: salaActual)
            for (Sala salaActual : cineActual.getListaSalas()) {
                System.out.println("   [SALA] " + salaActual.mostrarId() + 
                                   " | Capacidad: " + salaActual.getCapacidad());
            }
        }
    }
}


```