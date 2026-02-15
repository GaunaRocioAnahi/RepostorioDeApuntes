#!/bin/bash
PI = 3.14
perimetro_ciruclo(){
    #Comprobamos numero de parametro
    if [ $# -ne 1 ]; then
    echo "Error: El radio debe ser un numero positivo"
    return 1
    fi

    #Calcular perimetro con 2*PI*radio

    #Hacemos el if aritmetico

    if(($(echo "$radio <=0" | bc -l) )); then 
    echo "Error: El radio debe ser un numero positivo"
    return 1
    fi
    local perimetro=$(echo "!scale = 4; 2*$PI * $radio")
    echo "Perimetro del circulo con radio $radio: $perimetro"
    return 0
}