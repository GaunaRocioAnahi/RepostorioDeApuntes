// =============================
// 📌 Variables globales
// =============================

/**
 * @type {string[]}

 */

//añadir un arrays de palabras al azar
let palabras = [
    "teclado", "router", "archivo", "software", "hardware", "firewall",
    "navegador", "servidor", "algoritmo", "backup", "kernel",
    "encriptar", "procesador", "ciberseguridad", "virtualizacion"
];

/**
 * @type {number}
 * @description Número máximo de intentos permitidos.
 */
// cuenta los intentos a realizar, y si falla lo marca como error
let maxErrores = 6;

/**
 * @type {string}
 * @description Palabra elegida aleatoriamente.
 */

//busca la palabra secreta al azar. 
let palabraSecreta = palabras[Math.floor(Math.random() * palabras.length)];

/**
 * @type {string}
 * @description Palabra oculta, mostrada como "_ _ _ _".
 */

// reemplaza la palabra secreta por espacios y guiones.
let palabraOculta = palabraSecreta.replace(/./g, "_ ");

/**
 * @type {number}
 * @description Contador de errores cometidos.
 */

// el contador de erres es cero para que empiece
let contadorErrores = 0;


// =============================
// 📌 Funciones
// =============================

/**
 * @function reemplazarEn
 * @description Reemplaza un carácter en un índice específico dentro de una cadena.
 * @param {string} cadena - La cadena original.
 * @param {number} indice - El índice donde insertar el carácter.
 * @param {string} caracter - El carácter a insertar.
 * @returns {string} Nueva cadena con el carácter reemplazado.
 */

//  esta funcion toma de la palabra oculta y reemplaza los guiones por la letra que adivino o increso el jugador
function reemplazarEn(cadena, indice, caracter) {
    return cadena.slice(0, indice) + caracter + cadena.slice(indice + 1);
}

/**
 * @function evaluarLetra
 * @description Función principal del juego: valida la letra, actualiza la palabra oculta y gestiona errores.
 * @returns {void}
 */
function evaluarLetra() {
    // Obtener la letra del input, es la variable que almacena el gracias al document para que se vea en la pagina web
    let inputElement = document.querySelector("input");
    let letra = inputElement.value.toLowerCase().trim();

    // Validar la entrada: solo una letra a-z o ñ, !==1 que solo añade una letra a la vez
    if (letra.length !== 1 || !/^[a-zñ]$/.test(letra)) {
        alert("Por favor, introduce una única letra válida.");
        inputElement.value = "";
        return;
    }

    let acierto = false;

    // Comprobar si la letra existe en la palabra secreta
    for (let i = 0; i < palabraSecreta.length; i++) {
        if (palabraSecreta[i] === letra) {
            palabraOculta = reemplazarEn(palabraOculta, i * 2, letra);
            acierto = true;
        }
    }

    // Limpiar el input, lo vacia para volver a intentar. 
    inputElement.value = "";

    // Gestionar errores
    if (!acierto) {
        contadorErrores++;
        document.querySelector(".contadorErrores").innerHTML =
            "Errores: " + contadorErrores + " de " + maxErrores;

        // Condición de pérdida
        if (contadorErrores >= maxErrores) {
            document.querySelector(".container").innerHTML =
                "<h1>❌ ¡Has perdido! 😢 La palabra era: <strong>" +
                palabraSecreta.toUpperCase() +
                "</strong></h1>";
            return;
        }
    }

    // Actualizar la palabra oculta en pantalla
    document.querySelector(".letraOculta").innerHTML = palabraOculta;

    // Condición de victoria
    if (palabraOculta.indexOf("_") === -1) {
        document.querySelector(".container").innerHTML =
            "<h1>✅ ¡Felicidades! ¡Has ganado! 🎉</h1>";
    }
}

/**
 * @function inicializarJuego
 * @description Inicializa el juego mostrando la palabra oculta y asociando el botón a la función evaluarLetra.
 */
function inicializarJuego() {
    // Mostrar estado inicial de la palabra
    document.querySelector(".letraOculta").innerHTML = palabraOculta;

    // Asociar la función evaluarLetra al botón
    document.querySelector("button").addEventListener("click", evaluarLetra);
}


// =============================
// 📌 Evento principal
// =============================

document.addEventListener("DOMContentLoaded", inicializarJuego);
