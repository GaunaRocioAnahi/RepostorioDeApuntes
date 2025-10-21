# APUNTES

 [APUNTES](#apuntes)
- [APUNTES](#apuntes)
  - [¿Que es Git?](#que-es-git)
  - [¿Donde usar Git?](#donde-usar-git)
  - [**Configuracion inicial.**](#configuracion-inicial)
  - [**Comandos para empezar en Git.**](#comandos-para-empezar-en-git)
  - [Ejemplo de PT1.](#ejemplo-de-pt1)

## ¿Que es Git?

  Guarda y administra diferentes archivos y codigo.
  
## ¿Donde usar Git?

- Funciona en un ordenador como tambien en servicios en linea, Como:
  
- GitHub
  
- GitLab
  
- etc
  
## **Configuracion inicial.**

- `git config --global user.name "tu nombre"`
  
   *configura tu nombre de usuario.*

- `git config --global user.email "tuemail@example.com"`  
  *Configura tu correo electrónico.*  

- `git config --list`
  
  *Muestra la configuración actual.*  
 
- `--global` sirve para la configuracion de todo repositorio creado, si no se aplica la configuracion solo se aplicara a tu respositorio local actual.
---

## **Comandos para empezar en Git.**
 - configuracion inicial de Git
 ```git config --global user.name "Tu Nombre"
git config --global user.email "tuemail@ejemplo.com" 
``` 


  
- `git config --list` : verificacion de la configuracion de usuario, para comprobar que nombre y correo electronico sea configurado correctamente. se ve como. 
  ```
  user.name=Juan Pérez
  user.email=juan.perez@ejemplo.com 
  ```
si tu configuracion de correo o nombre es incorrecta, vuelve a ejecutar ``git config`` con informacion correcta.


- `git init`: Crea un respositorio.
  
- `git add` : Añade archivos.
  
- `git commit` : Guarda cambios.
- `git commit -m "mensaje"`: Crea un commit con un mensaje definitivo.

- `git push` : para subir cambios a un remoto.
  
- `git clone` :  Descarga un repositorio.
  
- `git clone <URL>` : Cuando se trabaja con un repositorio existente, para descarlos al respositorio remoto. con URL.

- `git status` :para ver el estado.

- `git log` : Muestra el historial de commits del repositorio.
  
- `git checkout` :  "Nombre-rama"  cambia una rama existente. Se posiciona en esa rama.
  
- `git diff` :  muestra los cambios realizados en los archivos.-

- `git branch` : me crea ramas

- `git log`te permite ver el historial de confirmaciones en tu repositorio. Esto incluye información como el autor del commit, la fecha y el mensaje 

- puedes agregar opciones para personalizar la salida, como ``git log --oneline ``para ver cada commit en una sola línea, o ``git log --graph`` para visualizar un gráfico de las ramas del proyecto.



----
## Ejemplo de PT1. 

 **#1 repositorio local** 
 usamos el `git config --global con user.email`- y en la siguiente linea `git config --global -- list` para que me liste mi user name introducido y mi user.email.

 **#2 Primer Repositorio Local**
 . nos pide crear un directorio llamado `git-workshop`
 lo creamos con `mkdir`que justamente crea directorios.
 ```bash
 mkdir git-workshop
 ```
 creamos el repositorio en el directorio anteriormente mencionado con el comando 
 ´´´bash
  git init
 ```
  ahora creamos dos directorios. uno llamado README.md y otro jose.txt. de la siguietne manera con `touch`.
  ```bash
  touch README.md jose.txt
  ```
  luego se agrega esos cambios al staging area y se puede agregar el primer commit del respositorio.
  ```bash
  git add . 
  ``` 
  con el punto me dice que toma todos los archivos.
  para realizar el primer commit

  ```bash
 git commit -m "mensaje descriptivo y nombre en infinitivo"
  ```
  **#3 correcciones basicas**
para cambiar el nombre de un archivo.
y asi reescribir el commit anterior 
 ```bash
 mv jose.txt. rocio.txt
 ```
 luego tenermos que borrarlo de manera definitiva el archivo que cambio de nombre  con:
 ```bash
 git rm jose.txt
 ```

 luego hace el `git add` . , luego hacer el `git commit -m" mensaje"`

**#4 crea una rama**
se cambia a la rama y se posiciona en ella.
```bash
git checkout -b nombre de la rama
``` 
 me pide que mientras este en esta rama actual, modifique el archivo con mi nombre `rocio.txt`

 ```bash 
 git echo "hola mundo" > rocio.txt
 ```
vuelvo a añadir el `git add rocio.txt`
luego el commmit
`git commit -m" mensaje "`
luego me dice que regrese al primer commit del respositorio usando `git checkout master` , creamos otra rama llamada taller-info y nos cambiamos a ella 
```bash
git checkout -b taller-info
```
vuelve a escribir algo en el README.md

```bash
echo " hola mundo soy README.MD" > REAMDE.md
```


