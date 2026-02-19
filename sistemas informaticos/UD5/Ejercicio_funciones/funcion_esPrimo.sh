#!/bin/bash
es_primo(){
    n=$1 #guarda el numero a verificar en una variable local.
    if(( n<2 )); then #Los menores que 2 no son primos (0,1 y negativos). si el numero es menor que no muestra el mensaje y termina la funcion con return
    echo "$n no es primo"
    return 
    fi
    #El 2 es el unico numero primo par. Si es 2, muestra que es primo y termina. 
    if(( n == 2 )); then 
        echo "$n es primo" 
        return
    fi
# Si el numero es par (divisible entre 2) no es primo y termina.

if (( n % 2 == 0 )); then
    echo "$n no es primo"
    return
fi 



if (( n% i == 0 )); then
    echo"$n no es primo"
    return
fi   

#Inicio un bucle que verifica devisores impares desde 3 hasat la raiz cuadrada de n.

for ((i=3; i*i<=n; i+=2)); do 
        if (( n % i == 0 )); then
        echo "$n no es primo"
        return
        fi
done
echo "$n es primo"        

}

es_primo $1