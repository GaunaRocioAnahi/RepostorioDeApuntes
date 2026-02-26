package programcion.UD5.Relacion3.Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;

public class Embarcacion {

    private static int numeroEmbarcaciones;
    private final static ArrayList<String> TIPOSVALIDOS = new ArrayList<>(
            Arrays.asList("VELERO", "LANCHA", "YATE", "CATAMARAN", "MOTO DE AGUA")); // lista predeterminada de tipos validos. solo puede ser uno de estos tipos. 
// 1ero se crean los atributos.
    private String matricula; // no puede ser null 
    private String nombre;
    private double eslora;
    private String tipo;
    private String propietario;
    private int anioFabricacion;
    public double valorEstimado;
// 2do se crea el constructor.

    public Embarcacion(String matricula, String nombre, double eslora, String tipo, String propietario, int anioFabricacion) {
        asignarMatricula();//this.matricula = matricula; 
        this.nombre = nombre;
        setEslora(eslora);
        setTipo(tipo);
        this.propietario = propietario;
        this.anioFabricacion = anioFabricacion;
    }

    //constructor por defecto. Para que me salga la funcion por defecto lo que yo hago previamente. 
    public Embarcacion(String nombre, double eslora, String tipo) {
        this("sin Mat", nombre, eslora, tipo, "PROPIETARIO VACIO", 1950);
    }

    private void asignarMatricula() {
        setMatricula("EMB-" + numeroEmbarcaciones);
        numeroEmbarcaciones++;
    }

    private void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el valor de la eslora o -1 si hay un valor fuera de rango.
    public double getEslora() {
        return eslora;
    }

    //Actaulizar el valor de la eslora, si esta fuera de rando. usa el valor por defecto -1. 
    public void setEslora(double eslora) {
        if (eslora > 0) {
            this.eslora = eslora;
        } else {
            this.eslora = -1;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (TIPOSVALIDOS.contains(tipo)) {
            this.tipo = tipo;
        }
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getPropietario() {
        return propietario;

    }
    // esta porcion de codigo lo que hace es reemplazar el codigo como si fuera un if else y devuelve un mensaje dependiendo del valor de eslora. 

    public String mostrarEslora() {
        return eslora != -1 ? "Eslora " + eslora : "<Valor de eslora incorrecto. Actualicelo por favor>";
    }

    public String mostrarTipo() {
        return tipo != null ? "Tipo: " + tipo : "[Valor de tipo incorrecto. Actualicelo por favor]";
    }

    public String mostrarAnioFabricacion() {
        return anioFabricacion != 0 ? "" + anioFabricacion : "[Valor de año de fabricación incorrecto. Actualicelo por favor]";
    }

}
