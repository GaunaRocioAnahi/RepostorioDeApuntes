// =======================================================
// 1. DEFINICIONES GLOBALES, ARRAYS Y CONFIGURACIÓN
// =======================================================

/**
 * @type {string[]}
 * @description Array de palabras clave relacionadas con tecnología para el juego.
 */
const palabras = ["teclado", "router", "archivo", "software", "hardware", "firewall", "navegador", "servidor", "algoritmo", "backup", "kernel", "encriptar", "procesador", "ciberseguridad", "virtualizacion"];

/**
 * @type {number}
 * @description El número máximo de intentos fallidos permitidos antes de perder el juego.
 */
const maxErrores = 6;

/**
 * @type {string}
 * @description La palabra elegida al azar del array `palabras`.
 */
const palabraSecreta = palabras[Math.floor(Math.random() * palabras.length)];

/**
 * @type {string}
 * @description La representación de la palabra secreta con guiones bajos y espacios (e.g., "_ _ _ _").
 */
let palabraOculta = palabraSecreta.replace(/./g, '_ ');

/**
 * @type {number}
 * @description Contador de errores o intentos fallidos del jugador. Inicializado en 0.
 */
let contadorErrores = 0;


// =======================================================
// 2. FUNCIONES AUXILIARES (Lógica de bajo nivel)
// =======================================================

/**
 * @function reemplazarEn
 * @description Reemplaza un carácter en una posición específica de una cadena de texto.
 * @param {string} cadena - La cadena original (e.g., palabraOculta).
 * @param {number} indice - La posición (índice) donde se debe insertar el nuevo carácter.
 * @param {string} caracter - El carácter (letra) que se va a insertar.
 * @returns {string} La nueva cadena con el carácter reemplazado.
 */
const reemplazarEn = (cadena, indice, caracter) => {
    // Usa substring para cortar la cadena y pegar el nuevo carácter
    return cadena.substring(0, indice) + caracter + cadena.substring(indice + caracter.length);
}


// =======================================================
// 3. FUNCIÓN PRINCIPAL DEL JUEGO (Lógica de alto nivel)
// =======================================================

/**
 * @function evaluarLetra
 * @description Función principal del juego. Obtiene la entrada del usuario,
 * comprueba si la letra está en la palabra secreta, actualiza el estado
 * del juego (errores, palabra oculta) y verifica las condiciones de fin de juego.
 * @returns {void} No devuelve nada directamente, pero manipula el DOM.
 */
const evaluarLetra = () => {
    // 3.1. Obtener y validar la entrada
    const inputElement = document.querySelector('input');
    const letra = inputElement.value.toLowerCase().trim();

    // Comprobación de que la entrada es una única letra (a-z o ñ)
    if (letra.length !== 1 || !/^[a-zñ]$/.test(letra)) {
        alert("Por favor, introduce una única letra válida.");
        inputElement.value = '';
        return;
    }

    let acierto = false;

    // 3.2. Comprobar la letra
    for (let i = 0; i < palabraSecreta.length; i++) {
        if (palabraSecreta[i] === letra) {
            // Multiplicamos el índice por 2 para apuntar al guion bajo
            palabraOculta = reemplazarEn(palabraOculta, i * 2, letra);
            acierto = true;
        }
    }

    // Limpiar la entrada después de la comprobación
    inputElement.value = '';

    // 3.3. Lógica de acierto/error y estado del juego
    if (!acierto) {
        contadorErrores++;
        document.querySelector('.contadorErrores').innerHTML = `Errores: ${contadorErrores} de ${maxErrores}`;

        // Lógica de Pérdida
        if (contadorErrores >= maxErrores) {
            document.querySelector('.container').innerHTML = `<h1>❌ ¡Has perdido! 😢 La palabra era: **${palabraSecreta.toUpperCase()}**</h1>`;
            return;
        }
    }

    // 3.4. Actualizar la interfaz (DOM)
    document.querySelector('.letraOculta').innerHTML = palabraOculta;

    // Lógica de Ganar
    if (!palabraOculta.includes('_')) {
        document.querySelector('.container').innerHTML = '<h1>✅ ¡Felicidades! ¡Has ganado! 🎉</h1>';
    }
}


// =======================================================
// 4. INICIALIZACIÓN (Conexión con el DOM)
// =======================================================

/**
 * @event DOMContentLoaded
 * @description Evento disparado cuando el documento HTML ha sido completamente cargado y parseado.
 * Se utiliza para asegurar que el script manipule elementos que ya existen.
 */
document.addEventListener('DOMContentLoaded', () => {
    // Muestra el estado inicial de la palabra (guiones)
    document.querySelector('.letraOculta').innerHTML = palabraOculta;
    
    // Asocia la función evaluarLetra al evento 'click' del botón
    document.querySelector('button').addEventListener('click', evaluarLetra);
});