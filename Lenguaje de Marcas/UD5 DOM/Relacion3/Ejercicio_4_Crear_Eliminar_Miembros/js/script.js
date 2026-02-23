const lista = document.getElementById("integrantes")
const elementoNuevo = document.createElement("li");
elementoNuevo.textContent = "Trompetista";
lista.appendChild(elementoNuevo);

const elementoBateria = lista.querySelector("li");

for (const elementoBateria of lista) {
    if (elementoBateria.textContent.includes("bateria")) {
        lista.removeChild(elementoBateria);
    }
}
