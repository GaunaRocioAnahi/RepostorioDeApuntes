# Ejercicios sobre JOINs - Base de Datos Coches

## Descripción

Estos 20 ejercicios están basados en la base de datos **coches**, que contiene información de personas y sus vehículos. La mayoría de los ejercicios requieren el uso de **JOINS** para combinar datos de diferentes tablas.

**Tablas disponibles:**

- **personas**: id, nombre, apellido, sexo, fecha_nacimiento, provincia, municipio, nivel_estudios, ingresos_anuales, estado_civil, nivel_socioeconomico, ocupacion, madre, padre
- **coches**: id, id_dueño, marca, modelo, año_fabricacion, matricula, color

---

## Nivel 1: INNER JOIN Básicos

### 1. Muéstrame las Personas y sus coches (solo los que tengan algun coche)
--select personas.nombre, coches.marca, coches.modelo
from personas join coches on personas.id=coches.id_dueño;

### 2. Coches con información de dueños como su nombre y su provincia
--select personas.nombre, personas.provincia, coches.modelo
from coches join
 personas on coches.id_dueño = personas.id;

### 3. Personas que tienen coches y su estado civil.
select coches.modelo, personas.nombre, personas.estado_civil
from personas join coches on personas.id = coches.id_dueño;

### 4. Coches de personas ricas (niv socioeconomico alto)

select coches.modelo, personas.nombre, personas.nivel_socioeconomico
from coches join personas on coches.id_dueño = personas.id where personas.nivel_socioeconomico = 'alto'; 

### 5. Ocupaciones de dueños de coches mayores de 30 años.
 
 select coches.modelo, personas.nombre,TIMESTAMDIFF(YEAR,fecha_nacimiento,CURATE()) FROM personas join coches on personas.id = coches.id_dueño where TIMESTAMPDIFF(YEAR, fecha_nacimiento, CURDATE()) > 30;
---

## Nivel 2: LEFT JOIN

### 6. Todas las personas y sus coches (incluyendo sin coches)

select * from personas left join coches on personas.id = coches.id_dueño;

select personas.nombre, coches.modelo from personas left join coches on personas.id = coches.id_dueño;

### 7. Personas sin coches registrados.
select personas.nombre, coches.modelo from personas left join coches on personas.id = coches.id_dueño where marca is null;

### 8. Provincias con y sin representación de coches.

 select personas.provincia, coches.modelo from personas left join coches on personas.id = coches.id_dueño;

### 9. Nivel de estudios de las personas sin coche.

select personas.nombre, personas.nivel_estudios, coches.marca from personas left join coches on personas.id = coches.id_dueño where marca is null;

### 10. Personas jubiladas con sus vehículos.

select personas.nombre, personas.apellido, coches.marca, coches.modelo from personas join coches on personas.id = coches.id_dueño where personas.ocupacion = 'Jubilado';

---

## Nivel 3: JOINS con Agregaciones

### 11. Número de coches por persona.

 select personas.nombre,
       personas.apellido,
       COUNT(coches.id) AS total_coches
FROM personas
JOIN coches ON personas.id = coches.`id_dueño`

### 12. Marca más común entre personas de cada provincia.

SELECT personas.provincia,
       coches.marca,
       COUNT(coches.id) AS total
FROM personas
JOIN coches ON personas.id = coches.`id_dueño`
GROUP BY personas.provincia, coches.marca
ORDER BY personas.provincia, total DESC;

### 13. Promedio de edad de dueños por marca de coche.

select coches.marca, AVG(TIMESTAMPDIFF(YEAR, fecha_nacimiento, CURDATE())) as edad FROM personas join coches on personas.id = coches.id_dueño group by coches.marca; 

### 14. Total de ingresos de dueños por color de coche.

select coches.color, SUM(ingresos_anuales) as ingresos_totales from personas join coches on personas.id = coches.id_dueño group by coches.color order by ingresos_totales DESC;

### 15. Municipios con más coches.
select personas.municipio, count(coches.id_dueño)as total_coches from personas join coches on personas.id = coches.id_dueño group by municipio order by total_coches desc;

---

## Nivel 4: JOINS Complejos (Autojoins y múltiples tablas)

### 16. Padres e hijos y sus coches

SELECT padre.nombre AS nombre_padre,
       hijo.nombre  AS nombre_hijo,
       coches_padre.marca AS coche_padre,
       coches_hijo.marca  AS coche_hijo
FROM personas AS hijo
JOIN personas AS padre ON hijo.padre = padre.id
JOIN coches AS coches_hijo  ON hijo.id  = coches_hijo.`id_dueño`
JOIN coches AS coches_padre ON padre.id = coches_padre.`id_dueño`;

### 17. Parejas con algún hijo y sus coches
SELECT padre.nombre AS nombre_padre,
       madre.nombre AS nombre_madre,
       coches_padre.marca AS coche_padre,
       coches_madre.marca AS coche_madre
FROM personas AS hijo
JOIN personas AS padre ON hijo.padre = padre.id
JOIN personas AS madre ON hijo.madre = madre.id
JOIN coches AS coches_padre ON padre.id = coches_padre.`id_dueño`
JOIN coches AS coches_madre ON madre.id = coches_madre.`id_dueño`;

### 18. Personas de la misma familia con más de dos coches

SELECT padre.nombre AS nombre_padre,
       madre.nombre AS nombre_madre,
       COUNT(coches_padre.id) + COUNT(coches_madre.id) AS total_coches
FROM personas AS hijo
JOIN personas AS padre ON hijo.padre = padre.id
JOIN personas AS madre ON hijo.madre = madre.id
LEFT JOIN coches AS coches_padre ON padre.id = coches_padre.`id_dueño`
LEFT JOIN coches AS coches_madre ON madre.id = coches_madre.`id_dueño`
GROUP BY padre.id, madre.id
HAVING COUNT(coches_padre.id) + COUNT(coches_madre.id) > 2;

## Consejos para la resolución

### Sintaxis básica de JOINs:

```sql
-- INNER JOIN (solo coincidencias)
SELECT * FROM personas
INNER JOIN coches ON personas.id = coches.id_dueño;

-- LEFT JOIN (todas las de la izquierda, coincidencias si existen)
SELECT * FROM personas
LEFT JOIN coches ON personas.id = coches.id_dueño;

-- SELF JOIN (una tabla unida consigo misma con alias)
SELECT p1.nombre, p2.nombre FROM personas p1
INNER JOIN personas p2 ON p1.id = p2.padre;
```

### Puntos importantes:

- Usa **alias** para las tablas en JOINs complejos (ej: `personas p1`, `personas p2`)
- Recuerda incluir la cláusula **ON** para especificar la condición del JOIN
- Usa **GROUP BY** cuando agregues datos
- Ten cuidado con los **NULL** en campos como madre/padre
- Prueba tus JOINs paso a paso para asegurar la correcta relación entre tablas
