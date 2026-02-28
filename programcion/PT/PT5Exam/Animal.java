package programcion.PT.PT5Exam;

public class Animal {

    private String nombre;
    private String codigo;
    private int cantidadDeEjemplares;
    private double precio;

    public static int cantidadAnimales = 0;

    public Animal(String nombre, int cantidadDeEjemplares, double precio) {
        setCodigo("Animal" + cantidadAnimales);
        setNombre(nombre);
        setCantidadDeEjemplares(cantidadAnimales);
        setPrecio(precio);
        cantidadAnimales++;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (!codigo.isEmpty() && !codigo.equals(null)) {
            this.codigo = codigo;
        } else {
            this.codigo = "-1";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.isEmpty() && !nombre.equals(null)) {
            this.nombre = nombre;
        } else {
            this.nombre = "-1";
        }
    }

    public int getCantidadDeEjemplares() {
        return cantidadDeEjemplares;
    }

    public void setCantidadDeEjemplares(int cantidadDeEjemplares) {
        if (cantidadDeEjemplares > 0) {
            this.cantidadDeEjemplares = cantidadDeEjemplares;

        } else {
            this.cantidadDeEjemplares = -1;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            this.precio = -1;
        }
    }

    //----- METODOS DE MOSTRAR PARA USAR EN EL toString
    public String mostrarCodigo() {
        return codigo.equals("-1")?"[Codigo del ejemplar MAL introducido.]":"Codigo: "+ codigo; 
    }

    public String mostrarNombre(){
        return nombre.equals("-1")? "[En nombre es incorrecto. cambiar ]":"Su nombre es "+ nombre;
    }

    public String mostrarEjemplares(){
        return cantidadDeEjemplares == -1? "[Cantidad ejemplares mal introducidos. Cmabiar]":"Existe: "+cantidadDeEjemplares; 
    }

    public String mostrarPecio(){
        return precio == -1? "[Precio del ejemplar Mal introducido. Cambiar]":"[El precio es: "+ precio;
    }
    @Override
    public String toString(){
        return mostrarCodigo()+ " | " +mostrarNombre()+" | "+ mostrarEjemplares()+" | "+mostrarPecio()+"\n";
    }
}
