# Repaso

## UD4 Consultas

tips Mas importe: ORDEN DE ESCRITURA.

¿Que quiero ver? --- > 'SELECT'
¿De donde? --->'FROM'
¿Con que condicion?--->'WHERE'
¿Agrupado? ---> 'GROUP BY'
¿En que orden? ---> 'ORDER BY'
¿Cuantos? ---> 'LIMIT'

### Orden de prioridad COMPLETO

```sql
SELECT   --1. Que quiero mostrar o ver
FROM     --2. de donde
WHERE    --3. filtro filas ( antes de agrupar)
GROUP BY --4. agrupo
HAVING   --5. filtro grupos (despues de agrupar)
ORDER BY --6. ordeno
LIMIT    --7. cuantos
```

### WHERE

Es cuando el enunciado pone alguna condicion, ejemplo
Si el enunciado dice:
"De Malaga"/"de provincia X" ---> `WHERE provincia = 'Malaga'`
"Con estudios primarios" ---> `WHERE nivel_estudios ='Primarioos'`
"mayores de 30 años" ---> `WHERE edad > 30`
"que ganen más de 10000" ---> `WHERE ingresos_anuales > 10000`
"hombres"---> `WHERE sexo = 'H'`
"solteros Y de Sevilla" --> `WHERE estado_civil = 'Soltero' AND provincia = 'Sevilla'`
"de Málaga O de Cádiz" --> `WHERE provincia = 'Málaga' OR provincia = 'Cádiz'`
 **REGLA SIMPLE**
 ¿ El filtro usa un COUNT, MAX, SUM... En el SELECT? -->`HAVING`
 ¿filtra columna normal? -->`WHERE`

### GROUP BY

Cuando el enunciado dice:
"por provincia", "por municipio" --> Agrupa por esa columna
"de cada..."
"El maximo/minimo/ media por... " GROUP BY.
**REGLA**
Los paréntesis en MAX(...) son obligatorios porque es una función — siempre llevan paréntesis: MAX(), MIN(), COUNT(), SUM(), AVG(). No es una condición, es una operación sobre los datos. EN EL SELECT.
 *TODO lo que esta en el SELECT y no es una funcion obligatoriamente tiene que estar en el GROUP BY*
 cuando en un enunciado pide una media, maximo, suma o conteo, pasa a ser un dato unico. PRESTAR ATENCION.

"agrupado por X"---GROUP BY X
"de cada X"---GROUP BY X
"por X"---GROUP BY X
"según X"---GROUP BY X
"para cada X"---GROUP BY X

### ORDER BY

- Mas  edad/ mas antiguo/ primero --> *ORDER BY campo ASC*
- Menos edad/ mas reciente / ultimo --> *ORDER BY campo DESC*
- Siempre acompañado de *LIMIT N*

Ejemplo de cuando hay dos ORDER BY
Primero los que más cobran
Luego ordenados por longitud de ocupación

```sql
SELECT nombre, apellido, ocupacion
FROM personas
WHERE provincia = 'Granada'
ORDER BY ingresos_anuales DESC, LENGTH(ocupacion)
LIMIT 5;
```

### LIMIT vs COUNt

`LIMIT` Recorta el resultado a N filas, ver filas --> siempre al final de la query
`COUNT(*)` Cuentas cuantas filas hay, cuantos hay --> en el SELECT

  *Cuando el enunciado dice `de mas` EDAD.*
   Serian los que nacieron antes = fecha mas antigua de nacimiento = Orden ASC.

   ```sql
   SELECT nombre, apellido
   FROM personas
   WHERE provincia = 'malaga'
   ORDER BY fecha_ nacimiento ASC
   LIMIT 5;
   ```

 **Para obtener una edad apartir  de la fecha de nacimiento**necesitamos:
TIMESTAMPDIFF(YEAR,fecha_nacimiento, CURDATE())
-- si tienes una columna año_nacimiento
YEAR(CURDATE()) - año_nacimiento AS edad

### CONTEO DE LETRAS

LEFT(campo, N)  ---> primeras N letras
RIGHT(campo, N) ---> Ultimas N letras
LENGTH(campo) ---> Cuantas letras tiene
UPPER(campo) ---> Todo en mayusculas
LOWER(campo) ---> todo el mayusculas

### PARA LA MODA

es un valor que se repite:
Ejemplo: Dime la moda del estado civil.

```sql
SELECT estado_civil, COUNT(*) AS total
FROM personas
GROUP BY estado_civil
ORDER BY COUNT(*) DESC
LIMIT 1;
```

### DISTINCT

El enunciado dice "Dime cuantos municipios distintos hay", "cuales son los municipios"
**TIPS** "sin repetir" , "diferentes", "Distintos".
**"cuántos diferentes"COUNT(DISTINCT campo)**
**"cuántos en total"COUNT(campo)**
**"suma sin repetir"SUM(DISTINCT campo)**
ejemplo:

```sql
COUNT(DISTINCT municipio)
--         ↑
--    primero elimina repetidos
--   ↑
--  luego cuenta lo que queda
```

utilizacion del IN:

```sql

-- Sin IN, repetitivo
WHERE id = 1135 OR id = 1134

-- Con IN, más limpio
WHERE id IN (1135, 1134)
```

**Siempre que tengas varios valores posible spara un mismo campo usa IN*

**La regla**
*Cuando necesitas operar sobre el resultado de un COUNT o GROUP BY, ese resultado primero tiene que convertirse en una tabla temporal en el FROM.*
AVG necesita una columna de números
→ esa columna no existe en la tabla original
→ tengo que crearla primero con una subquery en el FROM
→ luego AVG opera sobre ella

### Subquerys

**La regla es:**
Solo necesitas subquery cuando el dato que necesitas no existe directamente en la tabla.
¿El dato que necesito existe en la tabla?
→ SÍ  → no necesito subquery, opero directamente
→ NO  → necesito subquery para crearlo primero

¿El dato que necesito existe en la tabla?
→ SÍ  → no necesito subquery, opero directamente
→ NO  → necesito subquery para crearlo primero

ejemplo:
-- excluir los que cobran 0
WHERE ingresos_anuales > 0

-- excluir los NULL (si los hubiera)
WHERE ingresos_anuales IS NOT NULL

-- excluir ambos
WHERE ingresos_anuales > 0 AND ingresos_anuales IS NOT NULL

  **DIAS, MES, AÑO**
-DAY(fecha)Día del mes
-MONTH(fecha)Mes
-YEAR(fecha)Año
-DAYOFWEEK(fecha)Día de la semana

**REGLA PARA DECADA CALCULAR**
`FLOOR(YEAR(fecha_nacimiento) / 10) * 10`
SIGLOS ES `100`
AGRUPAR EN `10000`
Cuando necesitas convertir un número continuo en grupos de tamaño fijo, usa FLOOR dividiendo entre el tamaño del grupo.
Ejemplo: `Cuando necesitas convertir un número continuo en grupos de tamaño fijo, usa FLOOR dividiendo entre el tamaño del grupo.`

Usa siempre IN para capturar ambos, o LIKE 'Casa%' para abreviar.

## JOIN

para captarlo preguntamos que datos comparten las misma informacion o columna.
si estan en tablas diferentes necesitamos un join.

INNER JOIN ------->Solo filas que coinciden en ambas tablas

LEFT JOIN -------->Todas las filas de la izquierda, coincidan o no

RIGHT JOIN ------->Todas las filas de la derecha, coincidan o no

```sql
FROM tabla_principal
JOIN tabla_puente ON tabla_principal.id = tabla_puente.id_principal
JOIN tabla_destino ON tabla_puente.id_destino = tabla_destino.id;
```

**tips**
"solo los que tengan"  → INNER JOIN
"todos aunque no tengan" → LEFT JOIN

ejemplo de CONCAT: `CONCAT(autor.nombre, ' ', autor.apellido) AS nombre_completo`

### VER TODAS LAS TABLAS

`SHOW TABLES;`

**VER LA ESTRUCTURA DE CADA TABLA** `DESCRIBE Tabla`

**Las reglas de los IDs en JOIN**
Siempre conectas:
EL ID ORIGINAL de una tabla
con
LA REFERENCIA A ESE ID en otra tabla = Siempre id_X apunta a X.id
ejemplo:
comic.id          ←→  comic_autor.id_comic
autor.id          ←→  comic_autor.id_autor
editorial.id      ←→  comic_editorial.id_editorial
cliente.id        ←→  pedido.id_cliente
pedido.id         ←→  detalle_pedido.id_pedido

**REGLAS PARA ENUNCIADO**
El enunciado dice:
"solo los que tengan"-------------------INNER JOIN
"solo los que tengan al menos uno"------INNER JOIN
"todos aunque no tengan"----------------LEFT JOIN
"incluyendo los que no tienen"----------LEFT JOIN
"también los que no tienen"-------------LEFT JOIN

En la práctica casi siempre se usa LEFT JOIN poniendo la tabla principal en el FROM. RIGHT JOIN es lo mismo pero al revés y se usa menos.

**ORDEN**.

1. ¿Qué tablas necesito?        → FROM + JOINs
2. ¿Cómo se conectan?           → ON
3. ¿Qué condición aplico?       → WHERE
4. ¿Agrupo algo?                → GROUP BY
5. ¿Filtro grupos?              → HAVING
6. ¿Ordeno?                     → ORDER BY
7. ¿Limito resultados?          → LIMIT

JOIN sin LEFT    → solo los que tienen relación
LEFT JOIN        → todos aunque no tengan relación
LEFT JOIN + WHERE IS NULL → solo los que NO tienen relación

## Administracion de Bases de Datos

````sql
-- USUARIOS
CREATE USER 'nombre'@'host' IDENTIFIED BY 'contraseña';
DROP USER 'nombre'@'host';
ALTER USER 'nombre'@'host' IDENTIFIED BY 'nuevaContraseña';

-- PRIVILEGIOS
GRANT privilegios ON base_de_datos.tabla TO 'usuario'@'host';
REVOKE privilegios ON base_de_datos.tabla FROM 'usuario'@'host';
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'usuario'@'host';

-- ROLES
CREATE ROLE 'nombre_rol';
GRANT privilegios ON tabla TO 'rol';
GRANT 'rol' TO 'usuario'@'host';
SET DEFAULT ROLE 'rol' TO 'usuario'@'host';

-- ÍNDICES
CREATE INDEX nombre_idx ON tabla (columna);
DROP INDEX nombre_idx ON tabla;
SHOW INDEX FROM tabla;
````

**Tips**
¿Habla de usuarios?     → CREATE/DROP/ALTER USER
¿Habla de permisos?     → GRANT/REVOKE
¿Habla de roles?        → CREATE ROLE + GRANT
¿Habla de índices?      → CREATE/DROP INDEX
¿Habla de tablas?       → ALTER TABLE

"solo desde localhost"------'localhost'
"desde cualquier IP"--------'%'
"desde la red 192.168.20"---'192.168.20.%'
"desde una IP específica"---'192.168.1.5'

192.168.20.% → cualquier IP que empiece por 192.168.20
%            → cualquier IP del mundo

### CREARTE USER

`SELECT User, Host FROM mysql.user;`

Asignar un rol a usuario : `"asignarlo a control_oficina"→ GRANT rol TO usuario`
ejemplo: `GRANT 'coordinador_fallas' TO 'control_oficina'@'192.168.20.%';`
crear un rol: `'CREATE ROLE` ejemplo:`CREATE ROLE 'coordinador_fallas';`

dar privilecio: ejemplo: `GRANT SELECT, INSERT, UPDATE ON fallas.* TO 'coordinador_fallas';`
rol predeterminado: `SET DEFAULT ROLE 'coordinador_fallas' TO 'control_oficina'@'192.168.20.%';`

"todos los privilegios"----ALL PRIVILEGES
"solo lectura"-------------SELECT
"lectura y escritura"-------SELECT, INSERT, UPDATE
"sobre toda la base de datos"--basedatos.*
"sobre una tabla específica"---basedatos.tabla
"crea un rol"-------------------CREATE ROLE
"asigna el rol"--------------GRANT rol TO usuario
"rol predeterminado"---------SET DEFAULT ROLE

mostrar privilegios actuales:
"muestra privilegios de un usuario"
→ SHOW GRANTS FOR
ejemplo: `SHOW GRANTS FOR 'organizadora_remota'@'%';`

**revocar permisos**
GRANT  → das permisos    → TO
REVOKE → quitas permisos → FROM

ejemplo:
REVOKE UPDATE ON fallas.* FROM 'control_oficina'@'192.168.20.%';
aplicar los cambios
"aplica los cambios"
→ FLUSH PRIVILEGES
→ actualiza los permisos inmediatamente

```sql
una orden completa seria:
-- Paso 1: ver privilegios
SHOW GRANTS FOR 'organizadora_remota'@'%';

-- Paso 2: revocar permiso
REVOKE UPDATE ON fallas.* FROM 'control_oficina'@'192.168.20.%';

-- Paso 3: aplicar cambios
FLUSH PRIVILEGES;
```

**tips para recordar el REVOKE**
GRANT  privilegio ON tabla TO   usuario  → das
REVOKE privilegio ON tabla FROM usuario  → quitas

LA DIFERENCIA
TO   → GRANT  (hacia el usuario)
FROM → REVOKE (desde el usuario)

PARA VERIFICAR:

```sql
-- verifica que UPDATE ya no aparece
SHOW GRANTS FOR 'control_oficina'@'192.168.20.%';
```

## INDICE

`CREATE INDEX nombre_indice ON tabla (columna);`
"muestra los índices de la tabla eventos"
→ SHOW INDEX FROM tabla

**RESUMEN DE TIPS PARA INDICES**
"crea un índice sobre una columna"----CREATE INDEX nombre ON tabla (columna)
"índice compuesto"---------------------CREATE INDEX nombre ON tabla (col1, col2)
"muestra los índices"------------------SHOW INDEX FROM tabla
"elimina un índice"--------------------DROP INDEX nombre ON tabla

"sobre la columna X"      → simple  → (columna)
"sobre las columnas X e Y" → compuesto → (columna1, columna2)

## Elimina usuario

`DROP USER 'nombre'@'host';`

## Elimina indice

`DROP INDEX nombre_indice ON tabla;`

## Elimina el Rol

`DROP ROLE 'nombre_rol';`

Punto 1 — "cambia la contraseña"
"cambia la contraseña"→ ALTER USER ... IDENTIFIED BY

```sql
ALTER USER 'fallero_local'@'localhost' IDENTIFIED BY 'fallerasSuperSegura2025';
```

Punto 2 — "obliga a cambiar la contraseña en el próximo inicio"
"obliga a cambiar contraseña"
→ ALTER USER ... PASSWORD EXPIRE

```sql
ALTER USER 'fallero_local'@'localhost' PASSWORD EXPIRE;
```

```sql
-- Paso 1: crear con nuevo host
CREATE USER 'fallero_local'@'10.0.0.100' IDENTIFIED BY 'fallerasSuperSegura2025';

-- Paso 2: darle los mismos privilegios que tenía
GRANT ALL PRIVILEGES ON fallas.* TO 'fallero_local'@'10.0.0.100';

-- Paso 3: eliminar el usuario antiguo
DROP USER 'fallero_local'@'localhost';
```

## Añadir columna

ALTER TABLE tabla ADD columna tipo_dato;

ejemplo ALTER TABLE fallas_mayores ADD comentarios VARCHAR(255);

## modifica la columna

ALTER TABLE tabla MODIFY columna nuevo_tipo;
ejemplo: ALTER TABLE eventos MODIFY comentario VARCHAR(100);

## elimina la columna

ALTER TABLE tabla DROP COLUMN columna;
ejemplo: ALTER TABLE fallas_mayores DROP COLUMN comentarios;

"añade una columna"--------ALTER TABLE tabla ADD columna tipo;
"modifica la columna"------ALTER TABLE tabla MODIFY columna tipo;
"elimina la columna"-------ALTER TABLE tabla DROP COLUMN columna;
"renombra la columna"------ALTER TABLE tabla RENAME COLUMN viejo TO nuevo;

verificaciones de todo

```sql
-- ver todos los usuarios
SELECT User, Host FROM mysql.user;

-- ver privilegios de un usuario
SHOW GRANTS FOR 'usuario'@'host';

-- ver índices de una tabla
SHOW INDEX FROM tabla;

-- ver estructura de una tabla
DESCRIBE tabla;
```
