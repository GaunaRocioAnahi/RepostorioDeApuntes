# Apuntes :
Si la oración dice...	Tú utilizas...
* "Muéstrame", "Lista", "Selecciona", "Dime los nombres"	`[SELECT]`
* "Sin repetidos", "Valores únicos", "Diferentes"	`[DISTINCT]`
* "Que sean de...", "Mayores a...", "Donde el precio sea..."	`[WHERE]`
* "Que esté en esta lista", "Que sea uno de estos valores"	`[IN]`
* "Ordenado por...", "Del más caro al más barato", "Alfabético"	`[ORDER BY]`
* "Los primeros 5", "El top 10", "Solo dame X resultados"	`[LIMIT]`
* "Saltar los primeros...", "A partir del número X"	`[OFFSET]`
* "Cuantos hay", "Suma total", "Promedio de"	Funciones Agregadas `[(COUNT, SUM, AVG)]`
* "Agrupado por", "Por cada categoría", "Por cliente","media de...", "por cada...", "provincia con mayor media".	`[GROUP BY]`
* "Donde el total (o promedio) sea mayor a..." (Filtrar grupos)	`[HAVING]`
* "Largo del texto", "Cuantos caracteres tiene"	`[CHAR_LENGTH]`

 para having. 
 * si filtro por un dato que ya existe en la tabla. ej nombre, fecha, ciudad, uso un `WHERE`
 * si filtras por el resultado de una operacion matematica o agreupacion ej. suma total, el promedio, la cantidad de veces. se usa `HAVING`. si tiene un SUM, COUNT, AVG, MAX, MIN. obligatoriamente va en el `HAVING` 





















1. Dime el nombre y apellido de los cinco malagueños de más edad. Filtramos por Málaga, ordenamos por edad descendente (de mayor a menor) y cortamos en 5.

```SQL
SELECT nombre, apellido 
FROM personas 
WHERE provincia = 'Málaga' 
ORDER BY edad DESC 
LIMIT 5;
```

2. Dime el máximo de ingresos anuales que tiene una persona con estudios primarios. Usamos MAX() para buscar el valor más alto, filtrando por estudios.

```SQL
SELECT MAX(ingresos_anuales) 
FROM personas 
WHERE estudios = 'Primarios';
```
3. Dime la edad media de las personas cuya ocupación comience por la letra A. Usamos AVG() para el promedio y LIKE 'A%' para que empiece por A.

``` SQL 
SELECT AVG(edad) 
FROM personas 
WHERE ocupacion LIKE 'A%';
```
4. 4. Dime las 3 primeras letras del estado civil de las personas de Dos Hermanas. Usamos SUBSTRING (o LEFT) para cortar el texto.
   
```SQL
SELECT DISTINCT SUBSTRING(estado_civil, 1, 3) 
FROM personas 
WHERE municipio = 'Dos Hermanas';
```
5.Cuenta el número de personas que son padre siendo mujer o madre siendo hombre. Esto parece una búsqueda de errores en los datos.

```SQL
SELECT COUNT(*) 
FROM personas 
WHERE (sexo = 'Mujer' AND rol = 'Padre') 
   OR (sexo = 'Hombre' AND rol = 'Madre');
```

6.6. Dime la moda del estado civil. La "moda" es el valor que más se repite. Agrupamos por estado civil, contamos cuántos hay y nos quedamos con el número 1.

```SQL

SELECT estado_civil 
FROM personas 
GROUP BY estado_civil 
ORDER BY COUNT(*) DESC 
LIMIT 1;
```

7.Dime cuántos municipios diferentes de la provincia de Cádiz aparecen. Usamos DISTINCT dentro del conteo para no contar repetidos.
```SQL
SELECT COUNT(DISTINCT municipio) 
FROM personas 
WHERE provincia = 'Cádiz';
```
8. Dime la media de ingresos anuales agrupada por estado civil.

SQL
SELECT estado_civil, AVG(ingresos_anuales) 
FROM personas 
GROUP BY estado_civil;
11. Dime la media de número de hijos por mujer.

SQL
SELECT AVG(numero_hijos) 
FROM personas 
WHERE sexo = 'Mujer';
12. Dime los 5 granadinos que más cobran ordenados por la longitud en letras de su ocupación. Ojo aquí: Primero necesitamos los 5 más ricos (Subconsulta) y luego ordenamos el resultado por la longitud del texto.

SQL
SELECT * FROM (
    SELECT nombre, ocupacion, ingresos_anuales 
    FROM personas 
    WHERE provincia = 'Granada' 
    ORDER BY ingresos_anuales DESC 
    LIMIT 5
) AS top_granadinos
ORDER BY LENGTH(ocupacion);
13. Dime la provincia con menos ingresos anuales de media.

SQL
SELECT provincia 
FROM personas 
GROUP BY provincia 
ORDER BY AVG(ingresos_anuales) ASC 
LIMIT 1;
14. Dime la provincia que tiene a los jubilados con menores ingresos anuales de media. Igual que la anterior, pero filtrando primero por jubilados.

SQL
SELECT provincia 
FROM personas 
WHERE ocupacion = 'Jubilado'
GROUP BY provincia 
ORDER BY AVG(ingresos_anuales) ASC 
LIMIT 1;
15. Dime el municipio con más ingresos anuales sin contar a las personas que no cobran nada. Filtramos los que ganan 0 con WHERE antes de agrupar.

SQL
SELECT municipio 
FROM personas 
WHERE ingresos_anuales > 0 
GROUP BY municipio 
ORDER BY SUM(ingresos_anuales) DESC 
LIMIT 1;
Bloque 3: Relaciones Familiares (Self-Joins)
Estos son los más difíciles ("el boss final"). Asumo que tienes columnas como id, padre_id y madre_id que apuntan a la misma tabla. Hacemos "joins" de la tabla consigo misma.

9. Dime los abuelos de la persona con id 1142. Lógica: Persona (1142) -> Padres -> Abuelos.

SQL
SELECT abuelos.nombre 
FROM personas AS nieto
JOIN personas AS padres ON (nieto.padre_id = padres.id OR nieto.madre_id = padres.id)
JOIN personas AS abuelos ON (padres.padre_id = abuelos.id OR padres.madre_id = abuelos.id)
WHERE nieto.id = 1142;
10. Dime los nietos de la persona con id 1093. Lógica inversa: Abuelo (1093) -> Hijos -> Nietos.

SQL
SELECT nietos.nombre 
FROM personas AS abuelo
JOIN personas AS hijos ON (hijos.padre_id = abuelo.id OR hijos.madre_id = abuelo.id)
JOIN personas AS nietos ON (nietos.padre_id = hijos.id OR nietos.madre_id = hijos.id)
WHERE abuelo.id = 1093;
16. Dime la media de edad de las personas con algún hijo con nombre empezando por L. Unimos Padres con Hijos y filtramos por el nombre del hijo.

SQL
SELECT AVG(padres.edad)
FROM personas AS padres
JOIN personas AS hijos ON (hijos.padre_id = padres.id OR hijos.madre_id = padres.id)
WHERE hijos.nombre LIKE 'L%';
17. Dime la edad media de las personas que sean hermanas de las personas de Málaga municipio. Lógica: Encontrar gente de Málaga -> Buscar sus hermanos (misma madre/padre) -> Calcular media.

SQL
SELECT AVG(hermanos.edad)
FROM personas AS malagueno
JOIN personas AS hermanos ON (
    malagueno.padre_id = hermanos.padre_id 
    OR malagueno.madre_id = hermanos.madre_id
)
WHERE malagueno.municipio = 'Málaga' 
AND malagueno.id <> hermanos.id; -- Para no contarse a sí mismo como hermano.