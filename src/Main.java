/**
 * Created by user on 09.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        double[] vectorVal1 = {5.0, 2.0},
                vectorVal2 = {2.0, 3.0};

        MathVector vector1 = new MathVector(vectorVal1),
                    vector2 = new MathVector(vectorVal2);

        System.out.println(vector1.scalarMultiple(vector2));
    }
}
