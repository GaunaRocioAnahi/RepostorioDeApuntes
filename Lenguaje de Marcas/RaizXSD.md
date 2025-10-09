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


*En un ``<xs:complexType> `` no podemos ponerle un `` Type``
Eso no se puede hacer al mismo tiempo: un elemento solo puede tener un tipo, y si lo defines como xs:string, no puede contener subelementos (como <cliente>, <habitacion>, etc.).*

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
             <xs:pattern value="\d{8}[A-Za-z]" />
       </xs:restriction>
  </xs:simpleType>
</xs:element>
```


* cuando te piden un **precio** con decimales de dos en regex - decimal, con 2 decimales exactos → regex \d+\.\d{2}.
  
  ```

   <xs:element name="precio">
     <xs:simpleType>
        <xs:restriction base="xs:decimal">
               <xs:minInclusive value="0.01" />
               <xs:maxInclusive value=" 999.99"/>
               <xs:pattern value="\d+\.\d{2}"/>
        </xs:restriction>
    </xs:simpleType>
     </xs:element>  
  ```

* cuando te piden un **telefono**.
   
   ```
   <xs:element name="nombre" type="xs:string" />
        <xs:element name="telefono">
         <xs:simpleType>
         <xs:restriction base="xs:string">
            <xs:pattern value="\d{3}-\d{3}-\d{3}">
         </xs:restriction>
         </xs:simpleType>             
  </xs:element>
  ```

* para **enumerdaR** o hace listas -EJEMPLO-


  ```
   <xs:element name="categoria">
      <xs:simpleType>
          <xs:restriction base="xs:string">
          <xs:enumeration value="periferico" />
          <xs:enumeration value="movil" />
          <xs:enumeration value="ordenador" />
          <xs:enumeration value="accesorio" />
        </xs:restriction>
     </xs:simpleType>
  </xs:element>
  ```


 * cuando nos piden un **ID** con resquerimientos:

```
  <xs:attribute name="codigo" use="required">
        <xs:simpleType>
          <xs:restriction base="xs:string">
               <!-- Patrón: A seguido de 3dígitos -->
          <xs:pattern value="PKT-\d{4}" />
          </xs:restriction>
           </xs:simpleType>
   </xs:attribute>
   ``` 

* Para la **edad** la requerimiento de rango usamos el  ``xs:minInclusive `` y el `` xs:maxInclusive``
  

* Para los **nombres** con mayusculas:
   ```
  <xs:element name="nombre">                                        <xs:simpleType>
      <xs:restriction base="xs:string">
        <xs:pattern  value="[A-Z].*" />
      </xs:restriction>
  </xs:simpleType>
  </xs:element>
  
  para nombre y apellidos
  <xs:pattern value="[A-Z][a-z]+ [A-Z][a-z]+"/>
  ```

  * un posible nombre:
   
   ```
   <xs:element name="nombre">
         <xs:simpleType>
            <xs:restriction base="xs:string">
                <xs:pattern value="[A-Za-zÁÉÍÓÚáéíóúÑñ \-]+"/>
            </xs:restriction>
         </xs:simpleType>
   </xs:element>
   
                                        
   ```

* otro id y tener en cuenta que cuando me dicen entero positivo en el id poner un `` Type = xs:positiveInteger" `` el atrubito siempre después del complex del que lleva el 
*  **nombre con rangos** ejemplo 3 -15 alfanuméricos y guiones bajos
```  <xs:simpleType>
        <xs:restriction base="xs:string">
          <xs:pattern value="[A-Za-z0-9_]{3,15}" />
      </xs:restriction>
     </xs:simpleType>
```



* si me solo  **enteros positivos** en alguna tengo que poner la estructura siguiente: 

```
<xs:simpleType>
    <xs:restriction base="xs:positiveInteger"/>
 </xs:simpleType>

```




## **Usa tipos complejos anidados y minOccurs/maxOccurs para controlar la cantidad.**
    cuando es opcional va minOccurs="0"

## **en elementos simples va el type="xs:string"**

