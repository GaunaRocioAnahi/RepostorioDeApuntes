# DOM

para hacer el dom en js,
tengo que identificar ¿que elemento quiero tocar?
¿como lo identifico desde JS?
¿que quiero que haga?

En JS hay dos formas principales de para usar las clases:

`id` = "contador"
se usa el document.getElementById('contador');

`class` = "card"
se usa el document.querySelector('.card'); //encuentra el PRIMERO que tenga en esa clase
o
document.querySelector('.card')// encuentra TODOS los que tengan en esa clase.
**REGLA**
si es unico en la pagina (un contador, un boton de busqueda) usa id y getElementById.
si hay varias iguales(todas las cards) usa class y querySelectorAll.

## Leer o cambiar texto

elemento.textContent = "texto nuevo" // cambia lo que se ve escrito del elemento

## CREA UN ELEMENTO NUEVO EN EL HTML

**boton**
const boton = document.createElement('button') // crea un boton en memoria, todavia no aparece en la pagina

boton.textContent ="Haz clic" // añades texto al boton

padre.appendChild(boton) // Lo metes dentro de un elemento que ya existe en el HTML

## ESCUCHA UN CLICK

boton.addEventListener('click',() =>{
    //Todo loq ue este aqui dentro se ejecuta cuando alguien hace clic
});

----

### bloque de boton favorito

El enunciado pide que cada tarjeta necesita un boton.
que cualdo lo pulsas cambia el texto, la tarjeta cmabia visualmente y si lo vuelves a pulsar se deshace.

como es en cada tarjeta que en este caso son 5. verificamos la class donde esta por que son varias acuerdate de la regla

class = "card" como se aplican a 5 usamos un querySelectorALL('.card)
con esta class armamos una constante de la clase ejemplo tarjetas

`const tarjetas = document.querySelectorAll('.card');`

ahora podemos recorrer cada una de las tarjetas con un forEach. ( por cada tarjeta añade un boton fav.) const en plural, recorre en singular.
```js
tarjetas.forEach(tarjeta)=>{
// en este recorrido creamos el elemento boton

//creo el boton
const botonFav= documentCreateElement('button');

//agrego el texto al boton
botonFav.textContent = "Añadir fav";

//añadimos la class para darle estilo en css
botonFav.classList.add('btn-fav');

tarjeta.appenchild(botonFav);

// agregamos la funcion al boton cuando haga clic

botonFav.addEventList('click',() =>{
        // toggle es el concepto más importante aquí:
        // Si la tarjeta NO tiene la clase 'favorito' → se la añade
        // Si la tarjeta YA tiene la clase 'favorito' → se la quita
        // Así funciona el marcar y desmarcar
        tarjeta.classList.toggle('favorito');
        // cambio el boton segun el estado 
        //contains comprueba si el elemento tiene esa clase en ese momento
        if(tarjeta.classList.contains('favorito')){
            //si tiene la clase, es por que acaba de marcarse como favorito
            botonFav.textContent = "guardado";

        }else{
            // sino tiene la clase, es por que acaba de desmarcarse
            botonFav.textContent = "Añadir favorito";
        }
})

}
```

luego en css añadimos la clase `.favorito` para que visualmente se vea el cambio

```css
/* Esta clase la añade y quita JavaScript con el toggle */
/* La tarjeta cambia de fondo cuando está marcada como favorita */
.favorito {
    border: 2px solid gold;
    background-color: #fffbea;
}
```

para contar la tarjeta que pide el enunciado necesitamos un contador. que va en una etiqueta en especifica `.page-hero` una clase

```js
// se crea el parrafo ( en memoria)
const contador= document.createElement('p');

//añado el texto al parrrafo 

//TOMAMOS LA CONSTANTE Y AÑADIMOS EL PARRAFO CON texcontent y añadimo el personaje destacado en este caso el personaje destacado es contando las tarjetas y length cuenta cada una
contador.textContent = `Personajes destacados : ${tarjetas.length} `;

//ahora buscamos donde podemos añadirlo, en el ejemplo lo usamos en la class = page-hero, declaramos una constante hero para luego verificar con una condicional 

const hero = document.querySelector('.page-hero');

// ahora si verificamos con la constante declarada de que exista. y lo añadimos con el .appenchild

if(hero){
    hero.appenChild(contador);
}


```


