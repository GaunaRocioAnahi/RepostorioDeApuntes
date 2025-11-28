## Sistemas informaticos.

El objetivo es crear un archivo ejecutable llamado escribir_archivo.sh que reciba el nombre de un archivo de destino y varias palabras, y escriba esas palabras en el destino en orden inverso.


```bash
#Abrir el editor nano
nano escribir_archivo.sh

```
```bash
#!/bin/bash

# 1. Almacenar el nombre del archivo de destino (ej: notas.txt)
ARCHIVO="$1"

# 2. Eliminar $1 de la lista de argumentos, dejando solo las palabras
shift

# 3. Procesar: imprimir palabras, poner cada una en una línea, invertir orden, y guardar en el archivo
echo "$@" | tr ' ' '\n' | tac > "$ARCHIVO"
```
damos permiso de ejecucion. 
` chmod u+x escribir_archivos.sh` ó `chmod x escribir_archivo.sh`
ahora puedes ejecutar el script 
```bash
./escribir_archivo.sh notas.txt lola paco irina pablo
```
comprobamos con cat
```bash
cat notas.txt 

#resultado 
 pablo
 irina
 paco
 lola
```
2.
creamos el archivo devolver_ip.sh

`nano devolver_ip.sh`

```bash
#!/bin/bash

# 1. Validación de argumentos
if [ $# -ne 1 ]; then
    echo "ERROR: Debe proporcionar un nombre de dominio como argumento."
    exit 1
fi

DOMINIO="$1"

# 2. Resolución de la IP usando host y procesamiento con tuberías
IP_OBTENIDA=$(host "$DOMINIO" | grep 'has address' | awk '{print $NF}' | head -n 1)

# 3. Verificación de error de resolución
if [ -z "$IP_OBTENIDA" ]; then
    echo "ERROR: No se pudo resolver la IP para el dominio '$DOMINIO'."
    exit 1
fi

# 4. Guardar el resultado en notas.txt
echo "La direccion IP de ese dominio seria: $IP_OBTENIDA" > notas.txt

echo "IP resuelta: $IP_OBTENIDA. Guardada en notas.txt."
```

damos permiso de ejecucion
 `chmod u+x devolver_ip.sh`

 ejecutamos 
 `./devolver_ip.sh ww.urg.es`
 ``` bash
 echo "La direccion IP de ese dominio seria: $IP_OBTENIDA" > notas.txt
 ```
 ```bash
#!/bin/bash

# 1. Validación de argumentos
if [ $# -ne 2 ]; then
    echo "ERROR: Uso: $0 <número> <palabra_base>"
    exit 1
fi

N=$1
PALABRA_BASE=$2

# 2. Comprobación de paridad: N módulo 2 es igual a 0?
if [ $((N % 2)) -eq 0 ]; then
    # CASO PAR: Crear carpetas con secuencia par
    echo "El número $N es par. Creando carpetas con secuencia par..."
    # seq 2 2 $N -> genera 2 4 6 8...
    for i in $(seq 2 2 "$N"); do
        NOMBRE_CARPETA="${PALABRA_BASE}$i"
        mkdir -p "$NOMBRE_CARPETA"
    done

else
    # CASO IMPAR: Crear archivos con secuencia impar
    echo "El número $N es impar. Creando archivos con secuencia impar..."
    # seq 1 2 $N -> genera 1 3 5 7...
    for i in $(seq 1 2 "$N"); do
        NOMBRE_ARCHIVO="${PALABRA_BASE}$i"
        touch "$NOMBRE_ARCHIVO"
    done
fi

# 3. Mostrar el contenido creado
echo -e "\nContenido creado en la carpeta actual:"
ls -d ${PALABRA_BASE}*
 ```
 damos permisos 
 chmod u+x crear_archivos.sh