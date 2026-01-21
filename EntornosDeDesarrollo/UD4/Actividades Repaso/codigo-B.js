/**
 * Suma los valores de una lista de números que son mayores a un umbral específico.
 * @param {number[]} listaNumeros - Array de números a evaluar.
 * @param {number} valorUmbral - El valor mínimo para considerar un número en la suma.
 * @returns {number} La suma total de los números que superan el umbral.
 */
function sumarValoresMayoresQue(listaNumeros, valorUmbral) {
    let sumaTotal = 0;

    for (let i = 0; i < listaNumeros.length; i++) {
        const numeroActual = listaNumeros[i];

        if (numeroActual > valorUmbral) {
            sumaTotal += numeroActual;
        }
    }

    return sumaTotal;
}