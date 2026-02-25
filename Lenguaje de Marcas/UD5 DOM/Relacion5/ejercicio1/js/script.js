// creamos en la web el usuario que pueda añadir, borrar y reemplazar elementos de la lista mediante botones. 

//Creamos los botones.
const lista = document.getElementById("lista");
const botonAniadir = document.getElementById("btnAniadir");
const botonBorrar= document.getElementById("btnBorrar");
const botonEditar = document.getElementById("btnEditar");
// 
botonAniadir.addEventListener("click", aniadirElemento);
botonBorrar.addEventListener("click", borrarElemento);
botonEditar.addEventListener("click", editarElemento);


//funcion para añadir un elemento nuevo a la lista. 
function aniadirElemento(){
    const nuevoElemento = document.createElement("li");
    nuevoElemento.textContent = "Elemento " + (lista.childElementCount + 1);
    lista.appendChild(nuevoElemento);   
}

//funcion para borrar el elemento. 
function borrarElemento(){
    const ultimoElemento = lista.lastElementChild;
    lista.removeChild(ultimoElemento);
}

//funcion para editar el elemento. 
function editarElemento(){
    const ultimoElemento = lista.lastElementChild;
    ultimoElemento.textContent = "Elemento Editado";
}
