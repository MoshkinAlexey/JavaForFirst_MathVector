import org.junit.Test;
import static org.junit.Assert.*;


public class Tests {
    @Test // Проверка суммы и разности векторов
    public void checkVectorsSumAndDiff() {
        MathVector vector1 = new MathVector(new double[] {1.2, 1.3, 1.0}),
                vector2 = new MathVector(new double[] {5.4, -4.2, 90.1}),
                vector3 = new MathVector(new double[] {6.6, -2.9, 91.1}),
                vector4 = new MathVector(new double[] {-4.2, 5.5, -89.1}),
                vector5 = new MathVector(new double[] {4.2, -5.5, 89.1});
        assertEquals(vector3, vector1.sumWith(vector2));
        assertEquals(vector3, vector2.sumWith(vector1));
        assertEquals(vector4, vector1.diffWith(vector2));
        assertEquals(vector5, vector2.diffWith(vector1));
    }

    @Test // Проверка умножения и деления вектора на число
    public void checkMultipleAndDivideByNum() {
        MathVector vector1 = new MathVector(new double[] {10, 20, 30}),
                vector2 = new MathVector(new double[] {2, 1}),
                vector3 = new MathVector(new double[] {1, 2, 3}),
                vector4 = new MathVector(new double[] {4, 2});

        assertEquals(vector1, vector3.multiplyByNumber(10));
        assertEquals(vector3, vector1.divideByNumber(10));
        assertEquals(vector4, vector2.multiplyByNumber(2));
        assertEquals(vector2, vector4.divideByNumber(2));
    }

    @Test // Проверка скалярного произведения векторов
    public void checkScalarMultiplication() {
        MathVector vector1 = new MathVector(new double[] {3, 7, 1}),
                vector2 = new MathVector(new double[] {2, 8, 3}),
                vector3 = new MathVector(new double[] {0, 0, 0}),
                vector4 = new MathVector(new double[] {101, 202, -303});

        assertEquals(65.0, vector1.scalarMultiply(vector2), 1e-8);
        assertEquals(0.0, vector3.scalarMultiply(vector4), 1e-8);
        assertEquals(1414.0, vector1.scalarMultiply(vector4), 1e-8);
        assertEquals(0.0, vector2.scalarMultiply(vector3), 1e-8);
        assertEquals(909.0, vector2.scalarMultiply(vector4), 1e-8);
    }

    @Test // Проверка взятия модуля вектора
    public void checkVectorModule() {
        MathVector vector1 = new MathVector(new double[] {-1.8, 2.2, -0.0}),
                vector2 = new MathVector(new double[] {100, 23, -205, 0.007}),
                vector3 = new MathVector(new double[] {0.0, 0.1});

        assertEquals(2.84253, vector1.module(), 1e-4);
        assertEquals( 229.24659, vector2.module(), 1e-4);
        assertEquals(0.1, vector3.module(), 1e-8);
    }

    @Test // Проверка произведения 3х-мерных векторов
    public void checkVectorsMultiplication() {
        MathVector vector1 = new MathVector(new double[] {1.4, 2.3, -2.5}),
                vector2 = new MathVector(new double[] {-5.3, 0.0, 49.2}),
                vector3 = new MathVector(new double[] {2.0, 0.0});

        assertEquals(new MathVector(new double[] {113.16, -55.63, 12.19}), vector1.multiplyWith(vector2));

        try {
            // vector1.length != vector3.length -> exception
            vector1.multiplyWith(vector3);
        } catch (IllegalArgumentException e) {
            assertEquals("Incorrect vectors dimensions", e.getMessage());
        }
    }
}
