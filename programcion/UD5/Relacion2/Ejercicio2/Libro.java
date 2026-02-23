package programcion.UD5.Relacion2.Ejercicio2;

public class Libro {

    // atributos de Libros
    private String id;
    private String titulo;
    private String autor;
    private String sinopsis;
    private boolean disponible;

    Libro(String id, String titulo, String autor, String sinopsis, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.sinopsis = sinopsis;
        this.disponible = disponible;

    }

    // Etiqueta
    @Override
    public String toString() {
        return "el id es: " + id + ", Titulo: " + titulo + ", El autor es: " + autor + ", La sinopsis:  " + sinopsis
                + ", Disponibilidad: " + disponible;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitulo( String titulo ){
        this.titulo =  titulo; 
    }

    public String getTitulo(){
        return titulo; 
    }

    public void setAutor( String autor){
        this.autor = autor;
    }

    public String getAutor(){
        return autor;
    }

    public void setSinopsis( String sinopsis){
        this.sinopsis = sinopsis;
    }

    public String getSinopsis(){
        return sinopsis;
    }

    public void setDisponible(boolean disponible){
        this.disponible = disponible; 
    }
    public boolean isDisponible(){
        return disponible; 
    }
}
