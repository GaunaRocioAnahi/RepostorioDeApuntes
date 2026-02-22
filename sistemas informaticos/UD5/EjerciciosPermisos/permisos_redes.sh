#!/bin/bash
#funcion de validar elemento y cada vez que querramos validar una funcion usaremos la misma. 
validar_argumentos() {
    if [ "$2" -ne "$1" ]; then
        echo "Error: Hay que pasar $1 argumento/s." >&2
        return 1
    fi
    return 0
}


crear_directorio(){
    validar_argumentos 1 $# || return 1 # llamamos a validar_argumentos(), si falla || cortamos la ejecucion de esta funcion con return 1
    local directorio="$1"

    #El comando dirname saca la carpeta anterior, y devuelve /tmp/ que estaba /"tmp/pueba" nos demuestra que seria padre de esa /prueba.
    local ruta_padre=$(dirname "$directorio")


    #La condicion [] significa si NO (!) hay permisos de escritura (-w)

    if [ ! -w "$ruta_padre" ]; then 
        echo "Error: No tienes permiso de escritura en la ruta padre '$ruta_padre'." >&2 # fijarse siempre la flecha de salida. < significa entrada. 
        return 1
    fi

    #comprobadmos si existe el directorio con la condicion y usando el comando (-d)

    #la condicion significa: Si es un directorio y existe (-d)
    #No olvidarse los espacios despues de [ t el $ 

    if [ -d "$directorio" ]; then
        echo "Directorio '$directorio' ya existe"
    else
        #Si no existe, lo creamos y avisamos
        mkdir -p "$directorio"
        echo "Directorio '$directorio' creado"
    fi    
}

buscar_archivos_grandes(){
    # Comprueba que nos dan a validar 2 argumento ( ruta y megas )

    validar_argumentos 2 $# || return 1 
    #Guardamos los argumentos en variables claras

    local ruta="$1"
    local megas="$2"

#si NO es un directorio la ruta, se usa la negacion y la comprobación de que de directorio -d.

    if [ ! -d "$ruta" ]; then 
        echo "Error: Laruta '$ruta' no exixte". >&2
        return 1

    fi

    #Calculamos los Megabytes a bytes con la forula y van en $((formula))

    local bytes=$(( megas * 1024 * 1024 ))
    #Usamos find y guardamos lo que encuentre en una variable resultados
    #$() ejecuta el comadno silenciosamente y atrapa el texto que genera. c es por que este nuermo esta medidos en bytes

    local resultados=$(find "$ruta" -type f -size + "$bytes"c)

    #con -z verificamos si el texto esta vacio.

    if [ -z "$resultados" ]; then
        echo "No se encuentra archivos > $megas MB"
    else
    # si no esta vacio usamos un echo con comillas para imprimir la lista linea a linea
        echo "$resultados"
    fi
}

buscar_por_extension(){
    #valir 2 o 3 argumentos, en este caso es muy necesario que sean 3, ya que nos pueden perdir o 2 o 3 argumento y para no entrar en errores a la hora de ejecutar lo que hacemos es usar 3 argumetnos con una nueva funcion de validar ya que el anterior solo validaba dos. 

    if [ "$#" -ne 2 ] && [ "$#" -ne 3 ]; then
        echo "Error. Uso buscar_por_extension /ruta/ extension [-c]" >&2
        return 1
    fi

    # podemos hacer variables. como (ruta=$1), (extension=$2), (contar=$3). o no usarlas y usar directamente los que son el $ con el numero correspondiente a esa variable. 

    local ruta=$1
    local extesion=$2
    local contar=$3

    if [ ! -d "$ruta" ]; then
        echo "Error: La ruta '$ruta' no existe" >&2
        return 1
    fi

    #Buscamos archivos con -type f (solo archivos), -name "*.$extension" (que terminan en la extension)

    local resultados=$(find "$ruta" -type f -name "*.$extension")

    #verificamos con -z si esta vacio

    if [ -z "$resutlados" ]; then
    #si esta vacio y nos pideeron contar, devolvemos un 0.
        if [ "$contar" = "-c"]; then 
            echo "0"
        else 
            echo "No se encontraron archivos con la extension .$extension"
        fi
        return 0 #termina porque no habia archivos
    fi

    #si el codigo avanza es por que si habia archivos. 
    #Preguntamos si el tercer argumento era -c.

    if [ "$contar" = "-c" ]; then
        #wc -l cuenta las lineas. Le pasmos los resultados usando una tuberia ( | )
        local cantidad=$(echo "$resultados" | wc -l)
        echo "$cantidad"
    else
    #si no nos pide contar, mostramos la lista normal

    echo "$resultados"
    fi
}

cambiar_permisos(){
#son 2 argumentos que me piden ya que me piden un archivo y eso cambiar el permiso. 
    validar_argumentos 2 $# || return 1 
 # si usariamos variables serian local con el (archivo=$1)(permiso=$2)
    #comprobamos la existencia del fichero
if [ ! -e "$2" ]; then
    echo "Error: El fichero '$2' no existe" >&2
    return 1
fi

#comprobamos si el texto NO(!) coincide (=~) con el formato correcto, seria como un detector de mentiras. 

if [[ ! "$1" =~ ^[0-7]{3,4}$ ]]; then
    echo "Error: Formato de permiso invalido. Debe ser de 3 o 4 numeros"
    return 1
fi

#Si todo esta bien aplicamos el comadno chmod y avisamos.
chmod "$1" "$2"
echo "permiso de '$1' cambiados a $1" 
}

obtener_propietario(){
    validar_argumentos 1 $# || return 1

    if [ ! -e "$1" ]; then
        echo "Error: El fichero '$1' no existe." >&2
        return 1
    fi

    #EXtraemos el duelo y grupo usando el comando 'stat' 
    # %U obtengo el Usuario , %g Obtengo el grupo

    #hacemos una variable de propietario ususario de archivos
    # y hacemos una variable que llame al grupo. 

    local propietario=$(stat -c %U "$1")
    local grupo=$(stat -c %G "$1")

    # imprimimos el resultado con el formato exacto que nos pide el ejercicio.

    echo "$1: propietario=$propietario grupo=$grupo"

}

respaldo(){
    validar_argumentos 1 $# || return 1
    if [ ! -e "$1" ]; then 
        echo "Error El fichero o directorio '$archivo' no existe " >&2
        return 1
    fi

    # Paso 2: Guardar el dato en una variable para conseguir la fecha de hoy 
    # EL +%f le dice a date que no de el formato del año mes dia.
    local fecha=$(date +%F)

    #pega las palbras para crear el nombre de l copia.
    #Usamos {} para que bash no se confunda con el guion bajo



    local nuevo_nombre="${archivo}_${fecha}.bak"
    
    #hacemos la copia usando el comando cp- y el -r por si es una carpeta con cosas dentro
    cp -r "$archivo" "$nuevo_nombre"


    echo "Respaldo creado con éxito: $nuevo_nombre"

}

tamanio_directorio(){
    # Paso 1: Validar que sea 1 argumento exacto
    validar_argumentos 1 $# || return 1

    # Paso 2: Guardamos la ruta y comprobamos si NO es un directorio válido
    local directorio="$1"

    if [ ! -d "$directorio" ]; then
        echo "Error: La ruta '$directorio' no es un directorio válido o no existe." >&2
        return 1
    fi

    # Paso 3: Pesamos el directorio en bytes. 
    # du -sb saca el total en bytes. cut -f1 recorta solo el número.
    local bytes=$(du -sb "$directorio" | cut -f1)

    # Paso 4: Convertimos los bytes a bits (1 byte = 8 bits)
    local bits=$(( bytes * 8 ))

    # Paso 5: Mostramos la salida tal cual pide el ejercicio
    echo "$bits (bits)"
    
    # Salida exitosa (cumpliendo el requisito general del código de salida 0)
    return 0
}