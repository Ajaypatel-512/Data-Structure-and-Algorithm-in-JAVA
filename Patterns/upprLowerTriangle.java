package Patterns;

public class upprLowerTriangle {
    public static void main(String[] args) {
        pattern1(5);
        System.out.println();
    }

    private static void pattern1(int n) {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < n-i+1; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < 2 * n; i++) {
            int totalColInRow = i > n ? 2*n-i : i;
            for (int j = 0; j < totalColInRow; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
