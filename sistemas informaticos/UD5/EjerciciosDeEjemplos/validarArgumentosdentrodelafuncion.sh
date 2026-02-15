calcular_area() {
    if [ $# -ne 2 ]; then
    echo "Uso: calcular_area <base> <altura>"
    return 1
    fi
    area=$(( $1 * $2 ))
    echo "el area es : $area"
}

calcular_area 5 10
calcular_area 7