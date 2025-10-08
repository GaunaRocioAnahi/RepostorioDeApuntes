# Raiz de un xml para un xsd





 Esta es la etiqueta raiz que necesita un xml para vinxular a un xsd





``<?xml version="1.0" encoding="UTF-8"?>``




 Despues de dicha linea necesaria debemos poner la raiz del XML
 en este caso el "persona" es un ejemplo y luego siempre va lo mismo
 vinculado ultimamente con "xsi:noNamespaceSchermaLocation =" "nombre del archivo en xsd"




``` 
<persona xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xsi:noNamespaceSchemaLocation="--.xsd">
 
<nombre>...</nombre>
   
<edad>...</edad>

</persona>

```
* "Tener en cuenta el enunciado. que requiere. si me dicen ejemplo un almacen tiene producto con id blabla... hacer un padre con el nombre productos y luego producto, al igual que si dice cada producto tiene su cliente, hacer una raiz con un padre clientes y luego cliente "

* **fijarte cerrar todas las palabras que sean necesarias**




