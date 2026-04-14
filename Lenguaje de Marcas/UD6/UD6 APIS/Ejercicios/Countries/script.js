// 1º usamos la url 
const urlApi = "https://restcountries.com/v3.1";

// funcion para mostrar errores en un contenedor

function mostrarError( idContenedor, mensaje){
    const contenedor = document.getElementById(idContenedor);
    contenedor.innerHTML =`<div class="mensaje-error>"${mensaje}</div>`;

}

// busca el pais por nombre
// Usamos 'submit' en el formulario para que funcione tanto el CLICK como la tecla ENTER
document.querySelector('#form-nombre button').addEventListener('click', async () => {
    const nombre =  document.getElementById('input-nombre').value.trim();
    const contenedor = document.getElementById('resultado-nombre');


    try{
        const respuesta = await fetch(`${urlApi}/name/${nombre}`);
        if(!respuesta.ok) throw new Error ( "Pais no encontrado.");

        const datos = await respuesta.json();
        const pais = datos[0];

        contenedor.innerHTML = `
            <div class="tarjeta-detalle">
                <img src="${pais.flags.svg}" alt="Bandera">
                <div class="info-detalle">
                    <h3>${pais.name.common}</h3>
                    <p><strong>Oficial:</strong> ${pais.name.official}</p>
                    <p><strong>Capital:</strong> ${pais.capital ? pais.capital[0] : 'N/A'}</p>
                    <p><strong>Población:</strong> ${pais.population.toLocaleString()}</p>
                    <p><strong>Región:</strong> ${pais.region}</p>
                </div>
            </div>
        `;
    } catch (error){
        mostrarError('resultado-nombre', "Error: El codigo no existe en el campo");
    }
});