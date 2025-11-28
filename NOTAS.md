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