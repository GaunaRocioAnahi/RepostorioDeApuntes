# Tienda de Dulces


 ## PRIMER INDEX.HTML

```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>SweetSTEM - Inicio</title>
</head>
<body>
  <header id="inicio">
    <!-- Logo (si quieres una imagen del logo, agrégala aquí) -->
    <!-- Agregar imagen del logo: images/logo.png -->
    <img src="images/logo.png" alt="Logo SweetSTEM" style="height:60px;">
    <h1>SweetSTEM</h1>

    <!-- Menú de navegación común -->
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="productos.html">Productos</a></li>
        <li><a href="promociones.html">Ofertas</a></li>
        <li><a href="opiniones.html">Contacto / Opiniones</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section>
      <h2>Sobre SweetSTEM</h2>
      <p>SweetSTEM es un kiosco de dulces donde el sabor y la ciencia se mezclan en cada dulce. Combina recetas tradicionales con presentaciones inspiradas en la tecnología para despertar la curiosidad de grandes y pequeños.</p>
      <p><em>Lema:</em> "Donde el sabor y la ciencia se mezclan en cada dulce".</p>

      <!-- Aquí puedes agregar una imagen representativa de la tienda -->
      <!-- Agregar imagen representativa: images/tienda.jpg -->
      <img src="images/tienda.jpg" alt="Interior de SweetSTEM" style="max-width:100%;height:auto;">
    </section>
  </main>

  <footer>
    <p>&copy; <span id="year">2025</span> SweetSTEM. Todos los derechos reservados.</p>
    <p>Contacto: <a href="mailto:contacto@sweetstem.fake">contacto@sweetstem.fake</a></p>
  </footer>
</body>
</html>

```
 ## 2DO Producto.html


 ```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>SweetSTEM - Catálogo de Productos</title>
</head>
<body>
  <header>
    <!-- Logo -->
    <!-- Agregar imagen del logo: images/logo.png -->
    <img src="images/logo.png" alt="Logo SweetSTEM" style="height:60px;">
    <h1>Catálogo SweetSTEM</h1>

    <!-- Menú de navegación común -->
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="productos.html">Productos</a></li>
        <li><a href="promociones.html">Ofertas</a></li>
        <li><a href="opiniones.html">Contacto / Opiniones</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section id="catalogo">
      <h2>Productos Destacados</h2>

      <!-- Figura producto 1 -->
      <figure>
        <!-- Agregar imagen del producto 1: images/producto1.jpg -->
        <img src="images/producto1.jpg" alt="Gominolas SweetSTEM" style="max-width:300px;height:auto;">
        <figcaption>Gominolas científicas - caja de 200g</figcaption>
      </figure>

      <!-- Figura producto 2 -->
      <figure>
        <!-- Agregar imagen del producto 2: images/producto2.jpg -->
        <img src="images/producto2.jpg" alt="Caramelos SweetSTEM" style="max-width:300px;height:auto;">
        <figcaption>Caramelos experimentales - paquete surtido</figcaption>
      </figure>

      <!-- Figura producto 3 -->
      <figure>
        <!-- Agregar imagen del producto 3: images/producto3.jpg -->
        <img src="images/producto3.jpg" alt="Chocolate SweetSTEM" style="max-width:300px;height:auto;">
        <figcaption>Chocolate con motivos STEM</figcaption>
      </figure>

      <h3>Tipos de chuches disponibles</h3>
      <ol>
        <li>Gominolas</li>
        <li>Caramelos</li>
        <li>Chocolates</li>
        <li>Chicles</li>
        <li>Regalices</li>
        <li>Y más sorpresas...</li>
      </ol>

      <p>
        <!-- Enlace externo a un mapa (abre en nueva pestaña). Reemplaza la URL por la del mapa real si la tienes -->
        <a href="https://www.google.com/maps" target="_blank" rel="noopener">Ver mapa: ubicación de la tienda</a>
      </p>
    </section>
  </main>

  <footer>
    <p>&copy; 2025 SweetSTEM</p>
    <p>Contacto: <a href="mailto:contacto@sweetstem.fake">contacto@sweetstem.fake</a></p>
  </footer>
</body>
</html>

 ```



 ## Promociones.html

 ```html
 <!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>SweetSTEM - Ofertas Científicamente Dulces</title>
</head>
<body>
  <header>
    <!-- Agregar imagen del logo: images/logo.png -->
    <img src="images/logo.png" alt="Logo SweetSTEM" style="height:60px;">
    <h1>Ofertas Científicamente Dulces</h1>

    <!-- Menú de navegación común -->
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="productos.html">Productos</a></li>
        <li><a href="promociones.html">Ofertas</a></li>
        <li><a href="opiniones.html">Contacto / Opiniones</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <!-- Sección Rebajas -->
    <section id="rebajas">
      <h2>Rebajas</h2>
      <p>Descuentos de hasta el 30% en productos seleccionados del mes. Combos inspirados en experimentos para los pequeños científicos.</p>
      <p><a href="#inicio">Volver arriba</a></p>
    </section>

    <!-- Sección Packs -->
    <section id="packs">
      <h2>Packs</h2>
      <p>Packs especiales para fiestas temáticas: incluye decoración y material educativo relacionado con la ciencia.</p>
      <p><a href="#inicio">Volver arriba</a></p>
    </section>

    <!-- Sección Novedades -->
    <section id="novedades">
      <h2>Novedades</h2>
      <p>Presentamos nuevos sabores y envases con circuitos comestibles inspirados en tecnología.</p>
      <p><a href="#inicio">Volver arriba</a></p>
    </section>
  </main>

  <footer>
    <p>&copy; 2025 SweetSTEM</p>
    <p>Síguenos en nuestras redes (ficticias): 
      <a href="https://facebook.com/sweetstem" target="_blank" rel="noopener">Facebook</a> |
      <a href="https://instagram.com/sweetstem" target="_blank" rel="noopener">Instagram</a> |
      <a href="https://twitter.com/sweetstem" target="_blank" rel="noopener">Twitter</a>
    </p>
  </footer>
</body>
</html>

 ```
  ## Opiniones.html


  ```html
  <!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>SweetSTEM - Opiniones Dulcemente Científicas</title>
</head>
<body>
  <header>
    <!-- Agregar imagen del logo: images/logo.png -->
    <img src="images/logo.png" alt="Logo SweetSTEM" style="height:60px;">
    <h1>Opiniones Dulcemente Científicas</h1>

    <!-- Menú de navegación común -->
    <nav>
      <ul>
        <li><a href="index.html">Inicio</a></li>
        <li><a href="productos.html">Productos</a></li>
        <li><a href="promociones.html">Ofertas</a></li>
        <li><a href="opiniones.html">Contacto / Opiniones</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section id="video">
      <h2>Vídeo: Preparación y embalaje</h2>
      <!-- Agregar archivo de vídeo: videos/preparacion.mp4 -->
      <video controls width="640">
        <source src="videos/preparacion.mp4" type="video/mp4">
        Tu navegador no soporta el elemento <code>video</code>.
      </video>
    </section>

    <section id="testimonios">
      <h2>Testimonios</h2>

      <blockquote>
        <p>"SweetSTEM me ha hecho volver a disfrutar de los experimentos... ¡pero de sabor!"</p>
        <footer>— Cliente feliz</footer>
      </blockquote>

      <blockquote>
        <p>"Los packs para fiestas fueron un éxito: originales y deliciosos."</p>
        <footer>— Organizadora de eventos</footer>
      </blockquote>

      <blockquote>
        <p>"Un rincón donde mis hijos aprenden y saborean la ciencia."</p>
        <footer>— Madre satisfecha</footer>
      </blockquote>

      <p>
        <!-- Enlace para descargar el catálogo -->
        <a href="catalogo.pdf" download>Descargar catálogo completo (catalogo.pdf)</a>
      </p>
    </section>
  </main>

  <footer>
    <p>Contacto: <a href="mailto:contacto@sweetstem.fake">contacto@sweetstem.fake</a></p>
    <p>&copy; 2025 SweetSTEM. Todos los derechos reservados.</p>
  </footer>
</body>
</html>

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