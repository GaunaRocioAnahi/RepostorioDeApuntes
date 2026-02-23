package programcion.UD5.Relacion2.Ejercicio2;

import java.util.ArrayList;

public class Biblioteca {
    //Atributo: un ArrayList que guarda objetos de tipo libro;
    //ArrayList es una lista dinamica, pude crecer segun se le agreguen libros.

    private ArrayList<Libro> libros; //private por encapsulamiento.
    
    
    //Constructor: cuando creas una Biblioteca, inicializa la lista vacia.

    Biblioteca(){
        this.libros = new ArrayList<>();// Lista vacia para recibir libros
    }

    //Metodo: agregar un libro a la biblioteca
    // recibe un objeto libro y lo añade al ArrayList. 

    public void agregarLibro( Libro libro){
        libros.add(libro); // . add() es el metodo ArrayList para añadir elementos 
    }

    //Metodo: prestar libro
    //Busca el libro por su ID y cambia disponible a false. 

    public void prestarLibdro(String id){
        //recorremos la lista de libros para encontrar el lbro con el id correspondient, para eso usamos un for each. se usa con una coleccion de arrayList, y hay que recorrer sus elementos uno por uno. sin preocuparnos por el indice. 

        for (Libro libro : libros){
            //lectura por cada libro que hay dentro de libros hace esto, En cada vuelta "libro" es UN libro distinto del ArrayList.
            if (libro.getId().equals(id)){
                // genera la pregunda de que ¿el ID de este libro es igual al que me pasaron?
                if(libro.isDisponible()){
                    // pregunta si es libro esta disponible
                    libro.setDisponible(false);
                    // si estaba disponible lo marcamos como NO disponible.
                    System.out.println("Libro prestado: "+ libro.getTitulo());
                }else{
                    System.out.println("El libro ya esta prestado.");
                }
                return; // Encontre el libro, no sigo buscando
            }

        }
        System.out.println("No se ecnotro el libro con ID:" + id);

    }
    //Metodo : msotrar todos los libros (util para el menu)
    public void mostrarLibros(){
        for (Libro libro : libros) {
            System.out.println(libro); // Aqui java llama automaticamente a toString()
        }
    }
    // GETTER Del ArrayList 

    public ArrayList<Libro> getLibros(){
        return libros;

    }
    



}
