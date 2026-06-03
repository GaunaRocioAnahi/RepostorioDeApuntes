const API_URL = "https://rickandmortyapi.com/api/character"
const TOTAL_PERSONAJES = 200;
// 1. EL ARRAY DE DATOS: Debe estar arriba para que todo lo demás pueda leerlo.
const personaje = [
    { id: "1", nombre: "Rick Sanchez", imagen: "https://i.pinimg.com/736x/76/6d/ea/766deaf4d28044a4bd09c9d8ef3f9406.jpg", especie: "Humano", estado: "Vivo" },
    { id: "2", nombre: "Morty Smith", imagen: "https://i.pinimg.com/736x/d8/64/bf/d864bfe6cc61c2862fc478fab48e3311.jpg", especie: "Humano", estado: "Vivo" },
    { id: "3", nombre: "Summer Smith", imagen: "https://i.pinimg.com/736x/67/56/dc/6756dcf8b31dacdf551a22195644c1e6.jpg", especie: "Humana", estado: "Viva" },
    { id: "4", nombre: "Beth Smith", imagen: "https://i.pinimg.com/736x/9c/d3/23/9cd323baab2f396cbaf676f27ee830ad.jpg", especie: "Humano", estado: "Vivo" },
    { id: "5", nombre: "Jerry Smith", imagen: "https://i.pinimg.com/736x/4f/14/e4/4f14e48d750130a8f1636214ce090abd.jpg", especie: "Meeseeks", estado: "Variable" }
];

// =====================================================
// ------ CAMBIOS EN LA TARJETAS ------------------
//======================================================

const tarjetas = document.querySelectorAll('.card');

//RECORREMOS las tarjetas. con un for-each

//llamamos al conjunto de tarjeta recorrida con el querySelectorAll, y lo recorremos con el forEach
//dentro del parentesis agregamos a la tarjeta tambien.
//significa y se lee que por cada tarjeta hace algo. 
tarjetas.forEach((tarjeta) => {

    //DENTRO CREAMOS un boton para favoritos primero lo nombramos con el .createElement('button')
    const botonFav = document.createElement('button');

    //Luego con el .textContent AGREGAMOS EL TEXTO de "añadir favorito" al boton
    botonFav.textContent = "Añadir favorito ⭐";

    // como AÑADIMOS EL BOTON A CADA TARJETA el boton luego el texto, ahora tenemos que agregar ese boton a cada tarjeta. 
    botonFav.classList.add('btn-fav');

    //luego AGREGAMOS DENTRO DE LA TARJETA.
    tarjeta.appendChild(botonFav);

    //ACCION DEL CLICK: buscamos que cambie el texto, cambie el estilo y lo pueda revertir
    // cuando haga click ejecuta el codigo seguido
    botonFav.addEventListener('click', () => {
        // agregado de css, agregamos una clase al css

        tarjeta.classList.toggle('favorito');
        //TOGGLE piensa lo siguiente, si NO tiene la clase: agregala, si YA tiene la clase: QUITALA
        // SIRVE COMO PARA PENSAR EL MARCAR Y DESMARCAR DE FAVORITO. 
        // usamos lo siguiente para esta condicion que me dice si la clase tarjeta contiene una clase favorito

        if (tarjeta.classList.contains('favorito')) {
            botonFav.textContent = "Guardado";
        } else {
            botonFav.textContent = "Añadir favorito ⭐";
        }
    });


});
///=========================================================
// CONTADOR
//============================================================
// Agregamos el elemento de parrafo
const contador = document.createElement('p');

//Agregamos el texto del parrafo

contador.textContent = `Personaje Destacados :  ${tarjetas.length}`;

// lo agregamos en la class = .page-hero
const hero = document.querySelector('.page-hero');

if (hero) {

    hero.appendChild(contador);

}

//==========================================================
// interaccion con le boton ver mas - detalle.html
//==========================================================

// buscamos y seleccionamos todos los botones  de cada tarjeta
const botones = document.querySelectorAll('.btn-detalle');

//RECORREMOS con un foreach

botones.forEach((boton) => {
    // ACCION del boton al hacer el click 
    boton.addEventListener('click', () => {

        //declaramos id, por que lo necesitamos al llamado
        const id = boton.dataset.id;

        //cambia de pagina
        window.location.href =
            `src/detalle.html?id=${id}`;
    });

});
// obtiene el ?id=1 un ejemplo
const params = new URLSearchParams(window.location.search);

// declaramos una bariable que nos traiga el id
const id = params.get('id'); // lectura de parametros

//==========================================================
// SEGUNDO INCREMENTO
//==========================================================

// llamamos a la api, pedimos a la api el personaje con el id. por eso llamamos al id

async function cargarPersonaje() {
    //fetch busca datos en la api   
    const respuesta = await fetch(`${API_URL}/${id}`);
    // la api devuelve esa respuesta en json para mostrarlos
    const datos = await respuesta.json();


    // mostramos a los personajes en el html
    //muestro el nombre
    document.getElementById('nombre-personaje')
        .textContent = datos.name;

    //mostramos la imagen
    document.getElementById('imagen-personaje')
        .src = datos.image;

    // mostramo la especie
    document.getElementById('specie-personaje')
        .textContent = datos.species;

    //mostramos el estado
    document.getElementById('estado-personaje')
        .textContent = datos.status;


    // Interaccion con el boton de ficha
    const ficha = document.querySelector('.detail__facts');

    // CREAMOS el boton de Ocultar ficha 
    const boton = document.createElement('button');
    boton.classList.add('btn-ficha');

    boton.textContent = "Ocultar ficha";

    ficha.before(boton);
    // le damos funcionamiento al boton 
    boton.addEventListener('click', () => {
        ficha.classList.toggle('oculto');

        if (ficha.classList.contains('oculto')) {
            boton.textContent = "Mostrar ficha";
        } else {
            boton.textContent = "Ocultar ficha";
        }
    });
};

if (id) { cargarPersonaje(); }
//===============================================
// BUSCAMOS PERSONAJE
//===============================================

async function buscarPersonaje() {
    //leemos el input de busqueda de personaje
    const input = document.getElementById('busqueda-personaje');
    const valor = input.value.trim();
    const esNumero = Number(valor);

    let urlFinal;
    // llamamos a una condificion para ver si lo ingresado fue un nuemero o un nombre un string 
    if (Number.isInteger(esNumero)) {

        urlFinal = `${API_URL}/${valor}`;

    } else {
        urlFinal = `${API_URL}/?name=${valor}`;
    }
    const contenedor = document.getElementById('resultado-busqueda');

    try {
        const respuesta = await fetch(urlFinal);
        const datos = await respuesta.json();

        if (datos.error) {
            throw new Error("No encontrado");
        }
        const personajeEncontrado = datos.results ? datos.results[0] : datos;


        contenedor.innerHTML = `
            <article class="card">
                <img src="${personajeEncontrado.image}" alt="${personajeEncontrado.name}">
                <div class="card__body">
                    <h2 class="card__title">${personajeEncontrado.name}</h2>
                    <p class="card__meta">Especie: ${personajeEncontrado.species}</p>
                    <p class="card__meta">Estado: ${personajeEncontrado.status}</p>
                </div>
            </article>
        `;
        // fijarse que no carga bien las tarjetas. 
    } catch (error) {
        contenedor.innerHTML = "<p> No se ha encontrado ningun perosnaje con esos datos. </p>"
    }

}
// conectamos al boton
const boton = document.getElementById('btn-buscar');
if (boton) {
    boton.addEventListener('click', buscarPersonaje);
}

//====================================================
// ALEATORIO
// ===================================================
async function personajeAleatorio() {

    // Math.random() genera un número decimal entre 0 y 1 (ejemplo: 0.473)
    // Multiplicamos por TOTAL_PERSONAJES para obtener un número entre 0 y 826
    // Math.floor() redondea hacia abajo para obtener un número entero
    // Le sumamos 1 porque los ids de la API empiezan en 1, no en 0
    const idAleatorio = Math.floor(Math.random() * TOTAL_PERSONAJES) + 1;

    // Buscamos el contenedor del resultado aleatorio (zona separada del buscador)
    const contenedor = document.getElementById('resultado-aleatorio');

    try {
        // Hacemos fetch con el id aleatorio que acabamos de generar
        const respuesta = await fetch(`${API_URL}/${idAleatorio}`);

        // Convertimos la respuesta a objeto JavaScript
        const datos = await respuesta.json();

        // Mostramos el personaje aleatorio en su contenedor
        contenedor.innerHTML = `
            <article class="card">
                <img src="${datos.image}" alt="${datos.name}">
                <div class="card__body">
                    <h2 class="card__title">${datos.name}</h2>
                    <p class="card__meta">Especie: ${datos.species}</p>
                    <p class="card__meta">Estado: ${datos.status}</p>
                </div>
            </article>
        `;

    } catch (error) {
        // Si algo falla mostramos un mensaje de error
        contenedor.innerHTML = "<p>No se pudo cargar el personaje aleatorio</p>";
    }
}

// Conectamos el botón aleatorio con la función personajeAleatorio
const botonAleatorio = document.getElementById('btn-aleatorio');

// Comprobamos que el botón existe antes de añadir el evento
if (botonAleatorio) {
    botonAleatorio.addEventListener('click', personajeAleatorio);
}
