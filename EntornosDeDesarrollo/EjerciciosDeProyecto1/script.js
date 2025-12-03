// Victoria
//---- Modificacion incluida
const nombreDelJugador = prompt("ingrese su Nombre");

let g1 = 0;
let g2 = 0;

// Este es el juego
/**
 * @function juego
 * @param {string} usu  el usuario elige 
 */
function juego(usu) {
    const ele = ['piedra', 'papel', 'tijera'];
    const maq = ele[Math.floor(Math.random() * ele.length)]; //a ver lo que elige la maquina

    // Muestro cosas en pantalla
    document.getElementById('user-choice').textContent = `${nombreDelJugador}: ${usu}`;
    document.getElementById('computer-choice').textContent = `Elección de la máquina: ${maq}`;

    // ¿Quién gana? Creo que funciona
    let gana = '';

    if (usu === maq) {
        gana = 'Es un empate 🤝';

    } else if (
        (usu === 'piedra' && maq === 'tijera') ||
        (usu === 'papel' && maq === 'piedra') ||
        (usu === 'tijera' && maq === 'papel')
    ) {
        gana = `¡Gana! ${nombreDelJugador}!🎉`; g1++;
    } else {
        gana = 'Gana Maquina 🤖 😢';
        g2++;

    }


    // Ganador
    document.getElementById('winner').textContent = `Ganador: ${gana}`;

    // Puntos
    document.getElementById('user-wins').textContent = `${nombreDelJugador}: ${g1}`;
    document.getElementById('computer-wins').textContent = `Máquina: ${g2}`;
}
