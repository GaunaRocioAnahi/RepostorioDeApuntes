# Comandos basicos de Linux

``pwd`` — muestra directorio actual.

``ls`` — lista archivos (usa ``ls -la`` para ver ocultos y permisos).

``cd`` *<ruta>* — cambiar de directorio. (``cd`` = home).

``mkdir -p`` *ruta/desde/a/hasta* — crear directorios (con ``-p`` crea padres si faltan).

``touch`` *archivo* — crear archivo vacío o actualizar su timestamp.

``cp`` *origen destino* — copiar archivo. ``cp -r`` origen destino copia directorio recursivamente.

``mv`` *origen destino* — mover o renombrar.

``rm`` *archivo* — eliminar archivo. ``rm -r dir`` elimina directorio recursivamente. ``rm -f`` fuerza.

``cat`` *archivo* — mostrar contenido. ``less`` *archivo* o ``more`` *archivo* para navegar.

``head`` *-n 10 archivo* — primeras 10 líneas. ``head`` *-n 2 archivo* — primeras 2.

``tail`` *-n 10 archivo* — últimas 10 líneas.

``tree`` — muestra estructura de árbol (si no está instalado usa ``ls -R``).
``~`` es el home. la ruta correcta.
 
 ``echo``   > *archivo* escribe el achivo cuando lo señalamos
 ``nano`` *archivo* me habre un centro de edicion para el archivo
 ``cat`` *archivo* me meustra el contenido del archivo. sin necesidad de abrirlo  

 
## ``find`` explicacion 

 `` find`` es muy flexible, la sintaxis es 

 ```bash
 find <ruta> <condicion> -print
```
  **condiciones**
  * ``-type f`` ficheros o ``-type d`` directorios.
  * ``-name`` *".conf"* 
  * ``-iname`` ignora mayusculas/ minusculas 
  * ``-size`` *+5k * mayor, ``-size`` *-5k* menor 
  * ``-size +1M -size -5M`` mayor que 1MB y menor que 5MB.
  * ``-mtime`` *-7* modificado en los ultimos 7 dias (-mtime +30 modificado hace as de 30 dias) y con ``-mmin`` es para las horas o minutos 
  Ejemplo :
  ```bash
 find . -type f -name "*.conf" -size +5k -mtime -7 -print

  ```
```bash
fin . -not -name "*conf*" | wc -l
```  
`` |wc -l `` lo que hace es contar los archivos. en el caso anterior cuenta los archivos encontrados con find y esas caracteristicas

``f`` :archivo normal
``d`` : directorio
``l``: enlace simbolico
``c``dispositivos de caracter
``b`` dispositivo de bloques



 ``` bash 
 /home/wsl/proyecto/ejercicios Linux --> es la ruta. 
 busco con pwd.
``` 


lista todos los archivos bin

```bash
 ls/ bin 
```
para ordenar por fecha o por tamaño 
```bash
 ls -lt/bin     ;   ls -lhs/bin
```
una lista completa de bin
 ```bash
 ls -R
 ```

 para contar cuantos archivos hay 

 ```bash
 ls /bin | wc -l
  ```

Para crear un directorio crea 1 solo
``` bash
 mkdir  Dir1
```
para crear 2  o+  directorio 

``` bash
 mkdir Dir2 Dir3

```
para indicarle la RUTA ejemplo: el ultimo es el directorio al cual hacemos la ruta, encontramos el directorio Dir4 en Dir3 como la ruta nos indica

```bash
 mkdir /home/wsl/Dir3/Dir4 
```


























 ## ordenes de linux con archivos y directorios

1. Crea un archivo de tamaño 0

  ```bash
  touch archivo
  ``` 
2. Listar todos los archivos del directorio ``bin``

``` bash
 ls/bin
```
3. Listar todos los archivos del directorio etcque comienzan por *t* en orden inverso. 
 ```bash
   ls -r/etc/t*
```
4. Listar todos los archivos del directorio devque comienzan por tty y tengan 5 caracteres.
 ```bash
 ls /dev /tyy??
 ```

5.