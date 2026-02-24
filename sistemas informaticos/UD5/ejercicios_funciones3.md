# Ejercicios de Funciones en Bash

Crea un script de bash con las siguientes 10 funciones:

## 4. Función `multiplicar`

Crea una función que multiplique dos números pasados como argumentos.

**Uso:** `multiplicar 7 8`

**Salida esperada:** `56`

---

## 5. Función `potencia`

Crea una función que eleve un número a una potencia. El primer argumento es la base y el segundo el exponente.

**Uso:** `potencia 2 5`

**Salida esperada:** `32`

---

---

## 7. Función `volumen_cubo`

Crea una función que calcule el volumen de un cubo recibiendo el lado como argumento. Formula: V = lado³

**Uso:** `volumen_cubo 4`

**Salida esperada:** `64`

---

## 8. Función `modulo`

Crea una función que obtenga el resto de la división entre dos números.

**Uso:** `modulo 17 5`

**Salida esperada:** `2`

---

## 9. Función `verificar_par`

Crea una función que compruebe si un número es par. Debe mostrar un mensaje indicando si es par o impar.

**Uso:** `verificar_par 8`

**Salida esperada:** `8 es par`

---

## 10. Función `mayor_de_tres`

Crea una función que reciba tres números como argumentos y devuelva el mayor de ellos.

**Uso:** `mayor_de_tres 15 8 22`

**Salida esperada:** `22`

---

## 11. Función `factorial`

Crea una función que calcule el factorial de un número. El factorial de n es el producto de todos los números desde 1 hasta n.

**Uso:** `factorial 5`

**Salida esperada:** `120`



## 12. Función `es_primo`

Crea una función que compruebe si un número es primo. Debe mostrar un mensaje indicando si es primo o no.

¿Qué le pasa a la función para números grandes, podrias mejorar la eficiencia?

**Uso:** `es_primo 17`

**Salida esperada:** `17 es primo`

---

## 13. Función `fibonacci`

Crea una función que devuelva el n-ésimo número de la serie de Fibonacci. La serie comienza: 0, 1, 1, 2, 3, 5, 8, 13...

Al igual que el ejercicio 14, ¿habría una forma de bajar la eficiencia del algoritmo? ¿se podría saber el n-ésimo elemento sin tener que calcular todos los anteriores?

Por si no lo sabías, si divides un elemento de la sucesion de fibonacci entre el anterior, te vas acercando al número aúreo.

Piensa en un programa, en el lenguaje que quieras, que te calcule tantas cifras como puedas del número áureo

**Uso:** `fibonacci 7`

**Salida esperada:** `13`

## **14. Función `sumatorio`**

Crea una funcion que sume todos los números de 1 al numero pasado como primer argumento.
Si lo haces en eficiencia lineal O(n), lo tienes bien, pero la gracia de este ejercicio es intentar hacerlo de manera inmediata, lo que se llama O(1). Una manera de calcularlo, que dé igual lo grande que sea el número, se haga de manera "inmediata".

Al igual que para sumatorio, ¿Se podría hacer para el factorial?

## **15. Función `raiz cuadrada`**

Crea una funcion, en el lenguaje que mas te guste, que calcule m cifras decimales de la raiz cuadrada de un numero dado. No uses funciones como sqrt o pow, calcula tu mismo la raíz cuadrada.

---


## Requisitos Generales

- Cada función debe validar que recibe el número correcto de argumentos
- Si falta un argumento, mostrar un mensaje de error indicando cuántos se necesitan
- Utilizar `validar_argumentos` o `validar` (como en mensaje.sh) para comprobar los argumentos
- Usar `$(( ... ))` o `bc` para las operaciones matemáticas cuando sea necesario
- Todas las funciones deben retornar el resultado o un mensaje de error
