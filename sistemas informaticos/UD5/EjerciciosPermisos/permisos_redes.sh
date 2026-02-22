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