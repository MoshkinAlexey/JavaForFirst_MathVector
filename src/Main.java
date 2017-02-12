/**
 * Created by user on 09.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        double[] vectorVal1 = {5.0, 2.0},
                vectorVal2 = {2.0, 3.0},
                vectorVal3 = {2, 3, 1},
                vectorVal4 = {3, 2, 6};

        MathVector vector1 = new MathVector(vectorVal1),
                    vector2 = new MathVector(vectorVal2);

        MathVector vector3 = new MathVector(vectorVal3),
                    vector4 = new MathVector(vectorVal4);

        System.out.println(vector3.vectorsMultiple(vector4));

        System.out.println(vector1.scalarMultiple(vector2));
    }
}
