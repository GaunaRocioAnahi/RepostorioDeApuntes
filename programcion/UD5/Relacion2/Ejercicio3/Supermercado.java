package programcion.UD5.Relacion2.Ejercicio3;

import java.util.ArrayList;

public class Supermercado {
    // como va ser un supermercado con producto lo que acumulamos y tenemos un array list de producto. 

    private ArrayList<Producto> productos; //NO OLVIDAR EL PRIVATE. 

    //llamar a la misma clase para el constructor

    Supermercado(){
        this.productos = new ArrayList<>(); // vacia la lista para recibir productos
    }
    //metodo() para agregrar el producto.
    // recibe un producto del objeto y lo añade a la arrayList 

    public void agregarPoductos(Producto producto){
        productos.add(producto);

    }

    //vende un producto reduciendo su stock. 
    public void venderProducto(String id, int cantidad){
        //cantidad comprada por el cliente. 
        for (Producto producto : productos) {
            //¿esta el producto que busco?
            if(producto.getId().equals(id)){
                // ¿hay stock sufiente?
                if(producto.getCantidadEnStock() >= cantidad){
                    //GET para leer el stock actual, restamos, SET para guardar 
                    producto.setCantidadEnStock(producto.getCantidadEnStock()-cantidad);
                    System.out.println("Vendido. Stock restante: " + producto.getCantidadEnStock());
                }else{
                    System.out.println("No hay suficiente stock. Stock disponible: " + producto.getCantidadEnStock());
                }
                return; //encontro el producto no sigue buscando
            }
        }
        System.out.println("No se encontro el producto con el ID: "+id);
    }




    // Muestra todos los productos — igual que mostrarLibros
    public void mostrarInventario() {
        for (Producto producto : productos) {
            System.out.println(producto); // Java llama toString() automáticamente
        }
    }

    // Repone stock de un producto sumando cantidad
    public void reponerProducto(String id, int cantidad) {

        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {

                // GET para leer el stock actual,  sumamos, SET para guardar
                producto.setCantidadEnStock(producto.getCantidadEnStock() + cantidad);
                System.out.println("Stock repuesto. Stock actual: " + producto.getCantidadEnStock());
                return;
            }
        }
        System.out.println("No se encontró el producto con ID: " + id);
    }

}
