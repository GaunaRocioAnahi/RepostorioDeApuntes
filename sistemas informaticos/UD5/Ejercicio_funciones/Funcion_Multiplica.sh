#!/bin/bash

multiplicar(){
    resultado=$(( $1 * $2)) #Multiplica los valores de $1 y $2
    echo $resultado #Devuelve el resultado. 
}


# lo llamamos dentro dandole valores. utilizamos lo siguiente. 
#multiplica=$(multiplicar 7 8)
#echo "el resultado de la multiplicacion es : $multiplica" 

#Para poner valores por terminal utilizamos lo siguiente y luego ponemos valores al ejecutar en la terminal.

multiplicar $1 $2