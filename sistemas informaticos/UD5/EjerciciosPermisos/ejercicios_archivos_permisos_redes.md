# Ejercicios de funciones — Gestión de archivos, permisos y redes 🔧🌐

Crea un script de `bash` con las siguientes 9 funciones orientadas a gestión de archivos, permisos y redes. Cada función debe validar argumentos (usar `validar_argumentos` o `validar` como en `mensaje.sh`) y devolver resultado o mensaje de error.

---

## 1. `crear_directorio`

Crea un directorio (usa `mkdir -p`) y muestra si ya existía o fue creado.

- Uso: `crear_directorio /ruta/al/directorio`
- Salida esperada: `Directorio '/tmp/prueba' creado`  o `Directorio '/tmp/prueba' ya existe`
- Validaciones: comprobar número de argumentos y permisos de escritura en la ruta padre.

---

## 2. `buscar_archivos_grandes`

Busca archivos mayores que X megabytes en un directorio (usar `find`).

- Uso: `buscar_archivos_grandes /ruta 50`  (busca > 50 MB)
- Salida esperada: lista de rutas (una por línea) o `No se encontraron archivos > 50 MB`
- Nota: convertir MB a bytes con `$(( size_mb * 1024 * 1024 ))` si es necesario.

---

## 3. `buscar_por_extension`

Cuenta o lista archivos con una extensión en un directorio.

- Uso: `buscar_por_extension /ruta txt`  (por defecto lista; opcional `-c` para contar)
- Salida esperada (conteo): `12`
  o (lista): `/ruta/a/archivo1.txt` (una por línea)
- Validaciones: comprobar que el directorio existe.

---

## 4. `cambiar_permisos`

Aplica `chmod` a un fichero (verificar formato numérico `^[0-7]{3,4}$`).

- Uso: `cambiar_permisos 644 archivo.txt`
- Salida esperada: `Permisos de 'archivo.txt' cambiados a 644`
- Error si formato inválido o fichero no existe.

---

## 5. `obtener_propietario`

Muestra propietario y grupo de un fichero

- Uso: `obtener_propietario archivo.txt`
- Salida esperada: `archivo.txt: propietario=juan grupo=staff`
- Validaciones: comprobar existencia del fichero.

---

## 6. `respaldo`

Crea una copia de seguridad con timestamp: `archivo.bak-YYYYMMDD_HHMMSS`.

- Uso: `respaldo archivo.txt`
- Salida esperada: `Backup creado: /ruta/archivo.txt.bak-20260217_123456`
- Error si el fichero no existe.
- Implementación: usar `cp --` y `date +%Y%m%d_%H%M%S`.

---

## 7. `tamaño_directorio`

Devuelve el tamaño total en bits de un directorio.

- Uso: `tamaño_directorio /var/log`
- Salida esperada: `4096`  (bits)

---

## 8. `puerto_abierto`

Comprueba si un puerto TCP está escuchando en un host (usar `nc -z` o `/dev/tcp`).

- Uso: `puerto_abierto ejemplo.com 80`
- Salida esperada: `80 abierto en ejemplo.com`  o: `80 cerrado en ejemplo.com`
- Validaciones: comprobar que `nc` o `/dev/tcp` están disponibles; manejar tiempo de espera razonable.

---

## 9. `verificar_conectividad`

Hace un `ping -c 1` y muestra si el host responde y la latencia.

- Uso: `verificar_conectividad 8.8.8.8`
- Salida esperada: `8.8.8.8 responde (latencia: 24 ms)`  o: `8.8.8.8 no responde`

## Requisitos generales ✅

- Validar número de argumentos en cada función (usar `validar_argumentos` o `validar` como en `mensaje.sh`).
- Si falta argumento, mostrar mensaje indicando cuántos se necesitan.
- Usar `$(( ... ))` o `bc` cuando haga falta cálculo (p. ej. conversiones de tamaño).
- Comprobar condiciones (archivo/directorio existe, permisos válidos, herramientas disponibles).
- Salidas claras: éxito → mensaje/valor + exit code `0`; error → mensaje + exit code `>0`.
- Documentar uso y ejemplos en comentarios dentro del script.

---

> **Sugerencia:** añade al script una función `validar_argumentos` reutilizable y un pequeño menú de pruebas para ejecutar y verificar cada función rápidamente.
