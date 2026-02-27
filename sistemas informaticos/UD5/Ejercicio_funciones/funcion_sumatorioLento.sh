#!/bin/bash

sumatorio_lento() {
    limite=$1
    # Usamos limite para saber hasta dónde tenemos que llegar sumando
    
    total=0       # aquí vamos acumulando la suma, empieza en 0
    numero=1      # este es el número que vamos a ir sumando, empieza en 1
    
    # Usamos numero para recorrer del 1 al limite
    # En cada paso sumamos numero al total y avanzamos numero
    while [ "$numero" -le "$limite" ]; do
        total=$((total + numero))   # añadimos el numero actual al total
        numero=$((numero + 1))      # pasamos al siguiente número
    done
    
    # Al salir del bucle total tiene la suma de todos los números
    echo $total
}
sumatorio_lento 