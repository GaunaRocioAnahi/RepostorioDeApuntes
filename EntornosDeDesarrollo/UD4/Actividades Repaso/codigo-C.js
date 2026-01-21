/**
 * Compara tres valores numéricos y devuelve el mayor de ellos,
 * pero únicamente si todos son diferentes entre sí.
 *
 * @param {number} valorA - El primer número a comparar.
 * @param {number} valorB - El segundo número a comparar.
 * @param {number} valorC - El tercer número a comparar.
 * @returns {number|boolean} El número mayor si son únicos, o `false` si hay algún duplicado.
 */
function obtenerMayorSiSonUnicos(valorA, valorB, valorC) {
    // 1. Verificación de seguridad: comprobar si hay duplicados
    // Es buena práctica guardar condiciones complejas en variables con nombre descriptivo.
    const hayDuplicados = (valorA === valorB) || (valorA === valorC) || (valorB === valorC);

    if (hayDuplicados) {
        return false;
    }

    // 2. Lógica de negocio: encontrar el mayor
    if (valorA > valorB && valorA > valorC) {
        return valorA;
    }

    if (valorB > valorA && valorB > valorC) {
        return valorB;
    }

    // Si no es A ni B, por descarte el mayor es C
    return valorC;
}