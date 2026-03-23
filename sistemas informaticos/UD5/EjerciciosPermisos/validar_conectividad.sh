#!/bin/bash


verificar_conectividad() {
    validar_argumentos 1 $# || return 1
    local host="$1"

    # ✅ CORRECCIÓN: separar local de la ejecución del ping
    # así $? captura el exit code real del ping, no el de local
    local resultado_ping
    resultado_ping=$(ping -c 1 -W 2 "$host" 2>/dev/null)

    if [ $? -eq 0 ]; then
        local latencia
        latencia=$(echo "$resultado_ping" | grep -o 'time=[0-9.]*' | cut -d= -f2)
        latencia=$(printf "%.0f" "$latencia")
        echo "$host responde (latencia: $latencia ms)"
        return 0
    else
        echo "$host no responde"
        return 1
    fi
}




borrar
archivos=$( lista_archivos $1 )
rm $archivos

lista_archivos
peso=$(ls -l $1 | awk '{print $5}')
maximo=$(maximo $peso)
archivos=$( ls -l $1 | grep maximo | awk '{print $9}' )
echo $archivos