package programcion.UD5.Relacion1;

public class Ejericicio1 {
    
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo(5); // objeto se escribe con class nombre de la variable "=" new clase en parentesis el valor
        Circulo  circulo2 = new Circulo(1); // en otro objeto añadimos un valor universal se le llama cuando no te piden datos y el dato lo agregar en el codigo sin pedir al usuario. 

        System.out.println("circulo de un radio : "+ circulo1.radio + "Area: "+ circulo1.calcularArea()+ "perimetro: "+ circulo1.perimetro());
        System.out.println("ciruclo de un radio: "+ circulo2.radio+ "Area: "+ circulo2.calcularArea()+" perimetro: "+circulo2.calcularArea());
    }
}
// creo una clase, dentro de esa calse voy a llamar a una constante, en este caso como es un circulo voy a necesitar a PI. = 3.14. 
//y luego voy a necesitar el radio. 
class Circulo {
    final double PI = 3.14;
    double radio; // atrubto de la class

    Circulo(double radio){
    this.radio = radio; //This es propia de el atributo de la clase
    }
// declaramos los metodos
double calcularArea(){
    return PI * this.radio *this.radio; // llamamos un return al atributo de la clase que nos srive para calcualr el area de circulo
}
double perimetro(){
    return 2* PI *this.radio; // llamamos al return para calcular. 
}
    

}