# RELACIONES 

Identificar las relaciones entre entidades, armar las listas. 

* ejemplo con relaciones de 1 a N... 
la clave primaria de "1" la implemento como clave foranea de "N"

ejemplo:

 en las ralciones vamos a tener de la siguiente manera.


  ejemplos


Proveedor(1) (CUIT_PK, nombre, domicilio, telefono, mail)

 pelicula(N) (cod_pel_PK, titulo, genero, CUIT_Prov_FK. )


Estructura para listas foraneas

N + FK --> 1 + PK ( a tener en cuenta que el + es un ".");

como se estructura con ejemplos claros

Pelicula.CUIT_Prov --> Proveedor.CUIT 

( si 1 tiene mas de 2 PK, sumamos el nombre e identificamos cual es PK y cual es FK. )

En ralacion N:N

Se crea nueva tabla de relacion, 

de esa relacion creamos una ID de la relacion, y de clave foranea implementamos las dos claves de la entidad relacionada.

Ejemplo:
Estructura para listas de foraneas:

Relacion.FK --> entidad1.PK1
Relacion.FK --> entidad2.PK2

O Tambien podemos implementar como los ejemplos dados en la actividad.
 

 En relacion con supraentidades:

![alt text](<Captura de pantalla 2025-11-11 104842.png>)

Relaciones ternarias: 

![alt text](<Captura de pantalla 2025-11-11 105315.png>)