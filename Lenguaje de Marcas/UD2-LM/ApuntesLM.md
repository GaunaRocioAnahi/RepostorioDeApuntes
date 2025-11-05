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



----
📝 Simulación de Examen: SweetSTEM (Sin Etiquetas)
Ejercicio 1: Página Principal de SweetSTEM (index.html)
Objetivo: Establecer la estructura central y los contenedores principales.

Crea el contenedor básico de un documento web, incluyendo el bloque de metadatos de la página.

Dentro del cuerpo del documento: a. Crea un contenedor para el contenido de encabezado, incluyendo el título más importante de la página: "SweetSTEM". b. Crea un bloque de navegación para la web con enlaces a "Inicio", "Productos", "Ofertas" y "Contacto". c. Crea el contenedor para el contenido central y único de la página. d. Dentro del contenido central, crea una agrupación temática que contenga un texto introductorio y el lema de la tienda. e. Crea el contenedor de cierre de la página con información de derechos de autor y un enlace de correo ficticio.

Ejercicio 2: Catálogo de Productos (productos.html)
Objetivo: Usar figuras, leyendas y listas ordenadas.

Crea un contenedor de encabezado que contenga una imagen que sirva como logo y un título secundario: "Catálogo SweetSTEM".

Crea el contenedor de contenido central. Dentro de él: a. Agrupa al menos 3 elementos de contenido visual de productos. Cada elemento debe incluir la imagen y la leyenda descriptiva del producto. b. Crea una lista donde el orden es importante de los tipos de dulces disponibles: gominolas, caramelos, chocolates, chicles, regalices. c. Incluye un elemento de enlace que apunte a un mapa externo de ubicación y que se abra en una pestaña nueva del navegador.

Ejercicio 3: Promociones Especiales (promociones.html)
Objetivo: Practicar la navegación interna y la agrupación de contenido temático.

Crea un contenedor de encabezado con el título "Ofertas Científicamente Dulces".

Crea el contenedor de contenido central. Dentro de él: a. Crea tres agrupaciones temáticas distintas, cada una con un identificador único (ID) para el contenido (ej. para "Rebajas", "Packs" y "Novedades"). b. Dentro de cada agrupación, incluye el título principal de la promoción (un nivel por debajo del título de la página) y un párrafo con la descripción. c. Al final de cada agrupación, incluye un enlace que, al hacer clic, te lleve de vuelta a la parte superior de la página actual.

Crea un contenedor de cierre que incluya un enlace a redes sociales ficticias.

Ejercicio 4: Video y Opiniones de Clientes (opiniones.html)
Objetivo: Integrar multimedia, citas y enlaces de descarga.

Crea un contenedor de encabezado con el título "Opiniones Dulcemente Científicas".

Crea el contenedor de contenido central. Dentro de él: a. Crea una agrupación temática que muestre la preparación o empaquetado de los dulces. Inserta un elemento de video con controles de reproducción. b. Crea otra agrupación temática para los testimonios. Incluye tres citas extensas de clientes, por ejemplo: "SweetSTEM me ha hecho volver a disfrutar de los experimentos... ¡pero de sabor!". c. Incluye un elemento de enlace configurado para forzar la descarga de un archivo llamado catalogo.pdf.

Crea un contenedor de cierre con información de contacto y derechos reservados.
