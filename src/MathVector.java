/**
 * Mathematical Vector Class
 * @author Moshkin Alexey
 */
public class MathVector {
    private double[] vector;

    public MathVector(double[] vector) {
        this.vector = vector;
    }

    // Размерность вектора
    private int length() {
        return vector.length;
    }

    private double[] getVector() {
        return this.vector;
    }

    private void setValue(int i, double value) {
        vector[i] = value;
    }

    private double getValue(int i) {
        return vector[i];
    }

    // Вычисление суммы векторов
    public MathVector vectorSum(MathVector other) throws IllegalArgumentException {
        if (this.length() == other.length()) {
            MathVector resultVector = new MathVector(getVector());
            for (int i=0; i<length(); i++) {
                resultVector.setValue(i, getValue(i) + other.getValue(i));
            }
            return resultVector;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Вычисление разности векторов
    public MathVector vectorDiff(MathVector other) throws IllegalArgumentException {
        if (length() == other.length()) {
            MathVector resultVector = new MathVector(getVector());
            for (int i=0; i<length(); i++) {
                resultVector.setValue(i, getValue(i) - other.getValue(i));
            }
            return resultVector;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Деление вектора на число
    public void vectorDiv(double number) {
        for (int i=0; i<length(); i++) {
            setValue(i, getValue(i) / number);
            // Division by zero check
        }
    }

    // Умножение вектора на число
    public void vectorMultiple(double number) {
        for (int i=0; i<length(); i++) {
            setValue(i, getValue(i) * number);
        }
    }

    // Вычисление скалярного произведения векторов
    public double scalarMultiple(MathVector other) throws IllegalArgumentException {
        if (length() == other.length()) {
            double result = 0;
            for (int i=0; i<length(); i++) {
                result += getValue(i) * other.getValue(i);
            }
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Вычисление модуля вектора
    public double vectorModule() {
        double result = 0;
        for (int i=0; i<length(); i++) {
            result += getValue(i) * getValue(i);
        }
        return Math.sqrt(result);
    }
}
