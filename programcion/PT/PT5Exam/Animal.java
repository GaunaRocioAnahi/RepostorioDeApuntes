package programcion.PT.PT5Exam;

public final class Animal {

    //Declaramos los atributos del animal.

    private String nombre;
    private String codigo;
    private int cantidad;
    private double precio;

    public static int cantidadAnimales = 0;

    public Animal(String nombre, int cantidad, double precio) {
        setCodigo("ANM-" + cantidadAnimales);
        setNombre(nombre);
        setCantidad(cantidadAnimales);
        setPrecio(precio);


        cantidadAnimales++;
    }
// --- GETTER Y SETTERS
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.isEmpty()) {
            this.codigo = codigo;
        } else {
            this.codigo = "-1";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre!= null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            this.nombre = "-1";
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >=  0) {
            this.cantidad = cantidad;

        } else {
            this.cantidad = -1;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            this.precio = -1;
        }
    }

    //----- METODOS DE MOSTRAR PARA USAR EN EL toString
    public String mostrarCodigo() {

        //operador ternario, simil a un if else. 
        //si hay un error mostramos un aviso, sino, mostramos el formato exacto.,
        return codigo.equals("-1")?"[Codigo del ejemplar MAL introducido.]":"Codigo: "+ codigo; 
    }

    public String mostrarNombre(){
        return nombre.equals("-1")? "[En nombre es incorrecto. cambiar ]":"Su nombre es "+ nombre;
    }

    public String mostrarEjemplares(){
        return cantidad == -1? "[Cantidad ejemplares mal introducidos. Cmabiar]":"Existe: "+cantidad; 
    }

    public String mostrarPecio(){
        return precio == -1? "[Precio del ejemplar Mal introducido. Cambiar]":"El precio es: "+ precio;
    }


    //   ---TOSTRING FINAL ----

    @Override
    public String toString(){

        //El resultado final sera exactamente el que pide el enunciado.

        return mostrarCodigo()+ " | " +mostrarNombre()+" | "+ mostrarEjemplares()+" | "+mostrarPecio();
    }
}
