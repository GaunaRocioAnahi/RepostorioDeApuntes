# DTD externa

Este es un archivo aparte de un "**X.dtd**"  'ejemplo'
```
<!ELEMENT raiz (titulo,autor,editorial) >
<!ELEMENT titulo (#PCDATA)>
<!ELEMENT autor (#PCDATA)>
<!ELEMENT editorial (#PCDATA)>
```
# XML con DTD externa
 
 al ser un xml siempre empezamos con la primer linea.
 ```
 <?xml version="1.0" encoding="UTF-8"?>
 ```

 luego continuamos con 
 ```
 <!DOCTYPE raiz SYSTEM "X.dtd">
 <raiz>
    <hijo></hijo>
<rai>
```
 **SOLO LA EXTERNA**

# XML con DTD interna.
 ```
  <!DOCTYPE raiz [
  <!ELEMENT raiz (titulo, autor, editorial )>
  <!ELEMENT titulo (#PCDATA)>
  <!ELEMENT autor (#PCDATA)>
  <!ELEMENT editorial (#PCDATA)>
  ]> 
  -- el resto del XML--
```
# REGEX

## Expresion para encontrer patrones en un texto

``|`` :or o alteracion "o"

`` [] ``: agrupa o todo lo que este dentro con un ``-`` es un rango me indica todo lo que dentro

``^`` : negado o "no"

``\n`` : salto de linea 

``^$`` : principio y fin de un texto 

``.`` : coincide con cualquier caracter

``\w``: palabra 

``\d``: digitos

``()``: apertura en grupo

``+``: 1 o mas apaariciones

``?`` : caracter o grupo opcional

``*``: 0 o mas apariciones

``{}``: Rangos ejemplos ```{2,5} es de 2 a 5 ``

``\`` ? : Escapa  al signo y nos arroja el signo **?**

``\`` .:Escapa al signo y nos arroja el  signo "." 

