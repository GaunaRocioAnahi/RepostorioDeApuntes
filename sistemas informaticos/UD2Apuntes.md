# Apuntes 2da Unidad.

## PT12.
*Creacion de Grupos*

``` bash
sudo groupadd [nombre del grupo]

 ```

 Crea grupos del sistema, los usuarios tendran estos grupos como primarios o secundarios segun el enunciado.

  *Crea usuarios*
 

 ejemplo: 


 ```bash
 sudo useradd -m -d /home/pinche/ -s /bin/bash -g pinche pinchePrincipal echo "pinchePrincipal :134679" | sudo chpasswd
 ```
 - `useradd -m`crea el usuario y su directorio personal ( `-m`)
 - `-d` */home/nombre* fueza la ruta del home.
 - `-s` */bin/bash* define las shell por defecto.
 - `-g` *grupo* establece grupo primario
 - `-G` *grupo1* , *grupo2* añade grupos secundarios.
 - `echo` " *user :pass* "
 | sudo chpasswd, asigna la contraseña de forma no interactiva. 
 #
 volver a escribirlo del chat.











----
 ## **crea grupos**
  En resumen: Crear los grupos primero garantiza que la infraestructura tenga la base de roles lista antes de introducir a los miembros, haciéndolo más limpio y reduciendo pasos posteriores.

 creamos los grupos. con  `sudo`

 ```bash
sudo groupadd <nombre_grupo> 

 ```
crea un nuevo grupo en el sistema.

lo podemos verificar.

```bash
grep <nombre_del_grupo> /etc/group 
```
 si nos da una respuesta, esto nos indica que el grupo se creo correctamente, si no responde es por que no se ha creado grupo. 
 o

 ```bash
getent group <nombre_del_grupo>
 ```

## **crea Usuarios**
  Crea usuario con su grupo correspondiente.
 ```bash
sudo useradd -m -g <grupo> <nombre_usuario>
```
 para ponerle contraseña debemos poner el siguiente comando.

 ```bash
sudo passwd <nombre_usuario>
```
lo cual la terminal nos va a arrojar el espacio para agregar la contraseña dos veces.

para verificar si existe el usuario.
```bash
id <nombre_usuario>
```
el siguiente comando crea la contraseña de ese usuario

```bash
sudo passwd <nombre_del_usuario>
```
verificar usuario creado con su contraseña 

```bash
grep <nombre_de_usuario> /etc/passwd

```
nos devolveria 

```bash
tecnico1:x:1004:1001::/home/tecnico1:/bin/sh
```
**permisos importante** 

Esta es la parte más crítica, donde usarás los comandos `chown` (cambiar propietario/grupo) y `chmod` (cambiar permisos).

el formato `chmod`que utiliza es octal (3 digitos: propietario, grupo, Otros)

- 7(rwx): lectura, escritura y ejecucion/ acceso
- 6(rw-):Lectura y escritura
- 5 (r-x): Lectura y ejecucion/Acceso.
- 4(r--):solo lectura.
- 0(---): sin permisos.

*pedimos o asignamos*

```bash
sudo chown: <nombre_grupo> /opt/compartido/config.

``` 
```bash
sudo chmood 750 /opt/compartido/config 
``` 
para grupo 