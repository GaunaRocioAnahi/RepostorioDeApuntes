#!/bin/bash

area_triangulo(){
    area=$(( $1 * $2 /2))
    echo "El area del triangulo es : $area"
}
resultado=$(area_triangulo 3 4)
echo $resultado