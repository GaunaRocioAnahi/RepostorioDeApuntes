 3. **Comprabacion de la letra**
   
   * **Si la letra esta en la palabra** 
   * Se revela la letra en todas las posiciones de la palabra oculta.
   * Se verifica la condicion de victoria.
   * **Si la letra NO esta en la palabra secreta**
   * Se vuelve a intentar si no se comlpeto con el elemento.
   * Se verifica la condicion de derrota.

  4. **Fin del juego**
   
   * **Condificon de victoria** si la pabra oculta es igual a la palabra secreta.
   *  **Condicion de Derrota** si los intentos llegan a **cero**.
   *  Se muestra un mensaje final al usuario y la palabra secreta. 
*  



<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="descripcion" content=" juego del ahorcado en el que se deben ir introduciendo letras para divinar.">
    <meta name=" robots" content="noindex, follow">
    <title>Juego del ahoracado con JavaScript</title>
    <link rel="stylesheet" href="./style.css">
</head>

<body>
    <div class="container">
        <div class="col"></div>
        <h1>Juego del ahorcado con javascript</h1>
        <p class="hiddenWord"></p>
        <div class="col"></div>
        <p>Introduzca una letra:</p>
        <input type="text"><br>
        <button>Comprobar</button>
    <script src="javascript.js">
    </script>
</body>

</html>








csss






container {
    margin: auto;
    max-width: 700px;
    display: flex;
}



Entonos de desarrollo: 14/02/2026:


* Averiguar Notion y ver videos organizar y ver de que se trata y como utilizarlo. 

* Repasar JSDocs. 
  
# oraciones claves para Identificar relaciones


Si el texto dice... "X es un tipo de Y" / "X e Y son Z"
Relación,   Herencia
Símbolo    Flecha triangular vacía ($\rightarrow$)

si el texto dice "X está compuesto por Y" / "Si muere X, muere Y"
relacion Composición
Simbolo: Rombo Negro (◆) en el Todo

si el textp dice:"X tiene uno o varios Y" / "X está formado por Y"
relacion: Agregación
simbolo: Rombo Blanco (◇) en el Todo

si el texto dice: "X se relaciona con Y" / "X pertenece a Y"
relacion: Asociacion.
simbolo linea simple
si el texto dice: "X usa puntualmente a Y" / "X necesita a Y para un método"
relacion: Dependencia linea discontinua con flecha






La frase de "Propiedades Comunes"
El texto menciona que varios objetos comparten datos, pero no menciona al "padre" como algo que funcione de forma independiente.

Frase: "Tanto los Enemigos como los Personajes comparten un nivel de energía, posición y capacidad ofensiva..."

Identificación: Aquí el enunciado no te da el nombre del padre, pero te está obligando a crear una clase abstracta (por ejemplo, SerVivo o Ente) para no repetir atributos.

3. La frase de "Inexistencia de Instancia"
A veces el texto es muy directo y te dice que el concepto general no se registra por sí solo.

Frase: "No se pueden realizar préstamos de Material genérico; todo préstamo debe ser de un Libro o un Periódico."

Identificación: Si "no se puede" crear el objeto genérico, es {abstract}.