Para una clase habitat 

``` java
public class Habitat {
    // Atributos estáticos para control
    private static int numeroHabitats = 0; // Obligatorio según Relación 3

    // Atributos de instancia
    private String id; // Autogenerado
    private String tipo; // Ej: "Selva", "Desierto"
    private double temperatura;
    private double superficieM2;
    private boolean tieneClimatizacion; // Atributo informativo (puede ser public si no tiene reglas)

    // Constructor completo
    public Habitat(String tipo, double temperatura, double superficieM2) {
        this.tipo = tipo;
        this.setTemperatura(temperatura); // Usamos setter por si hay restricciones
        this.superficieM2 = superficieM2;
        asignarId(); // Llamada obligatoria en constructor
        this.tieneClimatizacion = calcularNecesitaClima(); // Atributo calculado
    }

    // Método de ID automático (OBLIGATORIO)
    private void asignarId() {
        numeroHabitats++;
        this.id = "HAB-" + numeroHabitats;
    }

    // Método calculado (Como calcularRequiereCita en Tramite)
    private boolean calcularNecesitaClima() {
        // Regla supuesta: si la temp es extrema, necesita climatización
        return (this.temperatura < 10 || this.temperatura > 30);
    }

    // --- GETTERS Y SETTERS ---
    public String getId() { return id; }
    public String getTipo() { return tipo; }
    
    public double getTemperatura() { return temperatura; }
    
    public void setTemperatura(double temperatura) {
        // Validación: temperatura real terrestre
        if (temperatura >= -50 && temperatura <= 60) {
            this.temperatura = temperatura;
            this.tieneClimatizacion = calcularNecesitaClima(); // Recalculamos si cambia la temp
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tipo: " + tipo + " | Temp: " + temperatura + 
               "°C | Clima: " + (tieneClimatizacion ? "SÍ" : "NO");
    }
}

```

¿como se conecta con el zoologico? 
en la clase zoologico Añadimos `private ArrayList<Habitat> habitat;` 

añadimos un metodo de alta: `public void altaHabitad(Habitat h) { habitats.add(h;)}`

si me piden **temperatura**, mediante el metodo, usamos el getTemperatura();
 en la clase zoologico ponemos lo siguiente. 
 ```java
public Habitat buscarHabitat(String id) {
    for (Habitat habitatIndividual : habitats) {
        // Comparamos el ID que nos dan con el ID de cada hábitat de la lista
        if (habitatIndividual.getId().equalsIgnoreCase(id)) {
            return habitatIndividual; // Devolvemos el objeto completo si coincide
        }
    }
    return null; // Si no lo encuentra, devuelve nada
}

 ```


 luego en el main

 ```java
} else if (opcion == 7) {
    // 1. Pedimos el ID al usuario
    System.out.println("Escriba el ID del hábitat a consultar (ej: HAB-1):");
    String idIntroducido = scanner.nextLine();

    // 2. Le pedimos al objeto 'zoo1' que busque en su lista
    // Guardamos el resultado en una variable con nombre descriptivo
    Habitat habitatEncontrado = zoo1.buscarHabitat(idIntroducido);

    // 3. Verificamos si la búsqueda tuvo éxito
    if (habitatEncontrado != null) {
        // Accedemos al dato privado usando el getter
        double tempActual = habitatEncontrado.getTemperatura();
        String tipoDeHabitat = habitatEncontrado.getTipo();

        System.out.println("El hábitat de tipo " + tipoDeHabitat + " tiene una temperatura de " + tempActual + "°C.");
    } else {
        // Si el método buscarHabitat nos devolvió 'null'
        System.out.println("Error: No existe ningún hábitat con el ID " + idIntroducido);
    }
}

 ```


 para el habitat si nos piden si un animal esta en su peligro y no esta en su habitat. 
 esto requiere que el zoologico compare datos de dos objetos distintos animal y habitat. 

 Agregamos a la clase un anitrbuto nuevo como 

 ```java
private double temperaturaIdeal; // Ej, 26.5 para el leon
 ```


 en el Zoologico, verificarBienestar()

 Este metodo recorre los animales, busca su habitat y compara las temperaturas. 

 ```java 
 public void verificarBienestarAnimales() {
    // Leemos: "Por cada animalActual que haya en la listaAnimales..."
    for (Animal animalActual : listaAnimales) {
        
        // Obtenemos el hábitat del animal con un nombre claro
        Habitat habitatDelAnimal = animalActual.getHabitat();
        
        // Calculamos la resta sin Math.abs (usando la lógica de las dos condiciones)
        double diferencia = animalActual.getTempIdeal() - habitatDelAnimal.getTemperatura();
        
        // Comparamos si la diferencia se sale del rango de 10 o -10
        if (diferencia > 10 || diferencia < -10) {
            System.out.println("⚠️ ALERTA: El " + animalActual.getNombre() + 
                               " está en peligro térmico.");
        }
    }
}

 ```
en el main 

```java 

} else if (opcion == 7) {
    // 1. Pedimos el ID al usuario
    System.out.println("Escriba el ID del hábitat a consultar (ej: HAB-1):");
    String idIntroducido = scanner.nextLine();

    // 2. Le pedimos al objeto 'zoo1' que busque en su lista
    // Guardamos el resultado en una variable con nombre descriptivo
    Habitat habitatEncontrado = zoo1.buscarHabitat(idIntroducido);

    // 3. Verificamos si la búsqueda tuvo éxito comparando con null
    if (habitatEncontrado != null) {
        // Accedemos al dato privado usando el getter
        double temperaturaActual = habitatEncontrado.getTemperatura();
        String tipoDeHabitat = habitatEncontrado.getTipo();

        System.out.println("El hábitat de tipo " + tipoDeHabitat + " tiene una temperatura de " + temperaturaActual + "°C.");
    } else {
        // Si el método buscarHabitat nos devolvió 'null' significa que no existe
        System.out.println(" Error: No existe ningún hábitat con el ID " + idIntroducido);
    }
}

```
class Cuidador 

```java
public class Cuidador {
    // Variable estática para generar IDs correlativos (Norma Relación 3)
    private static int contadorGlobalDeCuidadores = 0;

    private String codigoEmpleado; // Autogenerado, sin setter
    private String nombreCompleto;
    private String especialidadTecnica; // Ej: "Reptiles", "Grandes Felinos"
    private double sueldoMensual;

    public Cuidador(String nombreCompleto, String especialidadTecnica, double sueldoMensual) {
        this.nombreCompleto = nombreCompleto;
        this.especialidadTecnica = especialidadTecnica;
        this.setSueldoMensual(sueldoMensual); // Usamos setter para validar
        this.asignarIdentificadorUnico(); // Llamada obligatoria en constructor
    }

    // Método para generar el código automáticamente (HAB-1, HAB-2...)
    private void asignarIdentificadorUnico() {
        contadorGlobalDeCuidadores++;
        this.codigoEmpleado = "CUID-" + contadorGlobalDeCuidadores;
    }

    // Validación de sueldo (Regla de negocio supuesta)
    public void setSueldoMensual(double sueldoPropuesto) {
        if (sueldoPropuesto >= 1134) { // Salario mínimo
            this.sueldoMensual = sueldoPropuesto;
        } else {
            this.sueldoMensual = 1134;
        }
    }

    // Getters descriptivos
    public String getNombreCompleto() { return nombreCompleto; }
    public String getCodigoEmpleado() { return codigoEmpleado; }

    @Override
    public String toString() {
        return "ID: " + codigoEmpleado + " | Nombre: " + nombreCompleto + 
               " | Especialidad: " + especialidadTecnica;
    }
}

```

Zoologico (gestor)

```java
public class Zoologico {
    private ArrayList<Animal> coleccionAnimales;
    private ArrayList<Cuidador> personalDelZoo; // Lista de cuidadores

    // Constructor...
    
    // MÉTODO DE ALTA (Como en la Relación 3)
    public void registrarNuevoCuidador(Cuidador cuidadorParaDarDeAlta) {
        this.personalDelZoo.add(cuidadorParaDarDeAlta);
    }

    // MÉTODO DE BÚSQUEDA DESCRIPTIVO
    public Cuidador buscarCuidadorPorCodigo(String codigoCuidadorBuscado) {
        for (Cuidador cuidadorActual : personalDelZoo) {
            // Comparamos el código del cuidador que estamos recorriendo
            if (cuidadorActual.getCodigoEmpleado().equalsIgnoreCase(codigoCuidadorBuscado)) {
                return cuidadorActual; // Devolvemos el objeto completo
            }
        }
        return null; // Si no aparece
    }
}





```


main..

quien es ek cuidador
```java
} else if (opcion == 8) { // Supongamos la opción 8: Consultar Cuidador
    System.out.println("Escriba el código del cuidador a consultar (Ej: CUID-1):");
    String codigoIntroducidoPorUsuario = scanner.nextLine();

    // Le pedimos al Zoo que busque en su lista de personal
    Cuidador cuidadorEncontradoEnSistema = zoo1.buscarCuidadorPorCodigo(codigoIntroducidoPorUsuario);

    if (cuidadorEncontradoEnSistema != null) {
        // Si existe, lo mostramos usando su propio toString()
        System.out.println("--- Ficha del Empleado ---");
        System.out.println(cuidadorEncontradoEnSistema.toString());
    } else {
        System.out.println(" Error: No existe ningún cuidador con el código " + codigoIntroducidoPorUsuario);
    }
}

```


donde puede meter los animales Jaulas o recintos. 


la jaula tiene una limitacion el recinto no. 

```java
public class Jaula {
    private static int contadorGlobalDeJaulas = 0;

    private String codigoJaula; // Autogenerado
    private double superficieMetrosCuadrados;
    private int capacidadMaximaAnimales;
    private boolean estaLimpia;
    private Animal animalResidente; // Aquí guardamos al animal que esté dentro (como el barco en el amarre)

    public Jaula(double superficieMetrosCuadrados, int capacidadMaximaAnimales) {
        this.superficieMetrosCuadrados = superficieMetrosCuadrados;
        this.capacidadMaximaAnimales = capacidadMaximaAnimales;
        this.estaLimpia = true;
        this.animalResidente = null; // Al principio la jaula está vacía
        this.generarCodigoAutomatico();
    }

    private void generarCodigoAutomatico() {
        contadorGlobalDeJaulas++;
        this.codigoJaula = "JAU-" + contadorGlobalDeJaulas;
    }

    // Método para saber si la jaula está libre (como saber si el amarre tiene barco)
    public boolean estaDisponible() {
        return this.animalResidente == null;
    }

    // Getters descriptivos
    public String getCodigoJaula() { return codigoJaula; }
    public void setAnimalResidente(Animal animalParaEntrar) { this.animalResidente = animalParaEntrar; }
}

``` 

Zoologico

ocupar jaulas. 

```java
public class Zoologico {
    private ArrayList<Animal> coleccionAnimales;
    private ArrayList<Jaula> listaDeJaulas;

    // MÉTODO ESTRELLA: Asignar un animal a una jaula
    public boolean meterAnimalEnJaula(String codigoAnimal, String codigoJaula) {
        Animal animalBuscado = buscarAnimalPorCodigo(codigoAnimal);
        Jaula jaulaBuscada = buscarJaulaPorCodigo(codigoJaula);

        // REGLAS DE NEGOCIO (Como en la Relación 3)
        if (animalBuscado != null && jaulaBuscada != null) {
            if (jaulaBuscada.estaDisponible()) {
                jaulaBuscada.setAnimalResidente(animalBuscado);
                return true; // Éxito
            }
        }
        return false; // No se pudo (o no existe uno de los dos, o está ocupada)
    }

    public Jaula buscarJaulaPorCodigo(String codigoABuscar) {
        for (Jaula jaulaActual : listaDeJaulas) {
            if (jaulaActual.getCodigoJaula().equalsIgnoreCase(codigoABuscar)) {
                return jaulaActual;
            }
        }
        return null;
    }
}
```

en el main asignar jaulas. 
```java
} else if (opcion == 9) { // Asignar Jaula
    System.out.println("Introduzca el código del animal:");
    String codAnimal = scanner.nextLine();
    
    System.out.println("Introduzca el código de la jaula (Ej: JAU-1):");
    String codJaula = scanner.nextLine();

    // Mandamos la orden al zoológico
    boolean asignacionExitosa = zoo1.meterAnimalEnJaula(codAnimal, codJaula);

    if (asignacionExitosa) {
        System.out.println(" El animal ha sido instalado en la jaula correctamente.");
    } else {
        System.out.println(" No se pudo realizar la asignación. Verifique códigos o disponibilidad.");
    }
}
```


# JAULAS. 


``` java 
public class Jaula {
    private static int contadorTotalDeJaulas = 0;

    private String codigoIdentificador; 
    private double superficieMetrosCuadrados;
    private boolean estaLimpia;
    private int nivelDeSuciedad;
    private Animal animalResidente; // El objeto relacionado

    public Jaula(double superficieMetrosCuadrados) {
        this.superficieMetrosCuadrados = superficieMetrosCuadrados;
        this.estaLimpia = true;
        this.nivelDeSuciedad = 0;
        this.animalResidente = null; 
        this.generarCodigoAutomatico();
    }

    private void generarCodigoAutomatico() {
        contadorTotalDeJaulas++;
        this.codigoIdentificador = "JAU-" + contadorTotalDeJaulas;
    }

    // --- Otros métodos (limpiar, registrar uso...) van aquí ---

    @Override
    public String toString() {
        // Usamos una variable para que el mensaje de "Animal" sea descriptivo
        String informacionDelInquilino;
        
        if (this.animalResidente == null) {
            informacionDelInquilino = "VACÍA";
        } else {
            // Si hay un animal, mostramos su nombre y código
            informacionDelInquilino = "Ocupada por: " + animalResidente.getNombre() + 
                                     " (" + animalResidente.getCodigo() + ")";
        }

        return "--- DATOS DE LA JAULA [" + codigoIdentificador + "] ---\n" +
               "Superficie: " + superficieMetrosCuadrados + " m2\n" +
               "Estado: " + (estaLimpia ? "LIMPIA" : "SUCIA (Requiere atención)") + "\n" +
               "Situación: " + informacionDelInquilino + "\n" +
               "---------------------------------------";
    }
}

```
en el zoologico : 
```java
public String obtenerFichaCompletaDeJaula(String codigoJaulaBuscado) {
    // 1. Usamos el método de búsqueda que ya teníamos
    Jaula jaulaEncontrada = buscarJaulaPorCodigo(codigoJaulaBuscado);

    // 2. Si la encontramos, devolvemos su toString
    if (jaulaEncontrada != null) {
        return jaulaEncontrada.toString(); 
    } else {
        return " Error: La jaula con código " + codigoJaulaBuscado + " no existe.";
    }
}
```

main 

```java

} else if (opcion == 10) { // Opción: Consultar Ficha de Jaula
    System.out.println("Introduzca el código de la jaula a consultar (Ej: JAU-1):");
    String codigoIntroducido = scanner.nextLine();

    // El Zoo nos devuelve el String ya montado por el toString() de la Jaula
    String fichaDeLaJaula = miZoologico.obtenerFichaCompletaDeJaula(codigoIntroducido);

    // Simplemente lo imprimimos
    System.out.println(fichaDeLaJaula);
}
```

listasr todos los elementos de un arrays
 ```java

public void mostrarInformeTodasLasJaulas() {
    System.out.println("=== INFORME DE TODAS LAS JAULAS ===");
    for (Jaula jaulaActual : listaDeJaulas) {
        // Al imprimir el objeto directamente, Java usa su toString()
        System.out.println(jaulaActual);
        System.out.println(); // Espacio en blanco entre jaulas
    }
}
 ```


ejemplo de como declararlo en el zoologico. 

```java
import java.util.ArrayList;

public class Zoologico {
    // Todos los arrays se declaran aquí como atributos privados
    private ArrayList<Animal> inventarioAnimales;
    private ArrayList<Jaula> listadoJaulas;
    private ArrayList<Cuidador> personalCuidadores;

    public Zoologico() {
        // Se inicializan en el constructor
        this.inventarioAnimales = new ArrayList<>();
        this.listadoJaulas = new ArrayList<>();
        this.personalCuidadores = new ArrayList<>();
    }

    // MÉTODOS DE GESTIÓN (Los que usará el menú)
    public void registrarAnimal(Animal nuevoAnimal) {
        this.inventarioAnimales.add(nuevoAnimal);
    }

    public void registrarJaula(Jaula nuevaJaula) {
        this.listadoJaulas.add(nuevaJaula);
    }
    
    // Getters para que el Main pueda recorrer las listas si lo necesita
    public ArrayList<Jaula> getListadoJaulas() {
        return this.listadoJaulas;
    }
}


```
