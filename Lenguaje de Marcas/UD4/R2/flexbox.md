# Flexbox 
 para usar flexbox primero necesitamos un contenedor: 
 Ejemplo:

 ```css
 .contenedor {
  display: flex;
}

 ```
 Todos los hijos se convierten automaticamente en elementos flexibles. 

 Ejes flexbox:
 Principal : Horizontal por defecto (fila)
 Transversal : vertical por defecto

 `justify-content`alinea el eje principal:
    **flex-star:** se alinean al inicio del contenedor, se agrupan a la isquierda, o arriba si es columna
    **flex-end:** al final del contenedor, pegados al final del contenedor (derecha/abajo)
    **center:** se centran en el contenedor. util para centrar horizontalmente si usar un margin auto.
    **space-between:** primer y ultimo elemento, se pega en el borde el resto se reparte el espacio restante. perfecto para botones de navegacion o barras de botones
    **space-around:**todos los elementos tienen espacio igual alrededor util cuando quieres que cada elemento tenga un colchon a los lados. 
    **space-evenly:**todos los elementos+ los bordes tienen espacios igual, los bordes respetan la misma distancia que entre elementos. 

 `align-items` alinea elementos en el eje transversal:
 **stretch:** Los elementos se estiran para llenar todo el contenedor.Útil para que todos los elementos tengan la misma altura
 **flex-star:**Los elementos se alinean al inicio del eje transversal. Si la fila es horizontal, se alinean arriba
 **flex-end:**Los elementos se alinean al final del eje transversal. Si la fila es horizontal, se alinean abajo
 **center:**Se centran verticalmente. Muy usado para centrar tarjetas, botones o texto dentro de contenedores.
 **baseline:**Se alinean según la línea base del texto. Útil cuando los elementos tienen texto y quieres que la línea de texto quede alineada. 
 `flex-direction` direccion del flujo
  **row:**Elementos en fila, de izquierda a derecha.Es el valor por defecto. Para menús horizontales, barras de navegación, galerías
  ***row-reverse:**Fila invertida, de derecha a izquierda.Cuando quieres invertir el orden visual sin cambiar el HTML.
  **column:**Elementos en columna, de arriba a abajo.Para listas verticales, secciones apiladas.
  **column-reverse:**Columna invertida, de abajo hacia arriba.Para invertir el orden vertical sin tocar el HTML.

