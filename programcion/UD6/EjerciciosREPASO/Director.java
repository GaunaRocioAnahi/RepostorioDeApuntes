package UD6.EjerciciosREPASO;
import java.util.ArrayList;




    // ¿Como me doy cuenta que es una clase normal?
// → NO tiene "abstract" antes de class
// → NO tiene "interface" antes del nombre
// → Director ES UN tipo de PersonaAgrupacion  → extends (herencia)
// → Director PUEDE gestionar musicos          → implements (interfaz)
public class Director extends PersonaAgrupacion implements GestionHumana {

    // =====================
    // ATRIBUTOS PROPIOS
    // =====================
    // son private porque nadie los toca directamente
    // solo se acceden mediante getters y setters

    private String especialidad;      // ejemplo: "Viento", "Percusion"
    private int maximoMusicos;        // limite de musicos que puede tener
    private ArrayList<PersonaAgrupacion> musicosAsignados; // lista de musicos
    private double plusDireccion;     // dinero extra por dirigir

    // =====================
    // CONSTRUCTOR
    // =====================
    // recibe los 3 atributos del padre + los 4 propios de Director
    // la lista NO se recibe, se crea vacia automaticamente
    public Director(String nombre, int edad, int antiguedad,
                    String especialidad, int maximoMusicos, double plusDireccion) {

        // super() llama al constructor del padre PersonaAgrupacion
        // SIEMPRE debe ser la primera linea
        // le pasamos los datos que el padre necesita
        super(nombre, edad, antiguedad);

        // ahora asignamos los atributos propios de Director
        this.especialidad = especialidad;
        this.maximoMusicos = maximoMusicos;
        this.plusDireccion = plusDireccion;

        // la lista se crea vacia aqui
        // no viene del constructor porque empieza sin musicos
        this.musicosAsignados = new ArrayList<>();
    }

    // =====================
    // GETTERS Y SETTERS
    // =====================
    // getter → devuelve el valor del atributo
    // setter → modifica el valor del atributo con control de errores

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        // control de error: no acepta texto vacio o nulo
        if (especialidad == null || especialidad.isEmpty()) {
            return;
        }
        this.especialidad = especialidad;
    }

    public int getMaximoMusicos() {
        return maximoMusicos;
    }

    public void setMaximoMusicos(int maximoMusicos) {
        // control de error: no acepta numeros negativos
        if (maximoMusicos < 0) {
            return;
        }
        this.maximoMusicos = maximoMusicos;
    }

    public double getPlusDireccion() {
        return plusDireccion;
    }

    public void setPlusDireccion(double plusDireccion) {
        // control de error: no acepta numeros negativos
        if (plusDireccion < 0) {
            return;
        }
        this.plusDireccion = plusDireccion;
    }

    // la lista no tiene setter
    // se gestiona con asignarMusico y expulsarMusico
    public ArrayList<PersonaAgrupacion> getMusicosAsignados() {
        return musicosAsignados;
    }

    // =====================
    // METODOS OVERRIDE
    // =====================
    // @Override significa "estoy reescribiendo un metodo que venia del padre"
    // estos metodos son OBLIGATORIOS porque:
    // calcularAportacion y puedeParticipar → vienen de PersonaAgrupacion (abstract)
    // asignarMusico y expulsarMusico       → vienen de GestionHumana (interfaz)

    // calcula la aportacion del director
    // formula exacta del enunciado:
    // antiguedad * 10 + plusDireccion + (musicosAsignados.size() * 5)
    // size() → devuelve cuantos elementos tiene la lista
    @Override
    public double calcularAportacion() {
        return getAntiguedad() * 10 + plusDireccion + (musicosAsignados.size() * 5);
    }

    // devuelve true si el director puede participar
    // el enunciado dice: true si edad >= 18
    @Override
    public boolean puedeParticipar() {
        return getEdad() >= 18;
    }

    // añade un musico a la lista
    // el enunciado dice exactamente las reglas:
    @Override
    public boolean asignarMusico(PersonaAgrupacion persona) {

        // regla 1: si persona es null devuelve false
        if (persona == null) {
            return false;
        }

        // regla 2: si ya existe alguien con el mismo nombre devuelve false
        // recorre la lista comparando nombres
        for (PersonaAgrupacion p : musicosAsignados) {
            if (p.getNombre().equals(persona.getNombre())) {
                return false; // ya existe, no se añade
            }
        }

        // regla 3: si ya llegamos al maximo de musicos devuelve false
        if (musicosAsignados.size() >= maximoMusicos) {
            return false;
        }

        // si paso todas las reglas, se añade y devuelve true
        musicosAsignados.add(persona);
        return true;
    }

    // elimina un musico de la lista por nombre
    // el enunciado dice exactamente las reglas:
    @Override
    public boolean expulsarMusico(String nombre) {

        // recorre la lista buscando el nombre exacto
        for (PersonaAgrupacion p : musicosAsignados) {
            if (p.getNombre().equals(nombre)) {
                musicosAsignados.remove(p); // lo encuentra y lo elimina
                return true;               // devuelve true
            }
        }

        // si llego hasta aqui es porque no lo encontro
        return false;
    }

    // =====================
    // METODOS PROPIOS
    // =====================

    // devuelve cuantos musicos hay en la lista actualmente
    // size() → metodo de ArrayList que cuenta los elementos
    public int contarMusicosAsignados() {
        return musicosAsignados.size();
    }

    // recorre la lista y suma la aportacion de cada musico
    public double calcularValorTotalAportacionMusicos() {
        double total = 0; // empezamos en 0

        // por cada musico en la lista
        for (PersonaAgrupacion p : musicosAsignados) {
            total = total + p.calcularAportacion(); // sumamos su aportacion
        }

        return total; // devolvemos la suma total
    }
}

