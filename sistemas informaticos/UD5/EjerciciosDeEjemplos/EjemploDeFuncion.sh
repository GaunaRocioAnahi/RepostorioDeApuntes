#!/bin/bash

sumar(){
    resultado=$(( $1 + $2)) #Sumar los valores de $1 y $2
    echo $resultado #Devolver el resultado
}
suma=$(sumar 5 3)
echo "la suma es: $suma"