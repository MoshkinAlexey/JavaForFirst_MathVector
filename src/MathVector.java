/**
 * Математичекий вектор произвольной размерности
 * (Вариант №5)
 * Группа №13531/2 ИКНТ СПбПУ.
 * @author Мошкин Алексей
 */

public final class MathVector {
    /*
    Хранение вектора в массиве вещественных значений.
    Не final, так как над ним выполняются действия,
    меняющие значения.
     */
    private double[] vector;

    /*
    Стандартный конструктор класса.
    Создаёт вектор, размерность которого равна
    длине переданного массива
     */
    public MathVector(double[] vectorValues) {
        vector = vectorValues;
    }

    /*
    Доп. конструктор.
    Создаёт нулевой вектор размерности N
     */
    public MathVector(int N) {
        this(new double[N]);
    }

    /*
    Возвращает длину массива, в котором хранится вектор
    (Размерность вектора)
     */
    private int length() {
        return vector.length;
    }

    // Возвращает массив значений вектора
    private double[] getVector() {
        return this.vector;
    }

    // Меняет значение координаты i данного вектора на значение value
    private void setValue(int i, double value) {
        vector[i] = value;
    }

    // Возвращает значение координаты i данного вектора
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
            /*
            Операция суммы векторов не может выполняться
            на векторах разной размерности.
             */
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
            /*
            Операция разности векторов не может выполняться
            на векторах разной размерности.
             */
            throw new IllegalArgumentException();
        }
    }

    // Деление вектора на число
    public void vectorDivByNum(double number) {
        for (int i=0; i<length(); i++) {
            setValue(i, getValue(i) / number);
            // Division by zero check in test
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
            /*
            Операция скалярного произведения векторов не может
            выполняться на векторах разной размерности.
             */
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
    public MathVector vectorsMultiple(MathVector other) throws IllegalArgumentException {
        // Проверка на размерность обоих векторов
        if (this.length() != 3 || this.length() != other.length()) {
            throw new IllegalArgumentException();
        }

        double Ax = this.getValue(0), Ay = this.getValue(1), Az = this.getValue(2),
                Bx = other.getValue(0), By = other.getValue(1), Bz = other.getValue(2);
        double[] resultVectorValues = {Ay*Bz - Az*By, Az*Bx - Ax*Bz, Ax*By - Ay*Bx};

        return new MathVector(resultVectorValues);
    }

    /*
    Переопределение стандартных методов класса Object под наши нужны
     */
    @Override
    public String toString() {
        // Вектор принимает вид: { a1, a2, ..., aN }
        String result = "{ ";
        for (int i=0; i<length(); i++) {
            result += getValue(i);
            if (i != length()-1) result += ", ";
        }
        result += " }";
        return result;
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

        return this.length() == other.length() &&
                this.getVector() == other.getVector();
    }

    @Override
    public int hashCode() {
        int result = length() * 3011;
        for (int i=0; i<length(); i++) {
            result += (int) (i*vector[i]*1301);
        }
        return result;
    }
}
