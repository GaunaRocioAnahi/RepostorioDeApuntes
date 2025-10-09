# Comandos basicos de Linux

 ``` bash 
 /home/wsl/proyecto/ejercicios Linux --> es la ruta. 
 busco con pwd.
``` 




```bash
 ls/ bin --> lista todos los archicos bin
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