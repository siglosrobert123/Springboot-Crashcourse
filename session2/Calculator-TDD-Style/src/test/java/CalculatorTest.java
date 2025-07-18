import org.example.Calculator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;


    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        calculator.turnOn();
    }

    @Test
    void shouldBeTurnedOn() {
        calculator.turnOn();
        assertTrue(calculator.isOn());
    }

    @Test
    void shouldBeTurnedOff() {
        calculator.turnOff();
        assertTrue(calculator.isOff());
    }

    @Test
    void shouldMinusBothIntegers() {
        int a = 6;
        int b = 2;
        assertEquals(4, calculator.subtract(a, b));
    }

    @Test
    void shouldMinusBothLongs() {
        long a = 15;
        long b = 7;
        assertEquals(8, calculator.subtract(a, b));
    }

    @Test
    void shouldMinusBothShorts() {
        short a = 20;
        short b = 12;
        assertEquals(8, calculator.subtract(a, b));
    }

    @Test
    void shouldMinusBothFloats() {
        float a = 3.7f;
        float b = 2.7f;
        assertEquals(1.0f, calculator.subtract(a, b), 0.001);
    }

    @Test
    void shouldMinusBothDoubles() {
        double a = 8.12;
        double b = 5.12;
        assertEquals(3, calculator.subtract(a, b), 0.001);
    }

    @Test
    void shouldSumBothIntegers() {
        int a = 3;
        int b = 7;
        assertEquals(10, calculator.add(a, b));
    }

    @Test
    void shouldSumBothLongs() {
        long a = 6;
        long b = 12;
        assertEquals(18, calculator.add(a, b));
    }

    @Test
    void shouldSumBothShorts() {
        short a = 12;
        short b = 12;
        assertEquals(24, calculator.add(a, b));
    }

    @Test
    void shouldSumBothFloats() {
        float a = 5.2f;
        float b = 5.4f;
        assertEquals(10.6f, calculator.add(a, b), 0.001);
    }

    @Test
    void shouldSumBothDoubles() {
        double a = 7.12;
        double b = 7.15;
        assertEquals(14.27, calculator.add(a, b), 0.001);
    }

    @Test
    void shouldMultiplyBothIntegers() {
        int a = 3;
        int b = 7;
        assertEquals(21, calculator.multiply(a, b));
    }

    @Test
    void shouldMultiplyBothLongs() {
        long a = 6;
        long b = 12;
        assertEquals(72, calculator.multiply(a, b));
    }

    @Test
    void shouldMultiplyBothShorts() {
        short a = 12;
        short b = 12;
        assertEquals(144, calculator.multiply(a, b));
    }

    @Test
    void shouldMultiplyBothFloats() {
        float a = 5.2f;
        float b = 5.4f;
        assertEquals(28.08f, calculator.multiply(a, b), 0.001);
    }

    @Test
    void shouldMultiplyBothDoubles() {
        double a = 7.12;
        double b = 7.15;
        assertEquals(50.908, calculator.multiply(a, b), 0.001);
    }

    @Test
    void shouldDivideBothIntegers() {
        int a = 5;
        int b = 1;
        assertEquals(5, calculator.divide(a, b));
    }

    @Test
    void shouldDivideBothLongs() {
        long a = 10;
        long b = 2;
        assertEquals(5, calculator.divide(a, b));
    }

    @Test
    void shouldDivideBothShorts() {
        short a = 25;
        short b = 5;
        assertEquals(5, calculator.divide(a, b));
    }

    @Test
    void shouldDivideBothFloats() {
        float a = 50f;
        float b = 10f;
        assertEquals(5.0000f, calculator.divide(a, b), 0.0001);
    }

    @Test
    void shouldDivideBothDoubles() {
        double a = 20.0;
        double b = 4.0;
        assertEquals(5.0000, calculator.divide(a, b), 0.0001);
    }

    @Test
    void shouldReturnArithmeticException () {
        int a = 200000;
        int b = 0;
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> calculator.divide(a, b));
        assertEquals("/ by zero", exception.getMessage());
    }

    @AfterEach
    void teardown() {
        calculator.turnOff();
    }
}
