package programcion.UD5.Relacion1;

public class Ejericicio5 {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        //primero la class luego la variable, lo igualo a new y  luego la class con el dato inicial
        Termometro temperatura = new Termometro(0);
        Termometro temperatura2 = new Termometro(37);

        // para mostrar el dato 1º variable.atributo (temperatura.temperatura) luego el metodo de convertir a F 2º variable.convertirAFahrenheit() 
        System.out.println("Temperatura en grados Celsius es :"+ temperatura.temperatura + "ºc "+ "Temperatura en F: "+ temperatura.convertirAFahrenheit() + "ºF");

        System.out.println("temperatura en grados celsius es : "+ temperatura2.temperatura+" Temperatura en grados F es : "+ temperatura2.convertirAFahrenheit()+"ºF");

    }

}

class Termometro {

    //atributos
    double temperatura;

    //constructor
    Termometro(double temperatura) {
        this.temperatura = temperatura;
    }
    //Metodo
    double convertirAFahrenheit(){
        //en el return hago la cuenta que quiero calcular en mi main
        return (this.temperatura * 9/5) + 32;
    }
}