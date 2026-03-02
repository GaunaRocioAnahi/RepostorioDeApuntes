package programcion.PT.PT5Exam;

import java.util.ArrayList;

public class Zoologico {

    //Declaramos el array de coleccion de animales. donde guardamos los animales. 
    ArrayList<Animal> coleccion;

//CONTRUCTORES ( como se inicia el zoo)
// iniciamos con dos contructores
    //Constructor 1, indica que tiene una lista adentro. 
    public Zoologico(ArrayList<Animal> coleccion) {
        this.coleccion = coleccion;
    }

    //Constructor 2:lista totalmente vacia
    //Este es el usaremos en el main, para empezar de cero. 
    public Zoologico() {
        this.coleccion = new ArrayList<>();

    }
    //----------------- GETTERS Y SETTERS ---------
    // no hay control de errores. no piden. 

    //Permite ver la lista de animales desde fuera. 
    public ArrayList<Animal> getColeccion() {
        return coleccion;
    }

    //Permite cambiar la lista de animales por una nueva. 
    public void setColeccion(ArrayList<Animal> coleccion) {
        this.coleccion = coleccion;
    }

    //nos piden generar estos tipos de metodos para mostrarlo en el main.
    //1. Mostrar todos los animales
    //2. Buscar un animal por código
    //3. Agregar ejemplares a un animal
    //4. Retirar ejemplares de un animal
    //5. Eliminar un animal
    ///   ---------- METODOS DEL MENÙ ------
    
    // 1. Muestra todos los animales. 
    // nos devuelve un String 
    /// En este no nos devuleve la "coleccion" hacemos que nos muestre por consola el print de todos los animales
    /// este muestra los animales del zoo.
    
    public String mostrarTodosLosAnimales() {
        String todosLosAnimales = "";

        //explicacion del for :  por cada Animal, de la clase animal de la coleccion ( coleccion es un arrayList de animal) 
        //todosLosAnimales sumamos a cada animal
        for (Animal animal : coleccion) {
            todosLosAnimales += animal + "\n";
        }
        return todosLosAnimales;
    }

    //2. Busca el codigo para que nos devuelva un animal
    // la explicacion es busca el animal con un for recibe un codigo, crea un animal null 
    // if : si es codigo del animal es igual al codigo que nos han pasdo encontes nos devuelve el animal
    // devuelve el animal a buscar. 
    public Animal buscarAnimal(String codigo) {
        Animal animalABuscar = null;
        for (Animal animal : coleccion) {
            if (animal.getCodigo().equals(codigo)) {
                animalABuscar = animal;
            }
        }
        return animalABuscar;

    }

// 3. Agregar un ejemplar
// usamos la misma funcion que tenemos arriba por que ba a buscar a todos los animales por codigo
    public boolean agregarEjemplares(String codigo, int animalAgregar) {
        boolean exito = false; // Variable para nuestro único return
        Animal animalActual = buscarAnimal(codigo);

        // Si el animal existe y la cantidad es mayor a 0, sumamos y da true
        if (animalActual != null) {
            if (animalAgregar > 0) {
                animalActual.setCantidad(animalActual.getCantidad() + animalAgregar);
                exito = true;
            }
        }
        return exito; // Devuelve true o false
    }

    // 4. Retirar animales 
    public boolean retirarEjemplares(String codigo, int animalesARetirar) {
        boolean exito = false;
        Animal animalActual = buscarAnimal(codigo);

        if (animalActual != null) {
            if (animalesARetirar > 0) {
                // Comprobamos que no se quede en negativo
                if (animalActual.getCantidad() - animalesARetirar >= 0) {
                    animalActual.setCantidad(animalActual.getCantidad() - animalesARetirar);
                    exito = true;
                }
            }
        }
        return exito;
    }

    // 5. Eliminar  especies o animales. 
    public boolean eliminarAnimal(String codigo) {
        Animal animalActual = buscarAnimal(codigo);
        boolean AnimalEliminado = false;
        //si animal actual no es null
        if (animalActual != null) {
            coleccion.remove(coleccion.get(coleccion.indexOf(animalActual)));

            AnimalEliminado = true;
        } else {

        }
        return AnimalEliminado;

    }

}
