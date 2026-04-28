```js
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

```


# PARA EMPEZAR 

## DEFINIMOS:
- VARIABLE DE LA API (ejemplo):
  
  ```js
   const URL_API = "https://restcountries.com/v3.1";
  ```

- CONECTAMOS LOS ELEMENTOS CON UNA VARIABLE. (Ejemplo con un formulario, ingresa datos, recibimos y obtenemos un resultado.)

```js
//El formulario completo ( para escuchar el submit)
const forNombre = document.getElementById("form-nombre");

//campo de texto donde el usuario escribe el nombre
const inputNombre = document.getElementById("input-nombre");

//El div donde vamos a mostrar el resultado
const resultadoNombre = document.getElementById("resultado-nombre");
```

- (CON LISTAS DE BOTONES. ) usamos el `.querySelector`
  
  ```js
    // Con "querySelectorAll" coge todos los elementos con esa clase una vez y devuelve una lista de botones, no uno solo.
   const botonesRegion = document.querySelectorAll(".btn-region");
    //El div donde vamos a mostrar las tarjetas paises.
    const resultadoRegion = document.getElementById("resultado-region");
  ```

- FUNCIONES UNITARIAS ( FUNCIONES CORTAS. )
  
    *LIMPIA EL CONTENEDOR*

    ```js
    function limpiarContenedor(contenedor) {
    if(contenedor){
        contenedor.innerHTML = "";
      }
    }
    ```

    *MUESTRA EL MENSAJE DE ERROR*

    ```js

    function mostrarError(contenedor, mensaje) {
    contenedor.innerHTML = `<p class="mensaje-error">${mensaje}</p>`;
    }

    ```
    *FETCH PARA CUALQUIER URL*

    ```js
    async function obtenerDatos(url) {
    try {
        const respuesta = await fetch(url);
        if(!respuesta.ok) return null;
        const datos = await respuesta.json();
        return datos;
    } catch (error) {
        console.error("La API falló, pero la página sigue viva"); // Si falla, haz esto.
        return null;
    }

    // se puede utilizar un trycatch. 
    }
    ```

- FUNCIONES PARA EXTRAER DATOS, ( los datos que te piden extras en la tarjeta en general ) ejemplo: como son Arrays pueden estar anidados. entonces ponemos pais.capital. join para limpiar ese array. 

```js
function extraerCapital(pais) {
    if (pais.capital) {
        return pais.capital.join(", ");

    }
    return "No disponible";
}
```
- FUNCION PARA TARJETA GRANDE AÑADIR AL HTML. (ejemplo) 
  
```js
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
```
cada seccion tendra su propia tarjeta dependiendo lo que piden. 


- FUNCION PRINCIPAL. (ejemplo):
  
```js
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
```
- Añadirlos eventos. 
  ejemplo para el formulario de nombre con el boton
  ```js
        // Sección 1: cuando el usuario envía el formulario de nombre
    forNombre.addEventListener("submit", function (eventoFormulario) {
        // preventDefault evita que la página se recargue al enviar el formulario
        eventoFormulario.preventDefault();
        // .trim() elimina espacios al inicio y al final
        // .toLowerCase() convierte a minúsculas para que la API lo entienda
        buscarPaisPorNombre(inputNombre.value.trim().toLowerCase());
    });
    forNombre.querySelector("button").onclick = () => buscarPaisPorNombre(inputNombre.value.trim());
  ``` 

