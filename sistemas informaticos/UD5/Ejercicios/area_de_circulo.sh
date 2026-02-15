#!/bin/bash

#Declaramos el PI.
PI= 3.14

area_circulo(){
    #comprobar numero de parametros

    if [ $# -ne 1]; then
    echo "Error: Se necesita exactamente 1 parametro(radio)"
    echo "Uso: area_circulo <radio>"
    return 1
    fi
    radio=$1

    #Comprobar  que el radio sea positivo. comparamos un bc para decimal por eso usamos (()). en el sefundo if 


    if (($(echo "$radio <=0" | bc -l) )); then
    echo "Error: El radio debe ser un numero positivo"
    return 1
    fi

    #calculamos el area 

    local area=$(echo "scala =4; PI * $radio * $radio" | ba -l)
    echo"Area del circulo con radio $radio: $area"
    return 0

}