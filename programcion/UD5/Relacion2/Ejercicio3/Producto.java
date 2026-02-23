package programcion.UD5.Relacion2.Ejercicio3;

public class Producto {
    //atributos
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadEnStock;

    //
    Producto(String id, String nombre, String descripcion, double precio, int cantidadEnStock){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    @Override
    public String toString(){
        return "El id, del producto: "+ id + ", Nombre: "+ nombre + ", Descripcion del producto: "+ descripcion + ", Precio: "+ precio + ", cantidad: "+ cantidadEnStock;
    }
 //preparamos los getter y setter para id
    public void setId(String id){
        this.id = id;
    }
    public String  getId(){
        return id;
    }
//prepraramos los getter y setter para nombre

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    // preparamos los getter y setter para descripcion

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

    // getter y setter para precio

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public double getPrecio(){
        return precio; 
    }
    // getter y setter para cantidad de stock

    public void setCantidadEnStock(int cantidadEnStock){
        this.cantidadEnStock = cantidadEnStock;
    }

    public int getCantidadEnStock(){
        return cantidadEnStock;
    }



    
} 
