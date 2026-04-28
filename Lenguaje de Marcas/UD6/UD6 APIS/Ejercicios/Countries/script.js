// 1º guardamos la API en una variable para no tener que escribirla cada vez.
const URL_API = "https://restcountries.com/v3.1";

//2º CONECTAMOS ELEMENTOS DE HTML 
//NECESITAMOS : input, formulario, contenedor de resultados, 
//tomamos estos elementos del HTML con EL "getElementById" buscamos el elemento que tenga ese id en el HTML


//SEECION 1 BUSCAR POR NOMBRE

//El formulario completo ( para escuchar el submit)
const forNombre = document.getElementById("form-nombre");

//campo de texto donde el usuario escribe el nombre
const inputNombre = document.getElementById("input-nombre");

//El div donde vamos a mostrar el resultado
const resultadoNombre = document.getElementById("resultado-nombre");



//SECCION 2 BUSCAMOS POR REGION

// Con "querySelectorAll" coge todos los elementos con esa clase una vez y devuelve una lista de botones, no uno solo.

const botonesRegion = document.querySelectorAll(".btn-region");

//El div donde vamos a mostrar las tarjetas paises.
const resultadoRegion = document.getElementById("resultado-region");

//SECCION 3 BUSCAMOS POR CAPITAL 
const formCapital = document.getElementById("form-capital");
const inputCapital = document.getElementById("input-capital");
const resultadoCapital = document.getElementById("resultado-capital");

//SECCION 4 BUSCAMOS POR CODIGO
const formCodigo = document.getElementById("form-codigo");
const inputCodigo = document.getElementById("input-codigo");
const resultadoCodigo = document.getElementById("resultado-codigo");

//SECCION 5 BOTON DE CARGAR TODOS 
// boton simple, no un formulario
const btnTodos = document.getElementById("btn-todos");
const resultados = document.getElementById("resultado-todos");

//3ª Funciones Unitarias. 
///Pequeñas funciones de apoyo que se reutilizan en varias partes del codigo.

/// Limpia el contenido de un contenedor 

function limpiarContenedor(contenedor) {
    if(contenedor){
        contenedor.innerHTML = "";
    }
}
//Muestra un mensaje de error en rojo dentro del contenedor
// Se usa cuando algo falla o el campo esta vacio

function mostrarError(contenedor, mensaje) {
    contenedor.innerHTML = `<p class="mensaje-error">${mensaje}</p>`;
}


/// Hace el fetch a cualquier URL, llamada de la API devuelve los datos. 
// Es async por que necesita esperar la respuesta
//Devuelve los datos o nulll si hay error

async function obtenerDatos(url) {
try {
        const respuesta = await fetch(url);
        if(!respuesta.ok) return null;
        const datos = await respuesta.json(); // Intenta esto...
        return datos;
    } catch (error) {
        console.error("La API falló, pero la página sigue viva"); // Si falla, haz esto.
        return null;
    }

    // se puede utilizar un trycatch. 
}

/// 4º: FUNCIONES DE EXTRACCION DE DATOS
// La api devuelve los datos en formatos complejos
//(arrays, objetos anidados...), estas funciones los convierten a textos simples y legibles

//la capital viene como array["mardid", "toledo",...];
// .join(",") lo convierte a texto: "Madrid, Toledo".

function extraerCapital(pais) {
    if (pais.capital) {
        return pais.capital.join(", ");

    }
    return "No disponible";
}

//Los idiomas vienen como objeto: {spa: "Sapanish", cat: "Catalan"}
//Object.values() extrae solo los valores: ["Spanish", "Catalan"]
//.join(", ") lo convierte a texto: "Spanish, Catalan"

function extraerIdiomas(pais) {
    if (pais.languages) {
        return Object.values(pais.languages).join(", ");
    }
    return "No disponible";
}
//Los continentes vienen como array: ["Europe"]
function extraerContinentes(pais) {
    if (pais.continents) {
        return pais.continents.join(", ");
    }
    return "No disponible";
}
function extraerMonedas(pais) {
    return pais.currencies ? Object.values(pais.currencies).map(m => m.name).join(", ") : "No disponible";
}
// 5ª FUNCIONES QUE CREAN TARJETAS HTML
// cada funcion recibe un Pais con sus datos y devuelve un texto con HTML listo para meter en la pagina
//y devuelve un texto con HTML listo para meter en la pagina 
//Los backticks `` permiten escribir HTML en varias lineas y meter variables con ${}


//TARJETA GRANDE CON TODOS LOS DETALLES DEL PAIS
//Se usa en: buscar por nombre

function crearTarjetaDetallePais(pais) {
    return `
            <article class = "tarjeta-detalle">
                <img src="${pais.flags.svg}" alt="Bandera de ${pais.name.common}">
                <div class="info-detalle">
                    <h3> ${pais.name.common}</h3>
                    <p><strong>Nombre Oficial: </strong> ${pais.name.official}</p>
                    <p><stron> Capital: </strong> ${extraerCapital(pais)}</p>
                    <p><strong>Región:</strong> ${pais.region}</p>
                    <p><strong>Subregión:</strong> ${pais.subregion || "No disponible"}</p>
                    <p><strong>Población:</strong> ${pais.population.toLocaleString()}</p>
                    <p><strong>Idiomas:</strong> ${extraerIdiomas(pais)}</p>
                    <p><strong>Monedas:</strong> ${extraerMonedas(pais)}</p>
                </div>
            </article>`;
}

//TARJETA PEQUEÑA CON DATOS BASICOS 
// En usa en : seccion de regiones
// tarjeta con enlace a Google Maps 
//Se usa en: busqueda por capital

function crearTarjetaCapital(pais) {
    return `
    <article class ="targeta-detalle">
        <img src="${pais.flags.svg}" alt="Bandera de ${pais.name.common}">
        div class =info-detalle">
            <h3>${pais.name.common}</h3>
            <p>Capital:${extraerCapital(pais)}</p>
            <p>Region: ${pais.region}</p>
            <a href="${pais.maps.googleMaps}" target="_blank"> Ver en GoogleMaps</a>
        </div>
    </article>`;
}


// Tarjeta con códigos y datos geográficos
// Se usa en: búsqueda por código
function crearTarjetaCodigo(pais) {
    return `
        <article class="tarjeta-detalle">
            <img src="${pais.flags.svg}" alt="Bandera de ${pais.name.common}">
            <div class="info-detalle">
                <h3>${pais.name.common}</h3>
                <p>Código CCA2: ${pais.cca2}</p>
                <p>Código CCA3: ${pais.cca3}</p>
                <p>Continentes: ${extraerContinentes(pais)}</p>
            </div>
        </article>`;
}

// Tarjeta pequeña con datos básicos
// Se usa en: lista rápida de todos los países
function crearTarjetaListaRapida(pais) {
    return `
        <article class="tarjeta">
            <img src="${pais.flags.svg}" alt="Bandera de ${pais.name.common}">
            <h3>${pais.name.common}</h3>
            <p>Capital: ${extraerCapital(pais)}</p>
            <p>Población: ${pais.population.toLocaleString()}</p>
        </article>`;
}

///6º FUNCIONES PRINCIPALES
//Aqui ocurre toda la logica de cada seccion
//SIEMPRE  sigue el siguiente orden:
//1.Limpiar el contenedor
//2.Validar que el input no esta vacio
//3.Llama a la API con obtenerDatosDeApi()
//4.si hay datos --> mostrar tarjeta
//5.si no hay datos --> mostramos error

//-- SECCION 1 BUSCA POR NOMBRE
async function buscarPaisPorNombre(nombreDelPais) {
    //1.limpiamos el contenedor 
    limpiarContenedor(resultadoNombre);

    //2.El usuario no escribio nada, mostramos error y paramos

    if (!nombreDelPais) {
        mostrarError(resultadoNombre, "Introduce un nombre de pais");
        return; //"Retrun" sale de la funcion, no sigue ejecutando
    }

    //3.Llamamos a la API con el nombre que escribio el usuario
    const listaPaises = await obtenerDatos(`${URL_API}/name/${nombreDelPais}`);

    // 4. Si la API devolvió datos, mostramos la tarjeta del primer resultado
    if (listaPaises) {
        // La API devuelve un array, cogemos el primero con [0]
        resultadoNombre.innerHTML = crearTarjetaDetallePais(listaPaises[0]);
    } else {
        // 5. Si no hay datos, mostramos mensaje de error
        mostrarError(resultadoNombre, "País no encontrado");
    }
}

    // SECCION 2 PAISES POR REGION
    // No se necesita validar el input por que el dato viene de un boton, no de lo que escribe el usuario

    async function buscarPaisesPorRegion(nombreRegion) {
        //1.limpiamos antes el contenedor
        limpiarContenedor(resultadoRegion);

        //3. Llamamos a la API con la region del boton pulsado
        const listaPaises = await obtenerDatos(`${URL_API}/region/${nombreRegion}`);

        //4. si hay datos creamos una tarjeta por cada pais

        if (listaPaises) {
            let htmlTarjetas = "";
            // slice(0, 12) coge solo los primeros 12 países de la lista
            // forEach recorre esos 12 países uno por uno
            // "pais" representa cada país en cada vuelta del bucle
            // En cada vuelta añadimos su tarjeta al texto HTML
            listaPaises.slice(0, 12).forEach(function (pais) {
                htmlTarjetas += crearTarjetaListaRapida(pais);
            });

            // Metemos todas las tarjetas juntas en el contenedor
            resultadoRegion.innerHTML = htmlTarjetas;
        } else {
            //5. si falla mostramos error
            mostrarError(resultadoRegion, "Error al cargar la region");
        }
    }

    // SECCION 3 BUSCAMOS POR CAPITAL
    async function buscarPaisPorCapital(nombreCapital) {
        //Limpiamos lo anterior
        limpiarContenedor(resultadoCapital);

        //2 validamos que no este vacio
        if (!nombreCapital) {
            mostrarError(resultadoCapital, "introduce una capital");
            return;
        }
        //3. Llamamos a la API con la capital
        const listaPaises = await obtenerDatos(`${URL_API}/capital/${nombreCapital}`);

        if (listaPaises) {
            resultadoCapital.innerHTML = crearTarjetaCapital(listaPaises[0]);
        } else {
            // 5. Error si no se encuentra
            mostrarError(resultadoCapital, "Capital no encontrada");
        }
    }

    // --- SECCIÓN 4: Buscar por código ---
    async function buscarPaisPorCodigo(codigoPais) {

        // 1. Limpiamos lo anterior
        limpiarContenedor(resultadoCodigo);

        // 2. Validamos que no esté vacío
        if (!codigoPais) {
            mostrarError(resultadoCodigo, "Introduce un código de país");
            return;
        }

        // 3. Llamamos a la API con el código
        const resultado = await obtenerDatos(`${URL_API}/alpha/${codigoPais}`);

        // 4. Mostramos el resultado
        if (resultado) {
            // A veces la API devuelve un array, a veces un objeto solo
            // Con esta línea cubrimos los dos casos:
            // Si es array cogemos el primero, si no lo usamos directamente
            const datosPais = Array.isArray(resultado) ? resultado[0] : resultado;
            resultadoCodigo.innerHTML = crearTarjetaCodigo(datosPais);
        } else {
            // 5. Error si el código no existe
            mostrarError(resultadoCodigo, "Código no válido");
        }
    }

    // --- SECCIÓN 5: Cargar todos los países ---
    // No necesita input ni validación, solo se activa con el botón
    async function cargarTodosLosPaises() {

        // 1. Limpiamos lo anterior
        limpiarContenedor(resultados);

        // 3. Llamamos a la API
        // ?fields= le dice a la API que solo nos mande esos campos
        // así la respuesta es más ligera y rápida
        const listaPaises = await obtenerDatos(`${URL_API}/all?fields=name,flags,capital,population`);

        // 4. Si hay datos mostramos las tarjetas
        if (listaPaises) {
            let htmlTarjetas = "";

            // slice(0, 12) coge solo 12 países
            // forEach recorre esos 12 países uno a uno
            // "pais" es cada país en cada vuelta del bucle
            listaPaises.slice(0, 12).forEach(function (pais) {
                htmlTarjetas += crearTarjetaListaRapida(pais);
            });

            resultados.innerHTML = htmlTarjetas;
        } else {
            // 5. Error si falla la carga
            mostrarError(resultados, "Error al cargar los países");
        }
    }

    // ============================================
    // PASO 6: EVENTOS
    // Conectan las acciones del usuario con las funciones
    // Van SIEMPRE al final, cuando todas las funciones
    // ya están definidas arriba
    //
    // addEventListener escucha lo que hace el usuario:
    //   "submit" → cuando envía un formulario
    //   "click"  → cuando pulsa un botón
    // ============================================

    // Sección 1: cuando el usuario envía el formulario de nombre
    forNombre.addEventListener("submit", function (eventoFormulario) {
        // preventDefault evita que la página se recargue al enviar el formulario
        eventoFormulario.preventDefault();
        // .trim() elimina espacios al inicio y al final
        // .toLowerCase() convierte a minúsculas para que la API lo entienda
        buscarPaisPorNombre(inputNombre.value.trim().toLowerCase());
    });

    forNombre.querySelector("button").onclick = () => buscarPaisPorNombre(inputNombre.value.trim());
    // Sección 2: cuando el usuario pulsa uno de los botones de región
    // forEach recorre cada botón de la lista uno por uno
    // "botonRegion" representa cada botón en cada vuelta del bucle
    // A cada botón le añadimos su propio evento de click
    botonesRegion.forEach(function (botonRegion) {
        botonRegion.addEventListener("click", function () {
            // dataset.region lee el atributo data-region del HTML
            // Ejemplo: <button data-region="europe"> → dataset.region = "europe"
            buscarPaisesPorRegion(botonRegion.dataset.region);
        });
    });

    // Sección 3: cuando el usuario envía el formulario de capital
    formCapital.addEventListener("submit", function (eventoFormulario) {
        eventoFormulario.preventDefault();
        buscarPaisPorCapital(inputCapital.value.trim().toLowerCase());
    });

    // Sección 4: cuando el usuario envía el formulario de código
    formCodigo.addEventListener("submit", function (eventoFormulario) {
        eventoFormulario.preventDefault();
        buscarPaisPorCodigo(inputCodigo.value.trim().toLowerCase());
    });

    // Sección 5: cuando el usuario pulsa el botón de cargar todos
    // No necesita eventoFormulario porque es un botón simple, no un formulario
    btnTodos.addEventListener("click", function () {
        console.log("boton pulssado correctamente");
        cargarTodosLosPaises();
    });

