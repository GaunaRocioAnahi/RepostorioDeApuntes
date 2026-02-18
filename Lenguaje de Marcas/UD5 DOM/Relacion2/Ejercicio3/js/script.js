let noticias = document.getElementsByClassName("noticia");
let i= 0;

for( let noticia of noticias){
    noticia.textContent = "🔥 " + noticia.textContent;

    if(i%2 == 0){
        noticia.style.backgroundColor = "lightgray";

    }else {
        noticia.style.color= "blue";
    }
    i++;
}