package programcion.UD5.Relacion3.Ejercicio2;

public class Cliente {
    //Declaramos los atributos de la clase cliente.
    static int numeroCliente = 0; // Atributo estático para llevar el conteo de clientes.
    private int id; 
    private String nombre;
    private String dni;
    private String telefono;
    private String email;
    private String direccion;

    //Constructor de la clase cliente.
    public Cliente(int numeroCliente, String nombre, String dni, String telefono, String email,
            String direccion) {

        numeroCliente++; // Incrementamos el número de cliente cada vez que se crea un nuevo cliente.;
        this.id =  numeroCliente;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }
///=============================================
/// ------- GETTERS Y SETTERS -------
/// ==============================================
///  con restricciones de control de errores. 

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        } else {
            this.nombre = "-1";
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni != null && !dni.trim().isEmpty()) {
            this.dni = dni.trim();
        } else {
            this.dni = "-1";
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.trim().isEmpty()) {
            this.telefono = telefono.trim();
        } else {
            this.telefono = "-1";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email.trim();
        } else {
            this.email = "-1";
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != null && !direccion.trim().isEmpty()) {
            this.direccion = direccion.trim();
        } else {
            this.direccion = "-1";
        }
    }


}
