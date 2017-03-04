/**
 * Математичекий вектор произвольной размерности
 * (Вариант №5)
 * Группа №13531/2 ИКНТ СПбПУ.
 * @author Мошкин Алексей
 */

public final class MathVector {
    /*
    Хранение вектора в массиве вещественных значений.
    Объект иммутабельный, т.е. не может изменяться.
     */
    private final double[] vector;
    public final int length;

    /*
    Стандартный конструктор класса.
    Создаёт вектор, размерность которого равна
    длине переданного массива
     */
    public MathVector(double[] vectorValues) {
        vector = new double[vectorValues.length];
        System.arraycopy(vectorValues, 0, vector, 0, vectorValues.length);
        length = vectorValues.length;
    }

    /*
    Доп. конструктор.
    Создаёт нулевой вектор размерности N
     */
    public MathVector(int N) {
        this(new double[N]);
    }


    // Вычисление суммы векторов
    public MathVector sumWith(MathVector other) throws IllegalArgumentException {
        if (this.length == other.length) {
            double[] resultVectorValues = new double[length];
            for (int i=0; i<length; i++) {
                resultVectorValues[i] = vector[i] + other.vector[i];
            }
            return new MathVector(resultVectorValues);
        } else {
            /*
            Операция суммы векторов не может выполняться
            на векторах разной размерности.
             */
            throw new IllegalArgumentException("Incorrect vectors dimensions");
        }
    }

    // Вычисление разности векторов
    public MathVector diffWith(MathVector other) throws IllegalArgumentException {
        if (length == other.length) {
            double[] resultVectorValues = new double[length];
            for (int i=0; i<length; i++) {
                resultVectorValues[i] = vector[i] - other.vector[i];
            }
            return new MathVector(resultVectorValues);
        } else {
            /*
            Операция разности векторов не может выполняться
            на векторах разной размерности.
             */
            throw new IllegalArgumentException("Incorrect vectors dimensions");
        }
    }

    // Деление вектора на число
    public MathVector divideByNumber(double number) {
        double[] resultVectorValues = new double[length];
        for (int i=0; i<length; i++) {
            resultVectorValues[i] = vector[i] / number;
        }
        return new MathVector(resultVectorValues);
    }

    // Умножение вектора на число
    public MathVector multiplyByNumber(double number) {
        double[] resultVectorValues = new double[length];
        for (int i=0; i<length; i++) {
            resultVectorValues[i] = vector[i] * number;
        }
        return new MathVector(resultVectorValues);
    }

    // Вычисление скалярного произведения векторов
    public double scalarMultiply(MathVector other) throws IllegalArgumentException {
        if (length == other.length) {
            double result = 0;
            for (int i=0; i<length; i++) {
                result += vector[i] * other.vector[i];
            }
            return result;
        } else {
            /*
            Операция скалярного произведения векторов не может
            выполняться на векторах разной размерности.
             */
            throw new IllegalArgumentException("Incorrect vectors dimensions");
        }
    }

    // Вычисление модуля вектора
    public double module() {
        double result = 0;
        for (int i=0; i<length; i++) {
            result += vector[i] * vector[i];
        }
        return Math.sqrt(result);
    }

    // Векторное произведение трёхмерных векторов
    public MathVector multiplyWith(MathVector other) throws IllegalArgumentException {
        // Проверка на размерность обоих векторов
        if (length != 3 || length != other.length) {
            /*
            Операция разности векторов не может выполняться
            на векторах разной размерности.
             */
            throw new IllegalArgumentException("Incorrect vectors dimensions");
        }

        double aX = vector[0], aY = vector[1], aZ = vector[2],
                bX = other.vector[0], bY = other.vector[1], bZ = other.vector[2];
        double[] resultVectorValues = {aY*bZ - aZ*bY, aZ*bX - aX*bZ, aX*bY - aY*bX};

        return new MathVector(resultVectorValues);
    }

    // Возвращает копию этого вектора.
    public MathVector copy() {
        return new MathVector(vector);
    }


    /*
    Переопределение стандартных методов класса Object под наши нужны
     */

    @Override
    public String toString() {
        // Вектор принимает вид: { a1, a2, ..., aN }
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        for (int i=0; i<length; i++) {
            result.append(vector[i]);
            if (i != length-1) result.append(", ");
        }
        result.append(" }");
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        MathVector other = (MathVector) obj;
        if (length != other.length) return false;

        for (int i=0; i<length; i++) {
            if (Math.abs(vector[i] - other.vector[i]) > 1e-8) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = length * 3011;
        for (int i=0; i<length; i++) {
            result += (int) (i * vector[i] * 1301);
        }
        return result;
    }
}
