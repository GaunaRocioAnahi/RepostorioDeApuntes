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
sudo useradd -m -g <grupo> <nombre_usuario> ó
sudo useradd -b /home <nombre_usuario> 
```
 para ponerle contraseña debemos poner el siguiente comando.

 ```bash
sudo passwd <nombre_usuario>
```
lo cual la terminal nos va a arrojar el espacio para agregar la contraseña dos veces.

para verificar si existe el usuario.
```bash
id <nombre_usuario> ó
cat /etc/passwd 
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







`chgrp` cambia de grupo. (Change Group. Cambia solo el grupo del archivo)
ejemplo : `cherp **marketing** ` `informe.doc`

**elimina usuario** = `deluser`  ** ---remover - home** (juan)

**modifica el usuario** = `usermod` ** - l ** juanperez <nombre_nuevo>



**elimina grupo** `grupode1` <grupo_a _eliminar>




```bash
sudo chgrp <nuevo grupo>  a modificar
```

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
cada octal son 3 letras RWX, la cual la r=4 w=2 x=1 eso tenemos en total la suma que nos habilita los permisos.. en este caso tiene todo entonces es 7. de un solo octal puede ser de propietario, grupo, y otros

siempre es usuarios | grupos | otros. 

para permisos ejemplo: a=todos| u = user | g = grupo| o= otros
  

  *Dar permiso de ejecución al propietario*
  `chmod u+x mi_script.sh` seguido de `ls -l mi_script.sh` : el archivo de rw- pasa a rwx, para usuario/propietario. 

  *Establecer permisos precisos*
   `chmod 744 mi_script.sh` seguido de `ls -l mi_script.sh`: el propietario tiene rwx,grupo r, otros ---.

   *quitar permisos de escritura al grupo y a otros*
   `chmod go-w mi_script.sh` seguido de `ls -l mi_script.sh`: se agrega w. 
   
   *cambia el propietario* 
   `sudo chown nuevo_usuario mi_script.sh` (asumiendo que nuevo_usuario existe)

   *cambiar el grupo*
   `sudo chgrp nuevo_grupo mi_script.sh` (asumiendo que nuevo_grupo existe): la comuna del grupo debe mostrar `nuevo_grupo`
   *asignar el usuario al grupo nuevo*
   `sudo usermod -aG contabilidad pepe`:Verificación: groups pepe (Debe listar pepe y contabilidad).

   *cambiar el nombre del grupo*
   `sudo groupmod -n cuentas contabilidad`: Verificación: getent group cuentas (El grupo contabilidad ya no debe existir, ahora es cuentas).
   *bloquear la cuenta de usuario*
    `sudo usermod -L pepe` :Verificación: El usuario pepe no podrá iniciar sesión. (Desbloquea con usermod -U pepe).
    *Eliminar usuario y sus archivos* 
    `sudo deluser --remove-home pepe` 
    *Eliminar el grupo*
    `sudo groupdel cuentas`




**Control de caducidad y expiracion: El comando** `chage`

se enfoca en la vida de la contraseña y expiracion de la cuenta.

ejempos:
- listar la caducidad del usuario.. 
`chage` -l usuario muestra la fecha del ultimo cambio, cuando se debe cambiarla de nuevo y cuando expira la cuenta.
- Establecer una fecha de cuetna de expiracion de la cuenta
`change`-E-yyyy-mm-dd <usuario> ejemplo: `chage` -E 2026-01-01 <usuario>. Después de esa fecha, la cuenta es inactiva y usuario no puede iniciar sesión.

- establecer maximos dias 
`chage`-M 90 <usuario> : establecer los dias maximos MAX DAYS. 
usuario debera cambiar esa contraseña cada 90 dias ( sobre escribe el valor globarl /etc/login.defs)

- Dias de advertencia:
 `change` -w 7 <usuario> establecer los dias de advertencia. 
 usuario recibira un aviso 7 dias antes de su contraseña caduque. 


 **Posibles ejercicios**
 1. todos los usuarios debe cambiar su contraseña al iniciar sesion por primera vez.
Forzar el cambio en el primer inicio	`sudo` `passwd` `-e` nuevo_empleado

 2. la cuenta debe expirar automaticamente al iniciar sesion por primera vez.
`sudo` `chage -e` 2026-04-30 nuevo_empleado

 1. la contraseña debe durar un maximo de 120 dias. 
Establecer duración máxima de contraseñasudo chage -M 120 nuevo_empleado

Comando	                  proposito
crontab **-e**	:Editar el archivo de tareas crontab del usuario actual. (¡Es la forma correcta de agregar tareas!)
crontab **-l**	:Listar las tareas cron ya programadas. (Así verificas que se guardó bien).
crontab **-r**	:Eliminar todas las tareas cron del usuario. (¡Úsalo con precaución!)

**crontab** :
Función Principal: Garantiza que las tareas de mantenimiento, copias de seguridad, o como en tu caso, limpieza, se ejecuten de forma automática sin intervención humana.

`tiene 5 campos de tiempo` 
1-minuto 0-59
2-hora 0-23
3-dia del mes 1-31
4- mes 1-12
5-dia de la semana 0-7 (0=7)


ejemplo de verificar `sudo tail` /var/log/limpieza_compartido.log 

ejemplo de verificar el servicio CRON (diagnostico) 
`sudo grep CRON`/var/log/syslog