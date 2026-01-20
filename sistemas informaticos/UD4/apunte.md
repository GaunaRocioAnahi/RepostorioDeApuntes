#SSH
para usar `sudo apt install openssh-server`
para `ifcong`


192.168.1.205 IP jorge.
`sudo service ssh status`


script para apagar
 crear un directorio con un script con sudo shutdown 
```bash
#!/bin/bash

sudo shutdown -h now
```
para pararlo

```bash
etc/ssh 
cd ssh
ls
sudo nano sshd_config
```
luego en usuario vamos a quitarle la almohadilla 
Password authentication no 
para no conectarse por contraseña al otro ordenador. 


para meternos en la terminal del otro ordenador seria : 
en:

``` bash
 administrador$ scp `log2.txt alumnoT@192.168.1.IP`: ruta ejemplo /home/alumnoT/Descargas
 ```

 te despues te pide el password: 


TCP. tiene 4 capa, la mas de abajo es la que esta cerca de hardware.

- (la de mas abajo mas cercada al hardware) Capa fisica. : se encarga de enviar. cables nodos. se encarga de la conexion, que funcione. para poder leer. 

- Capa de red.: Encargada de interactual con la red. tranmision de paquetes y enrutamiento a traves de multiples redes.

- Capa transporte.: define como va a hacer la conexion. si es TCP O UDP. orientada a transmision.
-  
- Capa de aplicacion. : Proporciona servicios de la red a la aplicaciones del usuario(HTTP, FTP, SSH).





Ejericio 2. 
TRAMA A PAQUETES.
mas abajo de las capas mas espacio cabe. (mas grande); 