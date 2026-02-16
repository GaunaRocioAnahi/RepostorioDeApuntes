#!/bin/bash

menu(){
    
    echo ""
    echo "=================================="
    echo "  CALCULADORA DE FUNCIONES"
    echo "=================================="
    echo "1. División entera"
    echo "2. Área de círculo"
    echo "3. Perímetro de círculo"
    echo "4. Volumen de esfera"
    echo "5. Área de rectángulo"
    echo "6. Salir"
    echo "=================================="
    echo -n "Selecciona una opción: "
}
main(){
    while true; do
        mostrar_menu
        read opcion
        
        # MENÚ CON IF-ELIF-ELSE en lugar de CASE
        if [ "$opcion" = "1" ]; then
            echo -n "Introduce el dividendo: "
            read dividendo
            echo -n "Introduce el divisor: "
            read divisor
            division_entera $dividendo $divisor
            
        elif [ "$opcion" = "2" ]; then
            echo -n "Introduce el radio: "
            read radio
            area_circulo $radio
            
        elif [ "$opcion" = "3" ]; then
            echo -n "Introduce el radio: "
            read radio
            perimetro_circulo $radio
            
        elif [ "$opcion" = "4" ]; then
            echo -n "Introduce el radio: "
            read radio
            volumen_esfera $radio
            
        elif [ "$opcion" = "5" ]; then
            echo -n "Introduce la base: "
            read base
            echo -n "Introduce la altura: "
            read altura
            area_rectangulo $base $altura
            
        elif [ "$opcion" = "6" ]; then
            echo "¡Hasta luego!"
            exit 0
            
        else
            echo "Opción no válida. Intenta de nuevo."
        fi
        
        echo ""
        echo -n "Presiona ENTER para continuar..."
        read
    done
}