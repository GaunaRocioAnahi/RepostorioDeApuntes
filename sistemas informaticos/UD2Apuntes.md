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







 0