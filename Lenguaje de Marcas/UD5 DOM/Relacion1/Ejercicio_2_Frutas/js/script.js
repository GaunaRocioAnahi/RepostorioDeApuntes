const FRUTAS = document.getElementsByTagName("li");

for (const fruta of FRUTAS){
    fruta.style.border = "2px solid orange";
    fruta.style.padding = "8px";
    fruta.style.margin = "5px 0";
}

const marcarFrutas = document.getElementById("marcarFrutas");

marcarFrutas.addEventListener("click", function (){
    for ( const fruta of FRUTAS){
        fruta.style.backgroundColor = "yellow";
        if(!fruta.textContent.includes("")){
            fruta.textContent += "";
        }
    }
});