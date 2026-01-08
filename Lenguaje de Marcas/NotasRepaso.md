# XSD

vamos a contar con el elemento **raiz** *tienda* que se divide en 3 secciones, *origen*,*catalogo*,*proveedores*

la Raiz <*tienda*> es de tipo complejo `complexType` y `sequence`. la clave de estss dos etiqueta
- `xs:complexType` indica que el elemento es un contennedor de cosas, se usa para indicar que lleva mas cosas dentro.
- `xs:sequence`: indica que las etiquetas que vienen a continuacion deben aparecer en el orden estricto en el XML. 
ejemplo con tienda que es raiz, lo elementos siguiente aparezcan en ese orden `origen`,`elaborado`, `catalogo` y `proveeedores`
todos los que tengan subsecciones como por ejemplo:
origen, catalogo y proveeedores. tienen subsecciones. 
**origen** ( todo los elementos dentro de origen son `simpleType`)
 tiene *<nombre>* en el cual se lee como, esas son sus restricciones

 ```xsd
   <xs:element name="nombre">
       <xs:simpleType>
           <xs:restriction base= "xs:string">
           <xs:pattern value= "[A-ZÑÀ-Ý].*"/>
           </xs:restriction>
       </xs:simpleType>
   </xs:element>
     ---! las restricciones del "nombre" en este caso el nombre de origen es simple no complejo o con mas contenido en el contenedor. ene este coso el pattern es solo mayusculas !---
       
 ```
 contiene *<web>* en el cual va a ser un `simpleType` al ser simple y contener solamante la validacion de `type="xs:anyURI"`  lo mismo con la *<nota_legal>*

 ```xsd
     <xs:element name="web" type="xs:anyURI"/>
 ```

luego <language> es simple tambien de base string, con una restriction con la etiqueta `enumeration` value="es" y value="en". como en el siguiente ejemplo
 
 ```xsd
<xs:element name="language">
   <xs:simpleType>
      <xs:restriction>
        <xs:enumeration value="es"/>
        <xs:enumeration value="en"/>
      </xs:restriction>  
   </xs:simpleType>
</xs:element>
 ```

