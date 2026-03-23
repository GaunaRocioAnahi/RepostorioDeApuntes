## La regla mental

| ¿Qué filtras? | Usas |
|--------------|------|
| Un valor normal | `WHERE` |
| Un COUNT, SUM, AVG | `HAVING` |
```
"más de 2 coches"
→ estás filtrando un COUNT
→ HAVING COUNT() > 2


---
WHERE   →  filtra filas normales
HAVING  →  filtra resultados de funciones de agregación como COUNT, SUM, AVG


---

La regla que debes recordar
El enunciado dice...JOIN que usas
"con sus coches"JOIN → solo los que tienen
"aunque no tengan"LEFT JOIN"
sin coches"LEFT JOIN + IS NULL
---
DESC  →  de mayor a menor  →  "más común", "más caro", "más reciente"
ASC   →  de menor a mayor  →  "más barato", "más antiguo", "primero"

--- 
La regla simple

Si el enunciado te pide ordenar, clasificar o encontrar el mayor/menor → ORDER BY

---

Palabras que indican ORDER BY
Si el enunciado dice...  Lo que necesitas
"más común"---->ORDER BY COUNT() DESC"
más caro / barato"--->ORDER BY precio DESC/ASC
"mayor / menor"--->ORDER BY columna DESC/ASC
"más reciente"--->ORDER BY fecha DESC
"más antiguo"--->ORDER BY fecha ASC
"ranking de"--->ORDER BY columna DESC
"top X"---> ORDER BY + LIMIT X

---
El patrón que debes memorizar

El enunciado dice... --->JOIN que usas

"solo los que tienen" --> JOIN

"incluye todos los X" --> LEFT JOIN con X en el FROM

"sin ningún X asociado" --> LEFT JOIN + IS NULL

"nombre y apellido" -->CONCAT(nombre, ' ', apellido)



Resumen visual
```
¿Cómo sé qué va en el ON?
          ↓
Busco la columna que se repite en las dos tablas
          ↓
tabla1.id_algo = tabla2.id_algo



El truco mental para el ON

Cuando no sabes cómo conectar dos tablas:

**Paso 1** - Mira qué columnas tienen en común:
```
comics      tiene → id_autor
autores     tiene → id_autor
→ ON comics.id_autor = autores.id_autor
```

**Paso 2** - Si no tienen columna en común necesitas una tabla puente:
```
clientes  no tiene nada de comics
comics    no tiene nada de clientes
→ necesitas pedidos y detalle_pedido como puente



















----

1-
```SQL
SELECT comics.titulo,
       CONCAT(autores.nombre, ' ', autores.apellido) AS nombre_autor,
       autores.pais_origen
FROM comics
JOIN autores ON comics.id_autor = autores.id_autor;

```
-2
SELECT CONCAT(clientes.nombre, ' ', clientes.apellido) AS nombre_cliente,
       pedidos.id_pedido,
       pedidos.fecha
FROM pedidos
JOIN clientes ON pedidos.id_cliente = clientes.id_cliente;

3-
SELECT proveedores.nombre AS proveedor,
       comics.titulo
FROM proveedores
JOIN comics ON proveedores.id_comic = comics.id_comic;

4-

SELECT comics.titulo,
       editoriales.nombre AS editorial
FROM comics
LEFT JOIN editoriales ON comics.id_editorial = editoriales.id_editorial;

5-
SELECT CONCAT(clientes.nombre, ' ', clientes.apellido) AS nombre_cliente,
       comics.titulo,
       detalle_pedido.cantidad,
       detalle_pedido.precio_total
FROM clientes
LEFT JOIN pedidos ON clientes.id_cliente = pedidos.id_cliente
LEFT JOIN detalle_pedido ON pedidos.id_pedido = detalle_pedido.id_pedido
LEFT JOIN comics ON detalle_pedido.id_comic = comics.id_comic;

6-
SELECT comics.titulo
FROM comics
LEFT JOIN personajes ON comics.id_comic = personajes.id_comic
WHERE personajes.id_personaje IS NULL;

7-

SELECT CONCAT(autores.nombre, ' ', autores.apellido) AS nombre_autor,
       comics.titulo
FROM autores
LEFT JOIN comics ON autores.id_autor = comics.id_autor
WHERE comics.titulo IS NULL 
   OR comics.id_comic IN (SELECT id_comic FROM comics WHERE titulo LIKE '%Superhéroes%');

8-

SELECT CONCAT(clientes.nombre, ' ', clientes.apellido) AS nombre_cliente,
       COUNT(pedidos.id_pedido) AS total_pedidos
FROM clientes
LEFT JOIN pedidos ON clientes.id_cliente = pedidos.id_cliente
GROUP BY clientes.id_cliente;
9-
SELECT personajes.nombre AS personaje,
       comics.titulo
FROM personajes
LEFT JOIN comics ON personajes.id_comic = comics.id_comic;

10-
SELECT proveedores.nombre AS proveedor,
       comics.titulo
FROM proveedores
LEFT JOIN comics ON proveedores.id_comic = comics.id_comic;

11-
SELECT CONCAT(clientes.nombre, ' ', clientes.apellido) AS nombre_cliente,
       pedidos.id_pedido,
       pedidos.fecha
FROM pedidos
LEFT JOIN clientes ON pedidos.id_cliente = clientes.id_cliente;














