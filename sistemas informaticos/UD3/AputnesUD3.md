# Practica de BASH

 **Ejercicio 1**

 crea un scrip bash llamado calculadora.sh que funcione como una calculadora. debera aceptar como parametros una letra y dos numeros, Cada letra significa m:multiplicar, r:restar, s:sumar, e:elevar, d:sacar el modulo del primero sobre el segundo. 
 A continuacion te muestro como deberia funcionar en la terminal. esto es un ejemplo de lo que deberia ser el resultado, ahora piensa tu el codigo: 
 ```bash
#!/bin/bash
./calculadora.hs m 5 3

RESPUESTA: 15
 ```
 RESOLUCION.

 ```bash
#!/bin/bash
if[$# -ne 3]; then
  echo "Lo siento, debe ejecutar el programa con tres parametros"
  echo"Uso: $0 {m|r|s|d} num1 num2"
  echo "m: multiplicar, r: restar, s: sumar, d : dividir"
  exit 1
 fi

 opcion=$1

 if [ $opcion =='m']; then 
     echo "El resultado es : $(($2 + $3))"
elif [ $opcion == 'r']; then 
    echo "El resultado es : $ (($2 - $3))"
elif [ $opcion =='s' ]; then
    echo "El resultado es : $(($2 + $3))"
elif [ $opcion == 'd']; then 
    echo " El resultado es: $(($2 / $3))"
else 
    echo "Elija otra opcion, esta es incorrecta"
fi

 ```
 **ejercicio2**

crea un script que acepte un archivo como primer parametros y luego todas las palabrass que se requiera detras. Debe escribir todas esas palabras en el archivo. Una POR linea. 