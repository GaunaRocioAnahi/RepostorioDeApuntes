# Obejtivo:

tengo el examen para practicar, me dice lo siguente.
**Desarrollar un programa en java**, que permita gestionar planes de san valentin usando un historial y un menu de opciones. 
## Estructura de datos:
el programa debe usar un ArrayList para almacenar la informacion del historial. para cada plan se guardara:
-nombre de la persona A
-nombre de la persona B.
-Preferencia de plan de la persona B.
-Plan propuesto por la persona A.
 cada tipo de dato debe alamacenarce en un ArrayList <String> distinto.
menu de programa: 
1- Añadir plan
2- Listar planes
3-Evaluar plan (por indice)
4-Eliminar plan (por indice)
5-salir
Tipos de planes validos: 
-cena
-cine
-aventura
-relax
el programa debe normalizar los textos introducidos por el usuario con ToLowerCase(), o ToUpperCase() Y TENER EL CONTROL DE ERRORES para que solo se introduzca uno de estos 4 planes (hazlo al final) 
Evaluacion del plan 
segun la preferencia de la persona B y el plan propuesto de la persona A se obtine el resultado. 
es un cuadro donde hay preferencia por columna y tenemos (cena, cine, aventura, relax)luego por fila tenemos propuesta(cena, cine, aventura, relax)
preferencia=cena, propuesta= cena obtenemos resultado = perfecto
preferencia = cena,propuesta =cine, resultado = bien
preferencia =cena, profpuesta = aventura resultado =regular
preferencia = cena , propuesta =relax, resultado = bien,
preferencia = cine, propuesta= cena, resultado= bien, 
preferencia= cine, propuesta= cine, resultado = perfecto,
preferencia = cine, propuesta= aventura, resultado = regular,
prefenrecia = cine, propuesta = relax, resultado = bien,
preferencia = aventura, propuesta = cena, resultado =regular,
preferencia = aventura, propuesta = cine, resultado = regular,
preferencia = aventura, prpuesta = aventura, resultado = perfecto,
preferencia = aventura, propuesta = relax, resultado = fatal,
preferencia = relax, propuesta = cena, resultado= bien,
preferencia = relax, propuesta = cine, resultado = bien,
preferencia = relax, propuesta =aventura, resultado = fatal,
preferencia = relax, propuesta = relax, resultado =perfecto. 
 si alguno de los planes no es valido, el programa debe mostrar un mensaje de error y no  evaluar. 
Mensaje aleatorio:
el programa debe mostrar un mnesaje aleatorio segun el resultado obtenido, debe haber al menos dos mensajes distintos por cada resultado. 
funciones obligatorias: 
el progrma debe estar dividido en funciones aqui tienen algunas sugerencias el minimo de funciones a implementar es 3... 
-mostrar menu();
-aniadirPlan();
-listarPlanes();
-evaluarPlan();
-mensajeAleatorio();
-eliminarPlan();

