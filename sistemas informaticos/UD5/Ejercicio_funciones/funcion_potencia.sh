#!/bin/bash

potencia(){
    resultado=$(( $1 ** $2))   #(echo "$1 ^ $2" | bc -l)  #(( $1 ** $2)) #Indica la potencia de los valores $1 y $2 ( importante el operador de potencia es (**)) para numeros enteros. pero si acepto decimales deberia poner las comillas y el siguiente operador ^. con un echo y los valores $1 y$2
    echo $resultado #Devuelve el resultado 
}


potencia $1 $2

