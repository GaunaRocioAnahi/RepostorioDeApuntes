menu_pruebas() {
    # Paso 1: Creamos la variable vacía antes de empezar
    local opcion=""

    # Paso 2: El bucle gira MIENTRAS la opción NO sea "0" (!= significa diferente)
    while [ "$opcion" != "0" ]; do
        
        # Pintar el menú
        echo "========================================="
        echo "       MENÚ DE PRUEBAS DEL SCRIPT        "
        echo "========================================="
        echo "1. Crear directorio"
        echo "2. Buscar archivos grandes"
        echo "3. Buscar por extensión"
        echo "4. Cambiar permisos"
        echo "5. Obtener propietario"
        echo "6. Respaldo"
        echo "7. Tamaño de directorio"
        echo "8. Puerto abierto"
        echo "9. Verificar conectividad"
        echo "0. SALIR"
        echo "========================================="
        
        # Leer la opción elegida
        read -p "Elige un número (0-9): " opcion

        # La cadena de decisiones (if - elif - else)
        if [ "$opcion" = "1" ]; then
            read -p "Escribe la ruta del nuevo directorio: " arg1
            crear_directorio "$arg1"
            
        elif [ "$opcion" = "2" ]; then
            read -p "Escribe la ruta a buscar: " arg1
            read -p "Escribe el tamaño en MB: " arg2
            buscar_archivos_grandes "$arg1" "$arg2"
            
        elif [ "$opcion" = "3" ]; then
            read -p "Escribe la ruta a buscar: " arg1
            read -p "Escribe la extensión (ej: txt): " arg2
            read -p "¿Quieres contar? (Escribe -c o déjalo en blanco): " arg3
            buscar_por_extension "$arg1" "$arg2" "$arg3"
            
        elif [ "$opcion" = "4" ]; then
            read -p "Escribe los permisos (ej: 644): " arg1
            read -p "Escribe el nombre del archivo: " arg2
            cambiar_permisos "$arg1" "$arg2"
            
        elif [ "$opcion" = "5" ]; then
            read -p "Escribe el nombre del archivo a investigar: " arg1
            obtener_propietario "$arg1"
            
        elif [ "$opcion" = "6" ]; then
            read -p "Escribe el archivo para hacerle respaldo: " arg1
            respaldo "$arg1"
            
        elif [ "$opcion" = "7" ]; then
            read -p "Escribe la ruta del directorio a pesar: " arg1
            tamaño_directorio "$arg1"
            
        elif [ "$opcion" = "8" ]; then
            read -p "Escribe el host (ej: ejemplo.com): " arg1
            read -p "Escribe el puerto (ej: 80): " arg2
            puerto_abierto "$arg1" "$arg2"
            
        elif [ "$opcion" = "9" ]; then
            read -p "Escribe el host a hacer ping (ej: 8.8.8.8): " arg1
            verificar_conectividad "$arg1"
            
        elif [ "$opcion" = "0" ]; then
            # ¡MAGIA! Aquí ya NO ponemos 'break'. 
            # Solo nos despedimos. Al volver arriba, el 'while' se apagará solo.
            echo "¡Saliendo del programa. Hasta pronto!"
            
        else
            # Atrapa cualquier cosa que no sea del 0 al 9
            echo "Error: Opción no válida. Por favor, elige un número del 0 al 9."
        fi
        
        # Una línea vacía para que no se amontone el texto en la pantalla
        echo "" 
    done
}

# Encendemos el menú
menu_pruebas