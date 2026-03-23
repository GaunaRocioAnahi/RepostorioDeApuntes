```java
// implementacion del faker en un arrayList. 
  // 2️⃣ Crear zoológico
        Zoologico zoo = new Zoologico();
        
        // 3️⃣ AQUÍ usas Faker para generar 1000 animales
        System.out.println("Generando 1000 animales...");
        for (int i = 0; i < 1000; i++) {
            // USAR los métodos que te den
            String nombre = faker.nombre();      // ← Método que te darán
            int cantidad = faker.cantidad();     // ← Método que te darán
            double precio = faker.precio();      // ← Método que te darán
            
            // Crear animal con esos datos
            Animal animal = new Animal(nombre, cantidad, precio);
            
            // Agregar al zoológico
            zoo.agregarAnimal(animal);
        }
        
        // 4️⃣ Continuar con tu menú normal
        // ... tu código actual ...
    }
}

```
Metodos para agregar a la class `Zoologico` 
```java

// MODO 1: SUMAR TODOS LOS ANIMALES DEL ZOO (TOTAL DE EJEMPLARES)
    // PARA QUÉ: Para saber si en total tenemos 5000 animales vivos (sumando leones, tigres, etc.)
    public int obtenerTotalEjemplares() {
        int acumulador = 0; // LÍNEA 1: Empezamos la suma en cero.
        
        // LÍNEA 2: Recorremos cada 'Animal' que está dentro de nuestra 'coleccion'.
        for (Animal a : coleccion) {
            // LÍNEA 3: Sacamos la cantidad de ese animal y la sumamos al total.
            acumulador = acumulador + a.getCantidad(); 
        }
        
        return acumulador; // LÍNEA 4: Devolvemos la suma final.
    }

    // MODO 2: CONTAR CUÁNTOS HAY DE UNA ESPECIE CONCRETA
    // PARA QUÉ: Por si el profesor te dice "¿Cuántos 'Leones' tenemos en total?"
    // el nombreBuscado aqui funciona como un parametro 
    public int contarEjemplaresDeEspecie(String nombreBuscado) {
        int totalEspecie = 0; // Empezamos el contador en cero.
        
        for (Animal a : coleccion) {
            // LÍNEA 1: Comparamos el nombre del animal actual con el que buscamos.
            // USAMOS .equalsIgnoreCase para que no importe si escriben "Leon" o "leon".
            if (a.getNombre().equalsIgnoreCase(nombreBuscado)) {
                // LÍNEA 2: Si el nombre coincide, sumamos su cantidad.
                totalEspecie = totalEspecie + a.getCantidad();
            }
        }
        
        return totalEspecie;
    }
```

En el MAIN. iria, como 

```java
} else if (opcion == 7) { // Supongamos que es la opción 7
    System.out.println("¿De qué especie quieres sumar los ejemplares? (ej: Leon): ");
    
    // AQUÍ DECLARAS LA VARIABLE EN EL MAIN
    String nombreAContar = scanner.nextLine(); 
    
    // AQUÍ "PASAS" ESA VARIABLE AL MÉTODO DEL ZOO
    int resultado = zoo1.contarEjemplaresDeEspecie(nombreAContar);
    
    System.out.println("En total hay " + resultado + " ejemplares de " + nombreAContar);
}

```


para hacer una function con control de errores para las opciones del main es el siguiente. 

debe incresar un numero entero. 

```java
// Este método recibe el scanner, intenta leer un número y atrapa los errores
    public static int pedirNumeroEntero(Scanner scanner) {
        while (true) { // Bucle infinito hasta que lo haga bien
            try {
                // INTENTAMOS leer un número
                int numero = scanner.nextInt();
                scanner.nextLine(); // Limpiamos el buffer si todo sale bien
                return numero; // Devolvemos el número y salimos del método
                
            } catch (Exception e) {
                // SI FALLA (ej: escribe una letra), el programa "cae" aquí
                System.out.print("¡Error! Debes ingresar un número válido. Intenta de nuevo: ");
                scanner.nextLine(); // Limpiamos la letra equivocada del buffer
            }
        }
    }



``` 


donde antes tenia esto! 
```java
System.out.print("Ingrese una opcion: ");
opcion = scanner.nextInt();
scanner.nextLine();

``` 
ahora aplicar al main esta funcion. de esta manera:


```java
System.out.print("Ingrese una opcion: ");
// LLAMAMOS AL MÉTODO: Él se encarga de pelearse con el usuario si mete letras
opcion = pedirNumeroEntero(scanner);

```