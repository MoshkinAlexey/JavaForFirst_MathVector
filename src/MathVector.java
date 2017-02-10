/**
 * Mathematical Vector Class
 * @author Moshkin Alexey
 */

public class MathVector {
    private double[] vector;

    public MathVector(double[] vectorValues) {
        vector = vectorValues;
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
    public MathVector vectorsSum(MathVector other) throws IllegalArgumentException {
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
    public MathVector vectorsDiff(MathVector other) throws IllegalArgumentException {
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
    public void vectorDivByNum(double number) {
        for (int i=0; i<length(); i++) {
            setValue(i, getValue(i) / number);
            // Division by zero check
        }
    }

    // Умножение вектора на число
    public void vectorMultipleByNum(double number) {
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

    // Векторное произведение трёхмерных векторов
    public MathVector vectorsMuliple(MathVector other) throws IllegalArgumentException {
        if (this.length() != 3 || this.length() != other.length()) {
            throw new IllegalArgumentException();
        }

        double Ax = this.getValue(0), Ay = this.getValue(1), Az = this.getValue(2),
                Bx = other.getValue(0), By = other.getValue(1), Bz = other.getValue(2);
        double[] resultVectorValues = {Ay*Bz - Az*By, Az*Bx - Ax*Bz, Ax*By - Ay*Bx};

        return new MathVector(resultVectorValues);
    }

    @Override
    public String toString() {
        String result = "{ ";
        for (int i=0; i<length(); i++) {
            result += getValue(i);
            if (i != length()-1) result += ", ";
        }
        result += " }";
        return result;
    }
}
