# APUNTES

 [APUNTES](#apuntes)
- [APUNTES](#apuntes)
  - [¿Que es Git?](#que-es-git)
  - [¿Donde usar Git?](#donde-usar-git)
  - [**Configuracion inicial.**](#configuracion-inicial)
  - [**Comandos para empezar en Git.**](#comandos-para-empezar-en-git)

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



