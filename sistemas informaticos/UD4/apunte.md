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