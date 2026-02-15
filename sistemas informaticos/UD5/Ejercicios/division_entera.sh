#!/bin/bash

division_entera(){
    #Comprabar numero de parametros

    if [ $# -ne 2 ]; then
        echo "Error: Se necesitan exactamente 2 parametros(dividiendo y divisor)"
        echo "Uso: division_entera <dividiendo> <divisor>"
        return 1
    fi
    #Por que lo nombro como local al comienzo
    local dividiendo=$1
    local divisor=$2
    
    #Comprobar division por cero

    if [ $divisor -eq 0 ]; then
    echo "Error:No se puede dividir por cero"
    return 1
    fi 
    local resultado=$((dividiendo / divison))
    echo "Division entera: $dividendo / $divisor = $resultado"
    return 0 
}