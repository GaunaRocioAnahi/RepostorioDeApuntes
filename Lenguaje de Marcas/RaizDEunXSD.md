# RAIZ DE UN XSD


## Esta es la etiqueta que tiene que estar si o si, en el principio
 de un documento XSD(xsd:"siempre en minuscula") NO OLVIDES DE CERRAR 
 LA ETIQUETA SCHEMA 






```
<?xml version="1.0" encoding="UTF-8"?>
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="persona">
```


 Proximo declaramos el principio de la raiz del XML, con un "xs:elmentos"
    
        - podemos poner al final del element el /> para cerrarlo
        o cerrarlo normal </xs:element> 
         - si el element tiene mas cosas adentro para a hacer un (xs:complexType)
        - ATRIBUROS para xs: element fixed:pone un favo fijo
        defaul:pone un valor por defecto
        type: datos del elemento(xs:string:texto; xs integer:numero entero;xs float: con decimal
        maxoccurs: numero maximo de ocurrencias repetido
        minOccurs: numero minimo de ocurrencia)


```
    </xs:elemnt>
    <xs:complexType>

    </xs:complexType>
    </xs:schema>
```

# ATRIBUTOS/REQUERIMIENTOS: 

   + para cuando te piden el **email**

 ```  
 <xs:element name="email">
<xs:simpleType>
     <xs:restriction base="xs:string">
         <xs:pattern value="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}"/>
     </xs:restriction>
 </xs:simpleType>
 </xs:element> 
 ``` 

 * cuando te piden el **dni**
```
<xs:element name="dni">
   <xs:simpleType>
       <xs:restriction base="xs:string">
             <xs:pattern value="\d{8}[a-z]" />
       </xs:restriction>
  </xs:simpleType>
</xs:element>
```


