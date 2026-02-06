# JAVA.

Para implementar Java tenemos que verlo por terminal.
 ``` bash
java ./EjercicioEJEMPLO.java
 ```


ele archivo java tiene el mismo nombre se lo obtiene automaticamente. 

``` java
public class Ejemplo1{

    public static void main(String[] args){
        System.out.println("Hola, mundo!");
    }
}

```
` System.out.println("Hola, mundo!");` esta linea me devuelve en la terminal un hola, mundo! el string dentro del parentesis, simulando el console.log que muestra por consola. 
para declarar **constantes**
`final` nombreDeLaConstante

Para declarar **variables**: 

int -> "nombre de la variable = numero si es `int`. ejemplo. 
```java 
int a = 8; 
int b = 10;
int suma = a + b;
System.out.println(suma);
// para string:
String saludo = "Hola,";
String = saludo + "mundo";
System.out.println(completo;)//RESULTADO: Hola, Mundo!
//otra forma. 
String resutado = saludo.concat("amigos!");
```
muestra por terminal un `18`.
`Comparacion de cadenas`
String palabra1 = "Hola";
String palabra2 = "hola";
``` JAVA
boolean sonIguales = palabra1.equals(palabra1); //false
boolean sin Distinguir = palabra1.equalsIgnoreCase(palabra2);//false

```
la clase Scanner sirve para ingresar datos
primero se importa. `importar java.util.Scanner;`

y se declara dentro del:

```java
public class Ejemplo1 {
     public static void main ( String[]args){
        Scanner scanner(puede cambiar el nombre) = new Scanner(System.in);
     }
}
```

al Scanner que se cambia el nombre vas indicando con que varibale va declarada. ejemplo claro 
```java
Scanner scanner1 = new Scanner(System.in);
System.out.print("ingrese su nombre"); --> para ingresar datos necesarios para esa variable que coinciden el scanner. 
String nombre = scanner1.netxLine();permite incresar el nombre
System.out.println("Hola, " +  nombre + "!")--> como el cosole.log lo muestra

```

a tenerlo en cuenta cuando declaramos una edad o numeros: 
```java
System.out.print("Ingrese su edad");
int edad = scanner1.netxInt();
System.out.printlin( "TU EDAD es: " + edad );
```

--- buscar como se usa el `try cach`,

el Scanner se cierra: `scanner1.close();` 
siempre que usemos el nextInt o nextDouble, o nextLine, limpiamos el bufer con scanner `nextLine.`  
1:12:50 del video
  2DO VIDEO. IMPORTANTE. 

  ```java
  // imprime con formato. una funcion que recibe un argumento. cambia el + por una "," 
  //para un porcentaje %.2f => lo guarda como dos porcentaje. usamos siemrpe el \n para el salto de line. 
  System.out.printf("su peso es  %.2f", peso);
  ```
  ## .equals:
  Los string en comparaciòn se hace con `equals` en vez de "==" 

  ```JAVA
operador.equels("+");
  ```

 # -try catch- (manejo de errores.)

intentar=try coger= catch.

hace una excepcion.
```java
try{
numeroEncargos = Interger.ParseInt(scanner.nextInt());
}catch(exception e){
    numeroEncargos = 0;
    System.out.println("ERROR");
}
```
con un do while().

```java
do{
    try{
        System.out.print("¿Cuantos encargos piensas realizar?: ");
       numeroEncargos = Interger.ParseInt(scanner.nextInt());
    }catch(exception e){
    numeroEncargos = 0;
    System.out.println("ERROR");
    }
}while(numeroEncarga <= 0);

```
ve si tiene que volver a preguntar si necesita volver a preguntar. 
mientras numero encargo sea menor igual a 0 pregunta. ejemplo si es sigo para y sigo el codigo si la condicion cumple lo que hacemos es volver al `do` 


## Function: 

la funcion es una porcion de codigo repetido. lo cual lo unico que podemos hacer es encapsular para volver a usarlas en cualquier parte del codigo. para reutilizar. 
En las function es, se pueden utilizar parametros de entradas como de salida, en el de entrada nombramos en el main al parametro y en parentesis ponemos un nombre, que claramente en la funcion fue declarada con nombre dentro del parentesis,**(sin return)** 
luego esta el parametro de salida. en el cual lo hacemos con el `return` , cuando tenemos un return el `public static (añadir tipo, si es string. int o double) nombreDeLaFuncion`

los parametros no pueden ir declarados en el main. 

la function se declara como 
```java
 public static int suma ( int a, int b){
    return a+ b;  
 }
```
las funciones se declaran primero. 

```java
public class Calculadora {
    //funcion para sumar
    public static int sumar (int a, int b){
          return a + b;
    }
    //funcion para restar
    public static int restar ( int a, int b){
        return a + b;
    }

    // aca comienza el codigo de siempre. 
    public static void main (String[] args){
        int resultadoSuma =  suma(10, 5);
        int resultadoResta = restar(10,5);

        System.out.println("El resultado de la suma es:" + resultadoSuma);
        System.out.println("El resultado de la resta es : "+ resutladoResta); 
    }
}

```

