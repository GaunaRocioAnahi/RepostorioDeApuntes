const item = document.querySelector("li")

for (const item of document.querySelectorAll("li")) {
    item.style.color = "green";
    item.textContent += "🎶";
}