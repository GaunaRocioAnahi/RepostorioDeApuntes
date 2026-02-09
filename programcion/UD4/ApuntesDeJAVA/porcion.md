´´´java
// 1. mat.length() - 1 me da la posición de la última letra
// 2. mat.charAt(...) coge esa letra. Ejemplo: De "1234ABC" coge 'C'. De "5678" coge '8'.
char ultimaLetra = mat.charAt(mat.length() - 1);

// 3. ¿Es un número? (Evitamos que el programa falle si la matricula termina en letra 'C')
if (Character.isDigit(ultimaLetra)) {
    
    // 4. Convertimos el dibujo '8' al valor matemático 8
    int ultimoNumero = Character.getNumericValue(ultimaLetra);
    
    // 5. La prueba del par: Si el resto de dividir por 2 es 0, es par.
    if (ultimoNumero % 2 == 0) {
        costeTotal = costeTotal * 0.90; // Multiplicar por 0.9 es restar el 10%
    }
}
```
Este bloque es el único que cambia respecto al ejercicio de los tractores. ¡Todo lo demás (menú, añadir, listar, borrar) es idéntico a lo que ya sabes!