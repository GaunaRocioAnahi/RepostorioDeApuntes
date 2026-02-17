package programcion.UD5.Relacion2.Ejercicio2;

public class Libro {

    // atributos de Libros
    private String id;
    private String titulo;
    private String autor;
    private String sinopsis;
    private Boolean disponible;

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
        return "el ide es: " + id + "titulo: " + titulo + "El autor es: " + autor + "sinopsis:  " + sinopsis
                + "Disponibilidad : " + disponible;
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

    public String getTitulo( String titulo){
        return titulo; 
    }

    public void setSinopsis( String Sinopsis){
        
    }

}
