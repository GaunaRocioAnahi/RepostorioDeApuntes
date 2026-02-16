package programcion.UD5.Relacion2.Ejercicio1;

public class Estudiante {
    private String nombre;
    private int edad;
    private String numeroDeMatricula; 

    Estudiante(String nombre, int edad, String numeroDeMatricula){
        this.nombre =nombre;
        this.edad = edad;
        this.numeroDeMatricula = numeroDeMatricula;
    }
    //siempre marcamos con la etiqueta @Override en un toString
    @Override
    public String toString(){
        return nombre +"tiene :" + edad + "años.  su numero de matricula" + numeroDeMatricula;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    // set para la edad de una universidad mayo a 17. 
    public void setEdad(int edad){
        if(edad>=17) {
            this.edad = edad; 
        }
    }

    // get para la edad 

    public int getEdad(){
        int edadEstudiante;
        if(edad<17){
            edadEstudiante = -1;
        }else{
            edadEstudiante = edad;
        }
        return edadEstudiante; 
    }

    // para la matricula 


    public void setNumeroDeMatricula (String numeroDeMatricula){
        this.numeroDeMatricula = numeroDeMatricula;
    }


    public String getNumeroDeMatricula(){
        return numeroDeMatricula;
    }


}
