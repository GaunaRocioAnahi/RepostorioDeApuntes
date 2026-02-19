#!/bin/bash
factorial (){
n=$1 # guardamos el argumento (el numero del que queremos calcular el factorial ) en una variable  / puerde ser una variable local.
resultado=1 #Inicializa el resultado en 1 MUltiplicaremos este valor por cada numero de 1 al n. 
#el bulce for que va desde el 1 hasta n (incluido).
for ((i=1; i<=n; i++));do
        resultado=$(( resultado *i ))
done #Cerramos el bucle FOR. 

echo $resultado
}

factorial $1 