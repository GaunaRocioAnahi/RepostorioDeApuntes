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


  