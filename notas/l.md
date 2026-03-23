#!/bin/bash

############################################
# Ejercicio 0
# Función que valida número mínimo de parámetros
############################################

validar_parametros() {
    minimo=$1
    shift

    if [ $# -lt $minimo ]; then
        echo "Error: Se requieren al menos $minimo parámetros."
        exit 1
    fi
}

############################################
# Ejercicio 1
# Función que calcula el máximo de números naturales positivos
############################################

maximo() {

    # Comprobamos que al menos hay 1 parámetro
    if [ $# -eq 0 ]; then
        echo "Error: Debes pasar al menos un número."
        exit 1
    fi

    max=$1

    for num in "$@"
    do
        if [ $num -gt $max ]; then
            max=$num
        fi
    done

    echo "El número máximo es: $max"
}

############################################
# Ejercicio 2
# Devuelve los nombres de los archivos que
# pesan igual que el archivo más pesado
############################################

archivos_mas_pesados() {

    carpeta=$1

    # Validamos que se pasó la carpeta
    if [ -z "$carpeta" ]; then
        echo "Error: Debes indicar una carpeta."
        exit 1
    fi

    # Comprobamos que existe
    if [ ! -d "$carpeta" ]; then
        echo "Error: La carpeta no existe."
        exit 1
    fi

    max_peso=0

    # Buscamos el peso máximo
    for archivo in "$carpeta"/*
    do
        if [ -f "$archivo" ]; then
            peso=$(stat -c%s "$archivo")

            if [ $peso -gt $max_peso ]; then
                max_peso=$peso
            fi
        fi
    done

    # Mostramos solo los nombres que tengan ese peso
    for archivo in "$carpeta"/*
    do
        if [ -f "$archivo" ]; then
            peso=$(stat -c%s "$archivo")

            if [ $peso -eq $max_peso ]; then
                basename "$archivo"
            fi
        fi
    done
}






 2da opcion:

#!/bin/bash

validar_parametros() {
    minimos=$1
    shift

    if [ $# -lt $minimos ]; then
        echo "Error: se necesitan al menos $minimos parámetros."
        return 1
    fi

    return 0
}

maximo() {
    validar_parametros 1 "$@" || return 1

    max=$1
    shift

    for num in "$@"
    do
        if [ $num -gt $max ]; then
            max=$num
        fi
    done

    echo $max
}

archivos_mas_grandes() {
    validar_parametros 1 "$@" || return 1

    carpeta=$1

    if [ ! -d "$carpeta" ]; then
        echo "Error: no es una carpeta válida"
        return 1
    fi

    max=0

    for archivo in "$carpeta"/*
    do
        if [ -f "$archivo" ]; then
            tam=$(stat -c%s "$archivo")
            if [ $tam -gt $max ]; then
                max=$tam
            fi
        fi
    done

    for archivo in "$carpeta"/*
    do
        if [ -f "$archivo" ]; then
            tam=$(stat -c%s "$archivo")
            if [ $tam -eq $max ]; then
                basename "$archivo"
            fi
        fi
    done
}



3...



#!/bin/bash

# ==========================================================
# EJERCICIO 0
# Función para validar número mínimo de parámetros
# ==========================================================
validar_parametros() {
    if [ $# -lt $(( $1 + 1 )) ]; then
        echo "Se necesitan al menos $1 parámetros"
        return 1
    else
        return 0
    fi
}

# ==========================================================
# EJERCICIO 1
# Devuelve el máximo de una serie de números pasados
# ==========================================================
maximo() {

    validar_parametros 1 $@ || return 1

    mayor=$1

    for numero in "$@"
    do
        if [ "$numero" -gt "$mayor" ]; then
            mayor=$numero
        fi
    done

    echo $mayor
}

# ==========================================================
# EJERCICIO 2
# Devuelve los nombres de los archivos que más pesan
# dentro de una carpeta (sin subcarpetas)
# ==========================================================
archivos_mas_grandes() {

    validar_parametros 1 $@ || return 1

    carpeta=$1

    if [ ! -d "$carpeta" ]; then
        echo "La carpeta no existe"
        return 1
    fi

    mayor=0

    # Buscar el tamaño máximo
    for archivo in "$carpeta"/*
    do
        if [ -f "$archivo" ]; then
            tamaño=$(stat -c %s "$archivo")

            if [ "$tamaño" -gt "$mayor" ]; then
                mayor=$tamaño
            fi
        fi
    done

    # Mostrar solo los archivos que pesan lo máximo
    for archivo in "$carpeta"/*
    do
        if [ -f "$archivo" ]; then
            tamaño=$(stat -c %s "$archivo")

            if [ "$tamaño" -eq "$mayor" ]; then
                basename "$archivo"
            fi
        fi
    done
}

# ==========================================================
# EJEMPLOS (descomentar para probar)
# ==========================================================

# echo "Máximo:"
# maximo 4 7 2 9 5

# echo "Archivos más grandes:"
# archivos_mas_grandes ./mi_carpeta







``` bash
#!/bin/bash

validar() {
    if [ "$2" -lt "$1" ]; then
        echo "Error: se necesitan al menos $1 argumento/s, llegaron $2" >&2
        return 1
    fi
    return 0
}

maximo() {
    validar 1 $# || return 1
    local maximo_actual=$1
    shift
    for numero in "$@"; do
        if [ "$numero" -gt "$maximo_actual" ]; then
            maximo_actual=$numero
        fi
    done
    echo $maximo_actual
}

archivos_mas_pesados() {
    validar 1 $# || return 1
    local carpeta="$1"
    if [ ! -d "$carpeta" ]; then
        echo "Error: '$carpeta' no es un directorio" >&2
        return 1
    fi

    local peso_maximo=0
    local peso_actual

    for fichero in "$carpeta"/*; do
        if [ -f "$fichero" ]; then
            peso_actual=$(du -b "$fichero" | cut -f1)
            if [ "$peso_actual" -gt "$peso_maximo" ]; then
                peso_maximo=$peso_actual
            fi
        fi
    done

    for fichero in "$carpeta"/*; do
        if [ -f "$fichero" ]; then
            peso_actual=$(du -b "$fichero" | cut -f1)
            if [ "$peso_actual" -eq "$peso_maximo" ]; then
                basename "$fichero"
            fi
        fi
    done
}







#!/bin/bash

borrar_grandes() {
    carpeta="$1"

    # Comprobar que se pasó parámetro
    if [ -z "$carpeta" ]; then
        echo "Debes indicar una carpeta"
        return 1
    fi

    # Comprobar que existe y es directorio
    if [ ! -d "$carpeta" ]; then
        echo "No es una carpeta válida"
        return 1
    fi

    # Obtener tamaño máximo (solo contenido directo)
    max_tam=$(ls -lS "$carpeta" | awk 'NR==2 {print $5}')

    # Borrar archivos/carpetas que tengan ese tamaño
    ls -l "$carpeta" | awk -v max="$max_tam" '$5==max {print $9}' | while read nombre
    do
        rm -rf "$carpeta/$nombre"
    done
}
```


en opcion 3 y 4 

```java
} else if (opcion == 3) {
    System.out.print("Ingrese el codigo del animal: ");
    codigoAbuscar = scanner.nextLine(); // El código es texto, usamos nextLine normal
    
    System.out.print("Cantidad a sumar: ");
    // ANTES HACÍAS ESTO:
    // cantidadAModificar = scanner.nextInt();
    // scanner.nextLine(); 
    
    // AHORA USAS TU MÉTODO CON TRY-CATCH:
    cantidadAModificar = pedirNumeroEntero(scanner); 

    // Y sigues con tu lógica normal...
    if (zoo1.agregarEjemplares(codigoAbuscar, cantidadAModificar)) {
        System.out.println("Se han agregado los ejemplares con éxito.");
    } else {
        System.out.println("Error al agregar. Verifique el codigo.");
    }

```

```java

} else if (opcion == 4) {
    System.out.print("Ingrese el codigo del animal a retirar: ");
    codigoAbuscar = scanner.nextLine();
    
    System.out.print("Ingrese la cantidad a retirar: ");
    // USAMOS TU MÉTODO OTRA VEZ AQUÍ:
    cantidadAModificar = pedirNumeroEntero(scanner);

    // Y pegamos la lógica estricta que armamos antes:
    Animal animalEncontrado = zoo1.buscarAnimal(codigoAbuscar);

    if (animalEncontrado == null) {
        System.out.println("Animal no encontrado.");
    } else {
        if (cantidadAModificar > animalEncontrado.getCantidad()) {
            System.out.println("No se puede retirar más ejemplares de los disponibles.");
        } else {
            zoo1.retirarEjemplares(codigoAbuscar, cantidadAModificar);
            System.out.println("Se han retirado los ejemplares.");
        }
    }
}

```