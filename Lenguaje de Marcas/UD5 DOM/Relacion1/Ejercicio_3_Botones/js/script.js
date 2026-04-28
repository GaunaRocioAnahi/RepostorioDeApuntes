const PRIMERBOTON = document.querySelector(".boton");
PRIMERBOTON.style.backgroundColor = "green";

const CAMBIARESTILO = document.querySelector("#cambiarEstilo");
const TODOSLOSBOTONES = document.querySelectorAll(".boton")

cambiarEstilo.addEventListener("click",function(){
document.querySelectorAll(".boton");

    for (const boton of TODOSLOSBOTONES) {
        boton.style.backgroundColor = "orange";
        boton.style.border = "3px dotted black"
    }
});