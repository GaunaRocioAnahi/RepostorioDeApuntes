```bash
-eq   # equal, igual
-ne   # not equal, distinto
-lt   # less than, menor que
-gt   # greater than, mayor que
-le   # less or equal, menor o igual
-ge   # greater or equal, mayor o  igual

```

`>&2` manda mensaje de error.

` return 1` significa que algo salió mal. `return 0` significa éxito. Es una convención de bash: 0 = bien, cualquier otro número = error.


```bash
-w   # writable, tiene permiso de escritura
-r   # readable, tiene permiso de lectura
-x   # executable, tiene permiso de ejecución
-e   # exists, existe (fichero o directorio)
-f   # file, es un fichero
-d   # directory, es un directorio
-z   # zero, el texto está vacío
-n   # not zero, el texto no está vacío

```

```bash

-type f        # solo ficheros, no directorios
-type d        # solo directorios
-name "*.txt"  # que el nombre coincida con el patrón
-size +500c    # mayor que 500 bytes (c = bytes)
-size -500c    # menor que 500 bytes

```

El `+` antes del tamaño significa "mayor que". Sin espacio entre `+` y el número, si no bash lo parte en dos argumentos y `find` falla.

```bash
if [ -z "$resultados" ]; then

#comprueba si una variable si una variable esta vacia. si find no encontro nada, $resultados estara vacia y entramos aqui.  
```
```bash
local fecha=$(date +%Y%m%d_%H%M%S)
#Variable de fecha 
%Y   # año con 4 dígitos:  2026
%m   # mes con 2 dígitos:  02
%d   # día con 2 dígitos:  27
%H   # hora con 2 dígitos: 12
%M   # minutos:            44
%S   # segundos:           33
# resultado: 20260227_124433
```


copia de ficheros 
```bash

cp -r -- "$archivo" "$nuevo_nombre"


```

tamanio de directorio 

```bash
local bytes=$(du -sb "$directorio" | cut -f1)

#`du` mide el espacio usado. 
#`-s` da el total del directorio completo (sin listar cada fichero).
# -b da el resultado en bytes. 
#El | es una tubería: manda la salida de du como entrada a cut. 
#cut -f1 recorta y se queda solo con la primera columna (el número), descartando la ruta.


```


convierte los bits a bytes con una variable. 

```bash
local bits=$(( bytes * 8 ))

```
 variable que busca archivos grandes 
```bash
local bytes=$(( megas * 1024 * 1024 ))

```
$(()) es la forma de hacer aritmetica en bash. Sin los dobles parentesis bash trataria todo como texto y no haria multplicadacion.





