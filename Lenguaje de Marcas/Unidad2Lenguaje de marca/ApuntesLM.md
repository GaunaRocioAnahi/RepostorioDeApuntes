## Apuntes de Lenguaje de marca

# HTML

 Etiqueta principal:


 ```html 
 <!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=s, initial-scale=1.0">
    <title>titulo</title>
</head>
<body>

</body>
</html>
``` 




Todas las etiquetas tienen una funcion que cumplen funciones especificas.

- Titulos:

   encabezados  **solo uno**



```HTML
<h1> escribimos el titulo correspondiente </h1>
```

- Subtitulo

```HTML
<h2> escribimos el titulo correspondiente </h2>
```
- Parrafos :

  Solo para escribir, una idea concepto o describir un elemento. describe algo.
 ```html
 <p> escribir parrafo</p>
 ```
- Listas:

 *ordenadas*

 Son para seguir una orden de pasos. ejemplos paso a seguir.


 ```html
  <ol> 
    <li>elemnto 1</li>
    <li>elemnto 2</li>
  </ol> 
 ```
 *desordenada*

 El orden no importa, mas usado en una barra de navegacion. 



 ```html
  <ul>
    <li>ELEMENTO1</li>
    <li>ELEMENTO3</li>
    <li>ELEMENTO2</li>
  </ul>
 ```


- Enlaces:
 en el `body` te dirigue a otra pagina. 


si quiero un enlace con una URL, vamos a escribir entre esas comillas de `href` el `https://...`
o `/` pero no es seguro.



```html
<a href =" ">enlaces</a>
```
para ver el enlase en otra pagina o pestaña usa una etiqueta `target= "_blank"`desspues de las comillas del `href` 



 podemos usar en esa <title = " ..." > que es para pasar el raton y se muestre en un cuadrado chico


 - Elemento de bloques y elementos de lineas
   

 
 -imagenes:
 es un etiqueta que se autocierra.


 ```html
<img src = "imagen.jpg" alt="descripcion de imagen" >
 ```
 # TetriSTEM
 ## index.html

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TetriSTEM - El Juego del Orden</title>
</head>
<body>
  <!-- id="inicio" para que el enlace "Volver arriba" pueda apuntar aquí -->
  <header id="inicio">
    <!-- Logo: coloca la imagen en images/logo.png o cambia la ruta -->
    <!-- Agregar imagen del logo: images/logo.png -->
    <img src="images/logo.png" alt="Logo TetriSTEM" style="height:64px;">
    <h1>TetriSTEM</h1>

    <!-- Menú de navegación común -->
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="historia.html">Historia</a></li>
        <li><a href="galeria.html">Galería</a></li>
        <li><a href="jugabilidad.html">Jugabilidad</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <!-- Sección introductoria -->
    <section>
      <h2>Introducción</h2>
      <p>
        TetriSTEM es un videojuego educativo inspirado en el clásico Tetris,
        donde la ciencia del orden y la diversión se encuentran en cada bloque.
        Ordena las piezas, aprende patrones y mejora tu pensamiento espacial.
      </p>
    </section>

    <!-- Sección con lista de piezas -->
    <section>
      <h2>Piezas del juego</h2>
      <p>En TetriSTEM las piezas clásicas son:</p>
      <ul>
        <li>T (T)</li>
        <li>L (L)</li>
        <li>O (Cuadrado)</li>
        <li>Z (Z)</li>
        <li>I (I)</li>
        <li>S (S)</li>
        <li>J (J)</li>
      </ul>
      <!-- Si quieres agregar una imagen ilustrativa de las piezas -->
      <!-- Agregar imagen ilustrativa: images/piezas_tetristem.jpg -->
      <img src="images/piezas_tetristem.jpg" alt="Ilustración de las piezas: T L O Z I S J" style="max-width:100%;height:auto;">
    </section>
  </main>

  <footer>
    <p>&copy; 2025 TetriSTEM. Todos los derechos reservados.</p>
    <p>Contacto: <a href="mailto:info@tetristem.fake">info@tetristem.fake</a></p>
  </footer>
</body>
</html>

``` 

# Historia.html

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>La Historia de TetriSTEM</title>
</head>
<body>
  <header id="inicio">
    <!-- Logo -->
    <!-- Agregar imagen del logo: images/logo.png -->
    <img src="images/logo.png" alt="Logo TetriSTEM" style="height:64px;">
    <h1>La Historia de TetriSTEM</h1>

    <!-- Menú común -->
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="historia.html">Historia</a></li>
        <li><a href="galeria.html">Galería</a></li>
        <li><a href="jugabilidad.html">Jugabilidad</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <!-- Primer artículo: origen del Tetris -->
    <article>
      <h2>Origen del Tetris</h2>
      <section>
        <p>
          El Tetris original fue creado en 1984 por Alexey Pajitnov en la Unión Soviética.
          Su éxito radica en reglas sencillas y una mecánica de encaje de piezas que engancha
          por su combinación de habilidad y estrategia. TetriSTEM nace como una reinterpretación
          educativa de ese clásico, combinando aprendizaje y entretenimiento.
        </p>
      </section>
    </article>

    <!-- Segundo artículo: evolución de TetriSTEM -->
    <article>
      <h2>Evolución de TetriSTEM</h2>
      <section>
        <h3>Versiones y mejoras</h3>
        <p>A continuación se muestran las versiones principales de TetriSTEM:</p>
        <ol>
          <li>v1.0 - Lanzamiento inicial: modo clásico con tutoriales STEM.</li>
          <li>v1.5 - Añadido modo cooperativo y niveles educativos.</li>
          <li>v2.0 - Integración de minijuegos de física y geometría.</li>
          <li>v3.0 - Versión con realidad aumentada para experiencias prácticas.</li>
        </ol>
      </section>
    </article>

    <!-- Enlace interno para volver arriba -->
    <p><a href="#inicio">Volver arriba</a></p>
  </main>

  <footer>
    <p>&copy; 2025 TetriSTEM</p>
    <!-- Enlace externo real sobre la historia del Tetris -->
    <p>Más sobre la historia real del Tetris: 
      <a href="https://es.wikipedia.org/wiki/Tetris" target="_blank" rel="noopener">Wikipedia - Tetris</a>
    </p>
  </footer>
</body>
</html>

```

## galeria.html
 ```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Piezas de TetriSTEM - Galería</title>
</head>
<body>
  <header id="inicio">
    <!-- Logo -->
    <!-- Agregar imagen del logo: images/logo.png -->
    <img src="images/logo.png" alt="Logo TetriSTEM" style="height:64px;">
    <h1>Piezas de TetriSTEM</h1>

    <!-- Menú común -->
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="historia.html">Historia</a></li>
        <li><a href="galeria.html">Galería</a></li>
        <li><a href="jugabilidad.html">Jugabilidad</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section>
      <h2>Galería de piezas</h2>

      <!-- Figura 1 -->
      <figure>
        <!-- Agregar imagen: images/pieza_T.jpg -->
        <img src="images/pieza_T.jpg" alt="Pieza T del TetriSTEM" style="max-width:300px;height:auto;">
        <figcaption>Pieza T: versátil para crear huecos y líneas.</figcaption>
      </figure>

      <!-- Figura 2 -->
      <figure>
        <!-- Agregar imagen: images/pieza_L.jpg -->
        <img src="images/pieza_L.jpg" alt="Pieza L del TetriSTEM" style="max-width:300px;height:auto;">
        <figcaption>Pieza L: útil para esquinas.</figcaption>
      </figure>

      <!-- Figura 3 -->
      <figure>
        <!-- Agregar imagen: images/pieza_O.jpg -->
        <img src="images/pieza_O.jpg" alt="Pieza O del TetriSTEM (cuadrado)" style="max-width:300px;height:auto;">
        <figcaption>Pieza O: bloque estable de 2x2.</figcaption>
      </figure>

      <!-- Figura 4 -->
      <figure>
        <!-- Agregar imagen: images/pieza_I.jpg -->
        <img src="images/pieza_I.jpg" alt="Pieza I del TetriSTEM (línea)" style="max-width:300px;height:auto;">
        <figcaption>Pieza I: perfecta para líneas completas.</figcaption>
      </figure>

      <!-- Apartado con enlaces a imágenes más grandes -->
      <section>
        <h3>Ver imágenes en tamaño completo</h3>
        <ul>
          <li><a href="images/pieza_T_large.jpg" target="_blank" rel="noopener">Pieza T (ampliada)</a></li>
          <li><a href="images/pieza_L_large.jpg" target="_blank" rel="noopener">Pieza L (ampliada)</a></li>
          <li><a href="images/pieza_O_large.jpg" target="_blank" rel="noopener">Pieza O (ampliada)</a></li>
          <li><a href="images/pieza_I_large.jpg" target="_blank" rel="noopener">Pieza I (ampliada)</a></li>
        </ul>
      </section>
    </section>
  </main>

  <footer>
    <p>&copy; 2025 TetriSTEM</p>
    <p>Recursos y más información: 
      <a href="https://tetris.fandom.com" target="_blank" rel="noopener">Tetris Fandom (recursos)</a>
    </p>
  </footer>
</body>
</html>

 ```
 ## jugabilidad.html

 ```html
 <!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TetriSTEM en acción</title>
</head>
<body>
  <header id="inicio">
    <!-- Logo -->
    <!-- Agregar imagen del logo: images/logo.png -->
    <img src="images/logo.png" alt="Logo TetriSTEM" style="height:64px;">
    <h1>TetriSTEM en acción</h1>

    <!-- Menú común -->
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="historia.html">Historia</a></li>
        <li><a href="galeria.html">Galería</a></li>
        <li><a href="jugabilidad.html">Jugabilidad</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <!-- Vídeo de partida/demostración -->
    <section>
      <h2>Vídeo de una partida</h2>
      <!-- Agregar archivo de vídeo: videos/partida_demo.mp4 -->
      <video controls width="640">
        <source src="videos/partida_demo.mp4" type="video/mp4">
        Tu navegador no soporta el elemento <code>video</code>. Puedes descargar el vídeo desde la carpeta "videos/".
      </video>
    </section>

    <!-- Opiniones / testimonios -->
    <section>
      <h2>Opiniones de jugadores</h2>

      <blockquote>
        <p>“Nunca pensé que la geometría pudiera ser tan divertida”.</p>
        <footer>— Jugador anónimo</footer>
      </blockquote>

      <blockquote>
        <p>“TetriSTEM me ayudó a visualizar mejor las rotaciones y simetrías.”</p>
        <footer>— Estudiante de secundaria</footer>
      </blockquote>

      <blockquote>
        <p>“Modo cooperativo: aprendimos a comunicarnos mientras resolvíamos líneas.”</p>
        <footer>— Profesor de tecnología</footer>
      </blockquote>

      <!-- Enlace para descargar el manual en PDF -->
      <!-- Coloca manual_tetristem.pdf en la misma carpeta (o cambia la ruta) -->
      <p><a href="manual_tetristem.pdf" download>Descargar manual de TetriSTEM (manual_tetristem.pdf)</a></p>
    </section>
  </main>

  <footer>
    <p>Contacto: <a href="mailto:soporte@tetristem.fake">soporte@tetristem.fake</a></p>
    <p>&copy; 2025 TetriSTEM. Todos los derechos reservados.</p>
  </footer>
</body>
</html>

 ```



