# Repaso MySQL — Administración de Bases de Datos con Sakila

---

## Conceptos clave antes de empezar

### El usuario en MySQL es siempre `'nombre'@'host'`

En MySQL un usuario **no es solo un nombre**, es la combinación de nombre + host desde donde se conecta. Esto es fundamental en todos los ejercicios:

| Expresión | Significado |
|---|---|
| `'admin'@'localhost'` | Solo puede conectarse desde la misma máquina del servidor |
| `'admin'@'%'` | Puede conectarse desde cualquier IP remota |
| `'admin'@'192.168.1.5'` | Solo desde esa IP concreta |

> **`'admin'@'localhost'` y `'admin'@'%'` son dos usuarios DISTINTOS** para MySQL aunque tengan el mismo nombre. Si creas uno con `localhost` y luego haces `GRANT` o `DROP` con `'%'`, no encontrará al usuario correcto.

---

## 1. Administración de Usuarios

### Comandos principales: `CREATE USER`, `ALTER USER`, `DROP USER`

---

### 1.1 Crear usuario solo desde `localhost`

**Lógica:** Se usa `'localhost'` para restringir el acceso únicamente desde la misma máquina donde corre el servidor MySQL.

```sql
CREATE USER 'sakila_admin'@'localhost'
  IDENTIFIED BY 'AdminPass123';
```

---

### 1.2 Crear usuario desde cualquier IP

**Lógica:** El comodín `%` significa "cualquier host". Se usa para usuarios que se conectan de forma remota.

```sql
CREATE USER 'sakila_user'@'%'
  IDENTIFIED BY 'UserPass456';
```

---

### 1.3 Mostrar todos los usuarios del servidor

**Lógica:** MySQL guarda los usuarios en la tabla interna `user` del esquema del sistema llamado `mysql`. Es una consulta `SELECT` normal a esa tabla.

```sql
SELECT user, host
FROM mysql.user;
```

---

### 1.4 Cambiar la contraseña de un usuario

**Lógica:** `ALTER USER` modifica las propiedades de un usuario ya existente. `IDENTIFIED BY` establece la nueva contraseña. Tienes que indicar el par `usuario@host` exacto con el que fue creado.

```sql
ALTER USER 'sakila_admin'@'localhost'
  IDENTIFIED BY 'NewSecurePass789';
```

---

### 1.5 Eliminar un usuario

**Lógica:** `DROP USER` elimina el usuario del sistema junto con todos sus privilegios. Siempre debes indicar el par `nombre@host`.

```sql
DROP USER 'sakila_user'@'%';
```

> ⚠️ **Atención:** Si el usuario fue creado con `@'%'` y pones `@'localhost'` en el `DROP`, MySQL no encontrará al usuario y dará error.

---

## 2. Gestión de Privilegios

### Comandos principales: `GRANT`, `REVOKE`, `SHOW GRANTS`, `FLUSH PRIVILEGES`

### El principio base: mínimo privilegio

Solo se concede lo estrictamente necesario. Esto reduce el riesgo de que un usuario cause daño accidental o intencionado.

---

### 2.1 Conceder todos los privilegios sobre una base de datos

**Lógica:** `ALL PRIVILEGES` da control total (SELECT, INSERT, UPDATE, DELETE, CREATE, DROP...). La notación `sakila.*` significa "todas las tablas de la base de datos sakila".

```sql
GRANT ALL PRIVILEGES ON sakila.*
  TO 'sakila_admin'@'localhost';
```

> Si además quieres que `sakila_admin` pueda conceder permisos a otros usuarios, añade `WITH GRANT OPTION` al final.

---

### 2.2 Conceder permisos concretos sobre una tabla

**Lógica:** Puedes listar varios privilegios separados por coma antes de `ON`. Aquí se restringe el acceso solo a la tabla `film` y solo para leer e insertar.

```sql
GRANT SELECT, INSERT ON sakila.film
  TO 'sakila_user'@'%';
```

---

### 2.3 Revocar un permiso concreto

**Lógica:** `REVOKE` es el inverso exacto de `GRANT`: misma sintaxis pero usa `FROM` en lugar de `TO`. Solo se quita lo indicado; el resto de permisos permanece intacto.

```sql
REVOKE INSERT ON sakila.film
  FROM 'sakila_user'@'%';
```

> Después de esto, `sakila_user` sigue teniendo `SELECT` en `film`, pero ya no puede hacer `INSERT`.

---

### 2.4 Ver los privilegios de un usuario

**Lógica:** `SHOW GRANTS` lista todos los permisos actuales del usuario, incluyendo los que heredó de roles asignados.

```sql
SHOW GRANTS FOR 'sakila_admin'@'localhost';
```

---

### 2.5 Aplicar los cambios de privilegios

**Lógica:** `FLUSH PRIVILEGES` recarga en memoria la tabla de permisos del sistema. Con los comandos `GRANT`/`REVOKE` modernos no es estrictamente necesario, pero sí lo es si alguien modificó las tablas del sistema directamente con `INSERT` o `UPDATE`. El enunciado lo pide explícitamente, así que siempre inclúyelo.

```sql
FLUSH PRIVILEGES;
```

---

## 3. Gestión de Roles

### ¿Qué es un rol?

Un **rol** es una plantilla de permisos con nombre. En lugar de conceder los mismos permisos uno a uno a varios usuarios, se crean una vez en el rol y se asigna el rol. Si hay que cambiar los permisos, se cambia el rol y todos los usuarios que lo tienen quedan actualizados.

**Flujo de trabajo con roles:**
```
1. CREATE ROLE          → crear el rol vacío
2. GRANT permisos TO rol → darle permisos al rol
3. GRANT rol TO usuario  → asignar el rol al usuario
4. SET DEFAULT ROLE      → activarlo automáticamente al conectarse
```

---

### 3.1 Crear un rol

**Lógica:** Se crea el rol vacío primero. Aún no tiene ningún permiso.

```sql
CREATE ROLE 'gestor_clientes';
```

---

### 3.2 Conceder permisos al rol

**Lógica:** La sintaxis es igual que con usuarios. Al dar permisos al rol, cualquier usuario que tenga ese rol los heredará automáticamente.

```sql
GRANT SELECT, INSERT, UPDATE ON sakila.customer
  TO 'gestor_clientes';
```

---

### 3.3 Asignar el rol a un usuario

**Lógica:** Aquí `GRANT` no da un permiso de tabla, sino que vincula el rol al usuario. La diferencia es que no hay `ON tabla`: lo que va antes de `TO` es el nombre del rol.

```sql
GRANT 'gestor_clientes'
  TO 'sakila_user'@'%';
```

---

### 3.4 Establecer el rol como predeterminado

**Lógica:** En MySQL 8+, tener un rol asignado **no activa sus permisos automáticamente** al conectarse. Sin este paso, el usuario tendría que ejecutar `SET ROLE 'gestor_clientes';` manualmente en cada sesión.

```sql
SET DEFAULT ROLE 'gestor_clientes'
  TO 'sakila_user'@'%';
```

> ⚠️ **Este es uno de los errores más comunes.** Si no ejecutas `SET DEFAULT ROLE`, el usuario tiene el rol asignado pero sus permisos NO están activos al iniciar sesión.

---

### 3.5 Ver los roles asignados a un usuario

**Lógica:** `SHOW GRANTS` también muestra los roles asignados, no solo los permisos directos.

```sql
SHOW GRANTS FOR 'sakila_user'@'%';
```

---

## 4. Índices

### ¿Qué es un índice?

Un índice es una estructura interna que MySQL construye para acelerar las búsquedas por una columna. Sin índice, MySQL lee toda la tabla fila a fila (*full table scan*). Con índice, va directo a los registros relevantes.

**Tipos habituales:**

| Tipo | Sintaxis | Para qué sirve |
|---|---|---|
| Normal | `CREATE INDEX` | Acelerar búsquedas |
| Compuesto | `CREATE INDEX` con varias columnas | Búsquedas por varias columnas a la vez |
| Único | `CREATE UNIQUE INDEX` | Acelerar + garantizar que no haya duplicados |

---

### 4.1 Índice simple en una columna

**Lógica:** La sintaxis es `CREATE INDEX nombre_indice ON tabla (columna)`. El nombre del índice lo eliges tú y lo necesitarás para borrarlo después.

```sql
CREATE INDEX idx_first_name
  ON customer (first_name);
```

---

### 4.2 Índice compuesto en varias columnas

**Lógica:** Útil cuando los `WHERE` de las consultas filtran por las dos columnas juntas. El **orden de las columnas importa**: el índice ayuda más cuando la consulta incluye la primera columna listada.

```sql
CREATE INDEX idx_full_name
  ON customer (first_name, last_name);
```

---

### 4.3 Índice único en una columna

**Lógica:** `UNIQUE` hace dos cosas a la vez: acelera las búsquedas por `email` e impide que haya dos filas con el mismo valor (restricción de integridad). Si intentas insertar un email duplicado, MySQL dará error.

```sql
CREATE UNIQUE INDEX idx_email
  ON customer (email);
```

---

### 4.4 Mostrar todos los índices de una tabla

**Lógica:** `SHOW INDEX` lista todos los índices de la tabla, incluida la clave primaria (que MySQL crea automáticamente) y todos los que hayas creado tú.

```sql
SHOW INDEX FROM customer;
```

---

### 4.5 Eliminar un índice

**Lógica:** Para borrar un índice necesitas el **nombre que le diste al crearlo**, no el nombre de la columna. Por eso es buena práctica usar nombres descriptivos como `idx_first_name`.

```sql
DROP INDEX idx_first_name
  ON customer;
```

---

## Resumen de puntos críticos

| # | Lo que debes recordar |
|---|---|
| 1 | El usuario en MySQL es siempre el par `'nombre'@'host'`. Nunca omitas el host. |
| 2 | `'admin'@'localhost'` y `'admin'@'%'` son usuarios distintos. |
| 3 | `GRANT` tiene dos usos: dar permisos de tabla (con `ON`) y asignar roles (sin `ON`). |
| 4 | En MySQL 8+, asignar un rol no lo activa al conectarse. Siempre añade `SET DEFAULT ROLE`. |
| 5 | `FLUSH PRIVILEGES` solo es obligatorio si modificas las tablas del sistema directamente. Con `GRANT`/`REVOKE` no hace falta, pero el enunciado lo puede pedir. |
| 6 | Para borrar un índice necesitas el nombre que le diste al crearlo, no el de la columna. |
| 7 | `REVOKE` solo quita lo que indicas. El resto de permisos del usuario permanece intacto. |


Privilegios a nivel de COLUMNA (Granularidad Fina)
A veces no quieres que un usuario vea toda la tabla. Por ejemplo, en la tabla staff de Sakila, quizás quieres que un administrativo pueda actualizar el nombre, pero no quieres que vea ni toque la columna password.

Ejemplo:
Permitir que un usuario vea solo el nombre y apellido del personal, y que solo pueda actualizar el nombre.

```Sql
-- Solo permitimos SELECT en columnas específicas
GRANT SELECT (first_name, last_name) ON sakila.staff
  TO 'staff_manager'@'%';

-- Solo permitimos UPDATE en una columna específica
GRANT UPDATE (first_name) ON sakila.staff
  TO 'staff_manager'@'%';

```