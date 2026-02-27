fibonacci(){
      posicion=$1
    # Usamos posicion para saber cuántas veces tenemos que hacer el bucle
    # Si posicion=7, necesitamos dar 7 pasos en la serie
    
    # Casos especiales: posicion 0 y 1 los sabemos de memoria
    # sin estos casos el bucle fallaría porque no hay "dos anteriores"
    if [ "$posicion" -eq 0 ]; then
        echo 0
        return
    fi
    if [ "$posicion" -eq 1 ]; then
        echo 1
        return
    fi
    
    numero_anterior=0   # esta variable guarda el número de hace dos pasos
    numero_actual=1     # esta variable guarda el número del paso anterior
    contador=2          # empezamos en 2 porque los pasos 0 y 1 ya los sabemos
    
    # Usamos contador para saber en qué paso estamos
    # El bucle para cuando contador llega a posicion
    while [ "$contador" -le "$posicion" ]; do
    
        # Usamos numero_anterior y numero_actual para calcular el siguiente
        numero_siguiente=$((numero_anterior + numero_actual))
        
        # Ahora desplazamos: lo que era actual pasa a ser anterior
        # y lo que acabamos de calcular pasa a ser actual
        numero_anterior=$numero_actual
        numero_actual=$numero_siguiente
        
        # Avanzamos el contador un paso
        contador=$((contador + 1))
    done
    
    # Al salir del bucle, numero_actual tiene la respuesta
    echo $numero_actual
}

fibonacci $1
