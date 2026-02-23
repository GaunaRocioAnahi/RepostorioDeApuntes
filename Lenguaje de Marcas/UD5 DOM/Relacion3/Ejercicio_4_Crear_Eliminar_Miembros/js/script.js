const lista = document.getElementById("integrantes")
const elementoNuevo = document.createElement("li");
elementoNuevo.textContent = "Trompetista";
lista.appendChild(elementoNuevo);

const elementoBateria = lista.querySelectorAll("li");

for (const elementoBateria of lista.querySelectorAll("li")) {
    if (elementoBateria.textContent.includes("bateria")) {
        lista.removeChild(elementoBateria);
    }
}
