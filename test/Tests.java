import org.junit.Test;
import static org.junit.Assert.*;


public class Tests {
    double[] vectorVals1 = {1.0, 2.0, 0.0}, vectorVals2 = {0.0, 0.0, 0.0},
            vectorVals3 = {3.0, 5.0}, vectorVals4 = {6.4, 2.3}, vectorVals5 = {9.1, -4.5},
            vectorVals6 = {1.1, 1.2, 1.3, 1.6},
            vectorVals7 = {-10000}, vectorVals8 = {10000},
            vectorVals9 = {8.12, 6.11, -2.35}, vectorVals10 = {-2.34, 4.19, 7.63};

    double num1 = 2.0, num2 = 1.0, num3 = 0.0, num4 = 100000000;

    // Одномерные векторы:
    MathVector vector1N1 = new MathVector(vectorVals7),
            vector1N2 = new MathVector(vectorVals8);

    // Двухмерные векторы:
    MathVector vector2N1 = new MathVector(vectorVals3),
            vector2N2 = new MathVector(vectorVals4),
            vector2N3 = new MathVector(vectorVals5);

    // Трёхмерные векторы:
    MathVector vector3N1 = new MathVector(vectorVals1),
            vector3N2 = new MathVector(vectorVals2),
            vector3N3 = new MathVector(vectorVals9),
            vector3N4 = new MathVector(vectorVals10);

    // Четырёхмерный вектор
    MathVector vector4N = new MathVector(vectorVals6);

    @Test // vectorSum(other vector)
    public void checkVectorsSum() {
        assertEquals(vector3N1, vector3N1.vectorsSum(vector3N2));
    }
}
