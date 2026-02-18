https://www.stela.ai/wiki/instalacion-java/ [[Intalar jdk]]
 

 # JDocs

 Una vez documentados los archivos vamos a utilizar por terminal el comando `javadoc -d docs **/*.java`para que nos realice el html correspondientes a esos ejercicios de java. 

## Como documentar JDocs. 

# 🎓 Guía Maestra de Javadoc: De Principiante a Experto

Has completado los 3 niveles de documentación en Java. Este documento sirve como referencia rápida para aplicar todo lo aprendido en tus futuros proyectos.

## 1. Diccionario de Etiquetas: ¿Qué uso y cuándo?

| Etiqueta | Nivel | ¿Para qué sirve? | Ejemplo Práctico |
| :--- | :---: | :--- | :--- |
| **`@param`** | 1 | Explicar qué datos pide el método. | `@param id El DNI del usuario.` |
| **`@return`** | 1 | Explicar qué dato devuelve. | `@return El precio final.` |
| **`@throws`** | 1 | Avisar de errores posibles. | `@throws IllegalArgumentException Si es negativo.` |
| **`{@link}`** | 2 | Crear un enlace clicable a otra clase. | `Usa la clase {@link Cliente}.` |
| **`@see`** | 2 | "Ver también" (se coloca al final). | `@see Factura` |
| **`@deprecated`**| 2 | Marcar código viejo/obsoleto. | `@deprecated Usa {@link #nuevoMetodo()} mejor.` |
| **`{@code}`** | 3 | Dar formato de código (fuente monoespaciada). | `Si el valor es {@code null}...` |
| **`{@value}`** | 3 | Imprimir el valor real de una constante. | `El IVA es {@value}.` |
| **`@version`** | 3 | Control de versiones del archivo. | `@version 1.5` |
| **`{@inheritDoc}`**| 3 | Copiar documentación de la clase padre o interfaz. | Al sobrescribir `toString()` o métodos heredados. |

---

## 2. Flujo de Trabajo (Estrategia de Documentación)

Cuando escribas código nuevo, sigue este orden mental para documentar rápido y bien:

1.  **Lo Básico (Obligatorio):**
    * Escribe la descripción: `/** Qué hace el método */`
    * Documenta las entradas: `@param`
    * Documenta la salida: `@return`

2.  **La Protección (Seguridad):**
    * Si tu código valida datos y lanza errores (`throw`), documéntalos siempre con `@throws`.

3.  **La Conexión (Contexto):**
    * Si mencionas otra clase de tu proyecto, enlázala con `{@link Clase}`.
    * Si usas una constante importante, muestra su valor con `{@value}`.

4.  **El Estilo (Profesionalidad):**
    * Repasa el texto. ¿Hay palabras reservadas (`null`, `true`, `int`, `false`)? Envuélvelas en `{@code ...}` para que destaquen.

---

## 3. Ejemplos Prácticos por Nivel

### Nivel 1: Lo Esencial
```java
/**
 * Suma dos números.
 * @param a Primer número.
 * @param b Segundo número.
 * @return La suma de a y b.
 */
public int sumar(int a, int b) { ... }
```

la etiqueta `@since` : Se utiliza para indicar "desde cuándo" existe esa clase, método o campo en tu software.

Significado: "Since" significa "Desde" en inglés.

Propósito: Informar a otros desarrolladores (o a ti mismo en el futuro) en qué versión de tu proyecto se introdujo ese código específico.

Cuándo usarla: Normalmente se añade cuando creas una nueva funcionalidad o cuando modificas algo importante en una actualización


 @version 2.1
@since 1.0  <-- Indica que esta clase existe desde la versión 1.0 del programa*/

`@see` = enlace a algo relacionado

Va en JavaDoc

Se usa para ayudar a entender el código


`@deprecated` = no usar más

Se deja para código viejo

Siempre decí qué usar en lugar de eso

Usar JavaDoc + @Deprecated


```java 
/**
 * Calcula el precio con IVA.
 *
 * @deprecated Usar {@link #precioFinal(double)} en su lugar.
 */
@Deprecated
public double calcularPrecio(double precio) {
    return precio * 1.21;
}

```
{@inheritDoc}
hereda la descripción del padre.


´{@code }
Mostrar código en texto

```java
/**
 * Devuelve true si {@code edad > 18}.
 */
public boolean esMayor(int edad) {
    return edad > 18;
}

```

{@value}

apuntando a otra constante → {@value Clase#CONSTANTE}



```java
public class Config {

    /**
     * Edad mínima permitida: {@value}.
     */
    public static final int EDAD_MINIMA = 18;
}


```


apuntando a otra clase

```java

/**
 * Edad mínima del sistema: {@value Config#EDAD_MINIMA}.
 */
public class Usuario {
}

```


ejemplo completo: 
```java
/**
 * Representa un usuario.
 * Edad mínima: {@value Config#EDAD_MINIMA}.
 */
public class Usuario {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean esValido() {
        return edad >= Config.EDAD_MINIMA;
    }
}


```



/**
     * Calcula la suma de todos los subtotales de las líneas del pedido.
     *
     * @return El monto total acumulado sin aplicar impuestos.
     *
     * @deprecated Desde la versión 2.5. Este cálculo no soporta múltiples tipos de IVA
     * ni descuentos globales. En su lugar, utilice {@link #calcularBaseImponible()}.
     */
    @Deprecated
    public double calcularTotalSinIva() {
        double total = 0;
        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }
        return total;
    }




    /**
     * Calcula el importe final del pedido incluyendo impuestos y descuentos.
     * <p>
     * El cálculo sigue el siguiente orden de aplicación:
     * <ol>
     * <li>Suma de los subtotales de todas las líneas.</li>
     * <li>Aplicación del descuento (si el cliente es frecuente).</li>
     * <li>Aplicación del IVA sobre el resultado anterior.</li>
     * </ol>
     *
     * @return El monto total a pagar (con IVA y descuentos aplicados).
     * @see ConstantesPedido#DESCUENTO_CLIENTE_FRECUENTE
     * @see ConstantesPedido#IVA
     */
    public double calcularTotal() {
        double total = 0;

        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }

        if (cliente.esClienteFrecuente()) {
            total -= total * ConstantesPedido.DESCUENTO_CLIENTE_FRECUENTE;
        }

        return total * (1 + ConstantesPedido.IVA);
    }

    /**
     * Calcula la suma bruta de las líneas del pedido.
     *
     * @return La suma de los subtotales.
     *
     * @deprecated Este método devuelve un valor neto que no refleja el precio final,
     * ya que ignora los descuentos de fidelidad y los impuestos obligatorios.
     * <p>
     * En su lugar, utilice {@link #calcularTotal()} para obtener el precio real.
     */
    @Deprecated
    public double calcularTotalSinIva() {
        double total = 0;

        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }

        return total;
    }
}