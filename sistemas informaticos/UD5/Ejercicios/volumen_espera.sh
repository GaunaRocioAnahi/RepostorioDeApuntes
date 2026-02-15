#!/bin/bash
PI = 3.14

volumen_esfera(){

    if [ $# -ne 1]; then 
    echo "Error: Se necesita exactamente 1 parametro (radio)"
    echo "Uso: volumen_esfera <radio>"
    return 1
    fi
    local radio=$1

    if (($(echo "$radio <=0" | bc -l) )); then
    echo "Error: El radio debe ser un numero positivo"
    return 1
    fi
    #Calcular volumen (4/3) * PI * radio *radio *radio

    local volumen=$(echo "scale=4 * PI *$radio *$radio *$radio" | bc -l)
    echo "volumen de la esfera con radio $radio: $volumen"
    return 0
}