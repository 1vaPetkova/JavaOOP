package T05Polymorphism.lab.P01MathOperation;

public class MathOperation {
    public static int add(int n1, int n2) {
        return n1 + n2;
    }

    public static int add(int n1, int n2, int n3) {
        return add(add(n1, n2), n3);
    }

    public static int add(int n1, int n2, int n3, int n4) {
        return add(add(n1, n2, n3), n4);
    }


}
