package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe de Operações Matemáticas")
class SimpleMathTest {

    SimpleMath math = new SimpleMath();

    //executa antes de todos os testes
    @BeforeAll
    static void setup() {
        System.out.println("Run @BeforeAll method!");
    }

    // executa depois de todos os testes
    @AfterAll
    static void cleanup() {
        System.out.println("Run @AfterAll method!");
    }

    @BeforeEach
    void beforeEachMethod() {
        new SimpleMath();
        System.out.println("Run @BeforeEach method!");
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Run @AfterEach method!");
    }


    @Test
    @DisplayName("Teste do metodo sum()")
    void testarSum() {

        System.out.println("Teste do metodo sum()");

        //Given pode ser chamado tbm de Arrange
        Double firstNumber = 10D;
        Double secondNumber = 10D;
        Double expected = 20D;

        //When pode ser chamdo tbm de Act
        Double actual = math.sum(firstNumber, secondNumber);

        //Then pode ser chamado tbm de Asserts
        assertEquals(expected, actual,
                () -> firstNumber + " + " + secondNumber + " O esperado é: " + expected);
//        assertNotEquals(9.2, actual);
//        assertNotNull(actual);
    }

    @Test
    @DisplayName("Teste do metodo subtraction()")
    void subtraction() {

        System.out.println("Teste do metodo subtraction()");

        Double firstNumber = 10.0;
        Double secondNumber = 2.0;

        Double actual = math.subtraction(firstNumber, secondNumber);
        Double expected = 8D;
        assertEquals(expected, actual,
                () -> firstNumber + " - " + secondNumber + " O esperado é: " + expected);
        assertNotEquals(10, actual);
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Teste do metodo multiplication()")
    void multiplication() {

        System.out.println("Teste do metodo multiplication()");

        Double firstNumber = 5D;
        Double secondNumber = 5D;

        Double actual = math.multiplication(firstNumber, secondNumber);
        Double expected = 25D;
        assertEquals(expected, actual,
                () -> firstNumber + " + " + secondNumber + " O esperado é: " + expected);
        assertNotNull(actual);
        assertNotEquals(45, actual);
    }

    @Test
    @DisplayName("Teste do metodo division()")
    void division() {

        System.out.println("Teste do metodo division()");

        Double firstNumber = 5D;
        Double secondNumber = 5D;

        Double actual = math.division(50D, 10D);
        Double expected = 5D;
        assertEquals(expected, actual,
                () -> firstNumber + " / " + secondNumber + " o esperado é: " + expected);
        assertNotEquals(100, actual);
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Teste do metodo mean()")
    void mean() {

        System.out.println("Teste do metodo mean()");

        Double actual = math.mean(50D, 10D);
        Double expected = 30D;
        assertEquals(expected, actual, "");
    }

    @Test
    @DisplayName("Teste do metodo squareRoot()")
    void squareRoot() {

        System.out.println("Teste do metodo squareRoot()");

        Double actual = math.squareRoot(50D, 10D);
        Double expected = 7.0710678118654755;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Teste da validação de divisão por zero")
    void divicionByZero() {
        Double firstNumber = 5D;
        Double secondNumber = 0D;

        var expectedMSG = "Impossivel dividir por zero";

        ArithmeticException actual = assertThrows(ArithmeticException.class,
                () -> {
                    math.division(firstNumber, secondNumber);
                }, () -> "Divisão de zero não permitido e lança a exception ArithmeticException");

        assertEquals(expectedMSG, actual.getMessage(), () -> "Unecpected exception message");
        assertNotNull(actual);
        assertNotEquals("message erro", actual);
    }
}