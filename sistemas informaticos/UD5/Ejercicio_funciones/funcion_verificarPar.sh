#!/bin/bash
#agregar validacion. 

verificar_par(){
    numero=$1
    if (( numero % 2 == 0)); then 
    echo "$numero es par"
    else
    echo "$numero es impar"
    fi
}

verificar_par $1