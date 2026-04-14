# peticiones en http

## Ejercicio 1

1º en la terminal vamos a guardamos el archivo en la ruta correspondiente.

2º creamos y abrimos el archivo con un editor de texto desde la terminal:

```bash
 nano db.jason
 # Verificamos que se haya creado bien con cat 
 cat db.json
```

3º copiamos y pegamos el JSON dentro del editor del texto o lo creamos ahi.

 DATO: Las claves que son ejemplo:  `{ "personas": [{...}, {...}] }`

`[]` --> son listas.
`"id": 1` --> los numeros van sin comillas.
`"nombre": "Laura"` --> los nombres van con comillas.  

```bash
{
    "personas": [
    {
        "id":1,
        "nombre": "Laura",
        "edad": 28,
        "coches": [
            { "marca": "Toyata", "modelo": "Yaris" },
            { "marca": "Ford", "modelo": "Fiesta"}
        ]
    },
    {
        "id": 1,
        "nombre": "Marcos",
        "edad": 35,
        "coches" : [
            "marca": "BMW", "modelo": "Serie 3"}
        ] 
      }
    ]
}

```

4º deberiamos encender el servidor por terminal.
`json-server --watch (nombrearchivo.json) --port 3000`


```bash
json-server --watch db.json --port 3000
# el nombre del archivo es db.json
# se tiene que ver lo siguiente por pantalla. 

Resources
http://localhost:3000/personas

Home
http://localhost:3000
```
dejamos la terminal abierta y abrimos otras para hacer peticiones. 

5º Si se ve un mensaje con 
` http://localhost:3000/personas ` es que esta funcionando lo siguiente es: 
 
## Peticiones

para ver todas las personas. 
3. GET: Para ver a TODAS las personas
  
- ¿Qué hace? curl sin ninguna opción hace un GET por defecto. Le dices "dame todo lo que hay en /personas". El servidor responde con el array completo de personas en JSON.

```bash
curl http://localhost:3000/personas

```
4. GET: Ver solo la segunda persona.
-¿Por qué el /2? Porque es el id de Marcos. json-server entiende que cuando pones un número después del recurso, quieres el elemento con ese id. Si pusieras /1 obtendrías a Laura.

```bash
curl http://localhost:3000/personas/2

```

5. POST: Añadir una nueva persona. 
- -X POST → le dices que el método HTTP es POST (crear algo nuevo)
-H "Content-Type: application/json" → le avisas al servidor que lo que envías es JSON
-d '{...}' → aquí van los datos de la nueva persona

Puedes verificar que se añadió repitiendo el GET del paso 3.

```bash
curl -X POST http://localhost:3000/personas \
  -H "Content-Type: application/json" \
  -d '{"id": 3, "nombre": "Sofia", "edad": 41, "coches": [{"marca": "Seat", "modelo": "Ibiza", "año": 2020}]}'
```

7. GET con filtros : Personas mayores de 30 años. 
- ¿Qué es edad_gte? Es una función especial de json-server. gte significa greater than or equal (mayor o igual que). Si quisieras solo mayores de 30 sin incluir el 30, usarías edad_gt=30.

- Las comillas en la URL son necesarias en algunas terminales porque el ? puede confundirla.

```bash
curl "http://localhost:3000/personas?edad_gte=30"
```
8. Mostrar solo los coches de una persona.
```bash
curl http://localhost:3000/personas/1 2>/dev/null | jq '.coches'

```
Descglose : 
`curl http://localhost:3000/personas/1` -->Pide los datos de la persona con id 1

`2>/dev/null` --> Redirige los mensajes de error (canal 2) a la papelera. Se usa 2 porque el canal 2 es stderr (errores) y el 1 es stdout (salida normal). Sin esto, curl muestra mensajes de progreso que ensucian la salida.

`|` -->El "pipe". Coge la salida del comando de la izquierda y se la pasa al comando de la derecha.

`jq '.coches'` -->Dentro del JSON recibido, busca y muestra solo el campo coches

para examen 

- jercicio 1 crea usuarios 
CREATE USER 'fichero_local'@' localhost' IDENTIFIED BY 'fallas2025';



ej1 
``` bash
curl -X POST http://localhost:3000/usuarios \
-H "Content-Type: application/json" \
-d '{"id": 1, "nombre": "fallero_local", "host": "localhost", "contrasena": "fallas2025"}'

curl -X POST http://localhost:3000/usuarios \
-H "Content-Type: application/json" \
-d '{"id": 2, "nombre": "organizadora_remota", "host": "%", "contrasena": "paellas123"}'


curl -X POST http://localhost:3000/usuarios \
-H "Content-Type: application/json" \
-d '{"id": 3, "nombre": "control_oficina", "host": "192.168.20.%", "contrasena": "seguridadfalla"}'
```

ej2

```bash
curl http://localhost:3000/usuarios 2>/dev/null | jq '[.[] | {nombre: .nombre, host: .host}]'

```
ej3

```bash
curl -X PATCH http://localhost:3000/usuarios/1 \
-H "Content-Type: application/json" \
-d '{"privilegios": ["SELECT", "INSERT", "UPDATE", "DELETE"]}'

curl -X PATCH http://localhost:3000/usuarios/2 \
-H "Content-Type: application/json" \
-d '{"privilegios": ["SELECT"]}'

curl -X PATCH http://localhost:3000/usuarios/3 \
-H "Content-Type: application/json" \
-d '{"rol": "coordinador_fallas", "privilegios": ["SELECT", "INSERT", "UPDATE"]}'
```

ej4

```bash
curl http://localhost:3000/usuarios/2 2>/dev/null | jq '{nombre: .nombre, privilegios: .privilegios}'

curl -X PATCH http://localhost:3000/usuarios/3 \
-H "Content-Type: application/json" \
-d '{"privilegios": ["SELECT", "INSERT"]}'

```

ej5

```bash
curl http://localhost:3000/eventos

curl "http://localhost:3000/eventos?nombre=Masclet%C3%A0"

curl "http://localhost:3000/eventos?fecha=2025-03-17&ubicacion=Plaza%20de%20la%20Virgen"
```
ej6

```bash
curl -X DELETE http://localhost:3000/usuarios/2

curl http://localhost:3000/usuarios
```
ej7

```bash

curl -X PATCH http://localhost:3000/usuarios/1 \
-H "Content-Type: application/json" \
-d '{"contrasena": "FallasSuperSegura2025!"}'

curl -X PATCH http://localhost:3000/usuarios/1 \
-H "Content-Type: application/json" \
-d '{"password_expire": true}'

curl -X PATCH http://localhost:3000/usuarios/1 \
-H "Content-Type: application/json" \
-d '{"host": "10.0.0.100"}'
```
ej8

```bash
curl -X PATCH http://localhost:3000/fallas_mayores/1 \
-H "Content-Type: application/json" \
-d '{"comentarios": ""}'

curl -X PATCH http://localhost:3000/eventos/1 \
-H "Content-Type: application/json" \
-d '{"ubicacion": "Plaza del Ayuntamiento de Valencia"}'

curl -X PATCH http://localhost:3000/fallas_mayores/1 \
-H "Content-Type: application/json" \
-d '{"comentarios": null}'

```


curl http://localhost/productos


curl http://localhost:3000/productos
# o
curl http://localhost:8080/productos

curl http://localhost:3000/productos | python3 -m json.tool

3-
curl -X POST http://localhost:3000/usuarios \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "nombre": "Paco", "rol": "Profesor"}'

4-
  curl -X PATCH http://localhost:3000/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{"rol": "Maestro"}'


  curl -X PUT http://localhost:3000/usuarios/1 \
  -H "Content-Type: application/json" \
  -d '{"id": 1, "nombre": "Paco", "rol": "Maestro"}'

  curl "http://localhost:3000/productos?nombre=Raton"

  curl -X PATCH http://localhost:3000/productos/B2 \
  -H "Content-Type: application/json" \
  -d '{"precio": 20.0}'


  ```bash
#!/bin/bash

URL=$1
CODIGO=$(curl -s -o /dev/null -w "%{http_code}" -X HEAD "$URL")

if [ "$CODIGO" -ge 200 ] && [ "$CODIGO" -lt 300 ]; then
    echo "EXITO!"
elif [ "$CODIGO" -ge 300 ] && [ "$CODIGO" -lt 400 ]; then
    NUEVA_URL=$(curl -s -o /dev/null -w "%{redirect_url}" -X HEAD "$URL")
    echo "Redirigiendo a $NUEVA_URL"
elif [ "$CODIGO" -ge 400 ] && [ "$CODIGO" -lt 500 ]; then
    echo "Lo siento, la conexion no se ha generado correctamente"
elif [ "$CODIGO" -ge 500 ]; then
    echo "Lo siento, el servidor no esta disponible"
fi


  ```

```BASH
  #!/bin/bash

if [ -z "$1" ]; then
  echo "Uso: $0 <URL>"
  exit 1
fi

URL=$1

CODIGO=$(curl -o /dev/null -s -w "%{http_code}" -I "$URL")
LOCATION=$(curl -o /dev/null -s -w "%{redirect_url}" -I "$URL")

if [[ $CODIGO -ge 200 && $CODIGO -lt 300 ]]; then
  echo "¡ÉXITO!"
elif [[ $CODIGO -ge 300 && $CODIGO -lt 400 ]]; then
  echo "Redirigiendo a $LOCATION"
elif [[ $CODIGO -ge 400 && $CODIGO -lt 500 ]]; then
  echo "Lo siento, la conexión no se ha generado correctamente."
elif [[ $CODIGO -ge 500 ]]; then
  echo "Lo siento, el servidor no está disponible."
else
  echo "Respuesta rara: $CODIGO"
fi