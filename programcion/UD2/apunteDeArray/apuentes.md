#ARRAYS EN JS

para una suma utilizaremos:

- creamos una variable acumuladora (suma = 0) 
- un bucle for (con el cual lo recorre)
- añadimos a cada elemento una `suma`
  

Ejemplo:
dado el Array let numeros =[3,7,2,9]; calcula la suma total

```js

let numeros =[ 3,7,2,9];
let suma = 0
for(let i=0; i< numeros.length;i++){
    suma += numeros[i];
}
console.log(suma) //21
```


para buscar un numero que son mayores que "x numeros" ejemplo 10 

contar cuantos numeros son mayores que 10

```js
let numeros = [4,15,3,22,11]
let contador = 0;

for(let i=0; i< numeros.legth ; i++){
    if(numero[i]>10){
        contador++
    }
}
console.log (contador);//3

```
para obtener un numero mayor

ejemplo :

Encuentra el valor mas grande del array let numeros = [10,4,22,3]

```js
let numero = [10,4,22,3]
let numeroMax= numero[0]

for(let i= 1 ; i <numero.length; i++){
    if (numero[i]> numeroMax){
        numeroMax = numero[i]
    }
} console.log(max);// 22
```


para vaciar un array hay que usar un for inverso. ejemplo.

```js
for (let i=0;puntuaciones.lenght; i-- ){
    puntuaciones.pop()
}
console.log(puntuaciones)

o



while (puntuaciones>0){
    puntuaciones.pop()
}
```

