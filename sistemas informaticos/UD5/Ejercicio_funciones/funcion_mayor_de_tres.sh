#!/bin/bash
#añadir validacion
#Definimos la funcion
mayor_de_tres(){
    #guardamos cada argumento en una variable 
    a=$1
    b=$2
    c=$3
    #Asumimos que el primero es mayor. y lo usamos como punto de partida para comprar
    mayor=$a
    #Comparamos b con el mayor actual si b es mas grande actualiza mayor
    if (( b> mayor)); then
    mayor=$b
    fi
    #Compara c con el mayor actual. si c es mas grande actualiza mayor.
    if ((c>mayor));then
    #Imprime el mayor de los tres
    mayor=$c
    fi
    echo $mayor 
}

mayor_de_tres $1 $2 $3