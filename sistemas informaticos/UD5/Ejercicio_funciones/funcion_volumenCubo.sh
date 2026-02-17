#!/bin/bash
#agregar validacion
volumen_cubo(){
    lado=$1 #Declaramos valiable como lado con valor $1 
    volumen=$(( $1*$1*$1))
    echo $volumen
}


volumen_cubo $1