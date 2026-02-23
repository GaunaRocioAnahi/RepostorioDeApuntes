package programcion.UD5.Relacion2.Ejercicio2;

import UD5.Relacion2.Faker;

public class Ejercicio2 {
    public static void main(String[] args) {
        // es necesario crear el objeto faker. es una clase tambien. 
        //PREGUNTAR SI TENEMOR QUE MOVER LA CARPETA FAKER Y LA TENEMOS QUE LLAMAR COMO OBJETO. PARA TOMARLO COMO CLASS TAMBIEN.

        Faker faker = new Faker();
        //creamos el objeto de biblioteca
        Biblioteca biblioteca = new Biblioteca();
        // Generamos 100libros faker y los añadimos

        final int LIBROSAGREGADOS = 100; 

        for (int i = 0; i < LIBROSAGREGADOS; i++) {
            String id = String.valueOf( i + 1);
            String titulo = faker.libro().titulo;
        }

    }
}
