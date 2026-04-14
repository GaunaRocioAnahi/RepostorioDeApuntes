package es.stemgranada.ed.testing.calculadora;

/*
 * JUnit NO forma parte del lenguaje Java estándar.
 *
 * Para poder usar @Test, @BeforeEach, assertEquals, etc.,
 * es necesario que el proyecto incluya la librería JUnit 5.
 *
 * Esto puede hacerse de dos formas:
 *
 *   1) Añadiendo manualmente los JAR de JUnit al proyecto.
 *      (No recomendado en proyectos profesionales.)
 *
 *   2) (RECOMENDADO) Usando un proyecto gestionado con Maven
 *      que incluya la dependencia:
 *
 *      <dependency>
 *          <groupId>org.springframework.boot</groupId>
 *          <artifactId>spring-boot-starter-test</artifactId>
 *          <scope>test</scope>
 *      </dependency>
 *
 * En este ejemplo estamos trabajando dentro de un proyecto Maven,
 * por lo que JUnit 5 ya está disponible automáticamente en
 * src/test/java y podemos importar sus anotaciones sin problemas.
 */

/*
 * Importamos las anotaciones de JUnit 5 necesarias para definir
 * el ciclo de vida y los métodos de prueba.
 */

// Se ejecuta antes de cada test. Permite preparar el entorno.
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

//PASO 1- Nombre de la clase = clase +Test 
// ----- NO NECESITA SER PÚBLICA EN JUnit 5 -----

class CalculadoraTest {
    
    /// PASO 2 -  DECLARAR EL OBJETO COMO APTRIBUTO DE LA CLASE
    /// ---- ( FUERA DE LOS METODOS, COMPARTIDO POR TODOS LOS TESTS)---
    
    private Calculadora calculadora;

    /// PASO 3 -@BeforeEach: se ejecuta ANTES de cada @Test 
    ///        GARANTIZA QUE CADA TEST EMPIZA CON OBJETO LIMPIO
    ///        EVITA REPETIR "new Calculadora()" en cada mètodo

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    // PRUEBAS DE SUMA

    ///  PASO 4+6 - Un @Test por comportamietno, nombre descriptivo :
    ///  método_resultado_condición
    /// 
    @Test
    @DisplayName("La suma de 2 y 3 debe ser 5")
    void sumar_devuelve5_si2Mas3() {

        // Arrange: se preparan los datos de entrada que se van a usar en la prueba.
        // En este caso, los dos números que se van a sumar.
        int a = 2;
        int b = 3;

        // Act: se ejecuta el método que se quiere verificar.
        // Aquí se llama a sumar con los valores preparados.
        int resultado = calculadora.sumar(a, b);

        // Assert: se comprueba que el resultado obtenido coincide
        // con el valor esperado según el comportamiento definido.
        assertEquals(5, resultado);
    }

    @Test
    void sumar_devuelveNegativo_siAmbosSonNegativos(){
        int resultado = calculadora.sumar ( -4, -6);
        assertEquals(-10, resultado);
    }

    // RESTAR

    @Test 
    void restar_devuelve2_si5Menos3(){
        int resultado = calculadora.restar(5, 3);
        assertEquals(2, resultado);
    }
    @Test
    void  restar_devuelveNegativo_siResultadoEsNegativo(){
        int resultado = calculadora.restar(3,10);
        assertEquals(-7, resultado);
    }

    // MULTIPLICAR


    @Test 
    void multiplicar_devuelve12_si3por4(){
        int resultado = calculadora.multiplicar(3, 4);
        assertEquals(12, resultado);
    }

    @Test 
    void multiplicar_devuelve0_siUnFactorEsCero(){
        int resultado = calculadora.multiplicar(99, 0);
        assertEquals(0,resultado);
    }

    @Test 
    void multiplicar_devuelvePositivo_siAmbosNegativos(){
        int resultado = calculadora.multiplicar(-3, -4);
        assertEquals(12, resultado);
    }

    // PRUEBAS DE DIVISIÓN

    @Test 
    void dividir_devuelve5_si10Entre2() {

        double resultado = calculadora.dividir(10, 2);

        // En operaciones con double se usa delta para evitar
        // pequeños errores de precisión.
        assertEquals(5.0, resultado, 0.0001);
    }

    @Test
    void dividir_lanzaExcepcion_siDivisorEsCero() {

        // Se comprueba que al ejecutar este método
        // se lanza una IllegalArgumentException.
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.dividir(10, 0));
    }

    // PRUEBAS DE POTENCIA

    @Test
    void potencia_devuelve8_siBase2_yExponente3() {

        double resultado = calculadora.potencia(2, 3);

        assertEquals(8.0, resultado, 0.0001);
    }

    @Test
    void potencia_lanzaExcepcion_siExponenteNegativo() {

        // Se verifica que el método no acepta exponentes negativos
        // y que responde lanzando la excepción esperada.
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.potencia(2, -1));
    }

    // PRUEBAS DE MEDIA

    @Test
    @DisplayName("La media de 2,4,6 debe ser 4")
    void media_devuelve4_siValores2_4_6() {

        double[] valores = { 2, 4, 6 };

        double resultado = calculadora.media(valores);

        assertEquals(4.0, resultado, 0.0001);
    }

    @Test
    @DisplayName("Array vacío debe lanzar excepción")
    void media_lanzaExcepcion_siArrayVacio() {

        double[] valores = {};

        // Se comprueba que no se permite calcular la media
        // de un array vacío.
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.media(valores));
    }

    @Test
    @DisplayName("Array null debe lanzar excepción")
    void media_lanzaExcepcion_siArrayNull() {

        // También se valida que null no es una entrada válida.
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.media(null));
    }

    // PRUEBAS BOOLEANAS

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 10, 100 })
    @DisplayName("Debe identificar números pares")
    void esPar_devuelveTrue_paraNumerosPares_parametrizado(int numero) {

        assertTrue(calculadora.esPar(numero));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 3, 7, 99 })
    @DisplayName("Debe identificar números impares")
    void esPar_devuelveFalse_paraNumerosImpares_parametrizado(int numero) {

        assertFalse(calculadora.esPar(numero));
    }

    // PRUEBAS DE FACTORIAL

    @Test
    @DisplayName("El factorial de 5 debe ser 120")
    void factorial_devuelve120_siEntrada5() {

        long resultado = calculadora.factorial(5);

        assertEquals(120, resultado);
    }

    @Test
    @DisplayName("El factorial de 0 debe ser 1 (caso límite)")
    void factorial_devuelve1_siEntrada0() {

        assertEquals(1, calculadora.factorial(0));
    }

    @Test
    @DisplayName("Número negativo debe lanzar excepción")
    void factorial_lanzaExcepcion_siEntradaNegativa() {

        /*
         * Aquí aparece una expresión lambda:
         *
         * () -> calculadora.factorial(-3)
         *
         * Una lambda es una forma compacta de pasar un bloque de código
         * como si fuera un dato. En este caso, no se ejecuta inmediatamente.
         *
         * JUnit recibe ese bloque, lo ejecuta internamente y comprueba
         * si lanza la excepción indicada en el primer parámetro.
         *
         * Es equivalente a hacer un try-catch manual,
         * pero de forma más limpia y controlada.
         */
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.factorial(-3));
    }

    // PRUEBA PARAMETRIZADA CON CSV

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,2",
            "3,6",
            "4,24"
    })
    @DisplayName("Prueba parametrizada de factorial con CSV")
    void factorial_devuelveResultadoCorrecto_paraMultiplesEntradas_csv(int entrada, long esperado) {

        long resultado = calculadora.factorial(entrada);

        assertEquals(esperado, resultado);
    }
}
