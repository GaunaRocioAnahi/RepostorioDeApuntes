const FRUTAS = document.getElementsByTagName("li");

for (const fruta of FRUTAS){
    fruta.style.border = "2px solid orange";
    fruta.style.padding = "2px";
    fruta.style.margin = "5px 0";
}

const marcarFrutas = document.getElementById("marcarFrutas");

marcarFrutas.addEventListener("click", function (){
    for ( const fruta of FRUTAS){
        fruta.style.backgroundColor = "paleblue";
        if(!fruta.textContent.includes("✅")){
            fruta.textContent += "✅";
        }
    }
});