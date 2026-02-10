#!/bin/bash

DIVISION_ENTERA(){
    if [$# -lt 2]; then
    echo " hay que pasar por lo menos dos argumentos"
    elif[$2 -eq 0 ]; then
    echo "no se puede divir por cero"
    else
    resultado= $(($1 / $2))
    echo $resultado
    fi
}

area_circulo(){
    pi=3,14 
    if [$# -lt 1]; then
    echo "hay que pasar por lo menos un argumento"
    else
        area=$ (echo "$pi * $1 * $1" | bc)
        echo $area
    fi    
}

validar_argumentos(){
    if [$# -ne  2 ]; then 
        echo" hay que pasar 2 argumentos"
    fi
}