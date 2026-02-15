#!/bin/bash

area_rectangulo(){
    if [ $# -ne 2 ]; then 
    echo "Error: Se necesita exactamente 2 parametros (base y altura)"
    echo "Uso:area_rectangulo <base> <altura>"
    return 1
    fi
    local base=$1
    local altura=$2

    #Comprobamos que sean valores positivos.
    #If aritmeticos con ()
    if (( $(echo "$base <=0" | bc -l ) )) || (( $(echo "$altura <= 0" | bc -l) )); then
    echo "Error: Base y altura deben ser numeros positivos"
    return 1
    fi

    #Calculamos base * altura el area

    local area=$(echo "scale=4; $base * $altura" | bc -l)
    echo "area del rectangulo (base=$base, altura=$altura): $area"
    return 0
}