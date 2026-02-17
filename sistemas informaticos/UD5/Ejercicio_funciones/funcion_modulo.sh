#!/bin/bash
#Agregar validacion
modulo(){
    dividiendo=$1
    divisor=$2
    resto=$(( dividiendo % divisor ))
    echo $resto
}


modulo $1 $2