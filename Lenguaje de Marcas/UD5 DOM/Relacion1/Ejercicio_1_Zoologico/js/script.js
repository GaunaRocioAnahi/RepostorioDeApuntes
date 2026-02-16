// PASO 1: Cambiar color de fondo al cargar la página
// Teoría: getElementsByClassName() devuelve una HTMLCollection con todos los elementos que tienen esa clase
const animales = document.getElementsByClassName('animal');

// Teoría: Recorremos la colección con un bucle for tradicional
// i empieza en 0, continúa mientras sea menor que la cantidad de elementos
for (let i = 0; i < animales.length; i++) {
    // Teoría: .style.backgroundColor modifica el color de fondo del elemento
    animales[i].style.backgroundColor = 'lightyellow';
}


// PASO 2: Funcionalidad del botón "Resaltar Animales"
// Teoría: getElementById() obtiene el elemento con ese ID único
const boton = document.getElementById('resaltarAnimales');

// Teoría: addEventListener() ejecuta una función cuando ocurre el evento 'click'
boton.addEventListener('click', function() {
    
    // Volvemos a obtener los elementos con clase 'animal'
    const animales = document.getElementsByClassName('animal');
    
    // Teoría: Recorremos todos los elementos con un bucle for
    for (let i = 0; i < animales.length; i++) {
        // Cambiamos el color del texto a verde
        animales[i].style.color = 'green';
        
        // Aumentamos el tamaño de la fuente
        animales[i].style.fontSize = '24px';
    }
});