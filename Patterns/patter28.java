package Patterns;

public class patter28 {
    public static void main(String[] args) {
        pattern1(5);
        System.out.println();
    }

    static void pattern1(int n) {
        for (int i = 0; i < 2*n; i++) {
            int totalColInRow = i > n ? 2*n-i : i;

            int spaces = n-totalColInRow;
            for (int j = 0; j < spaces; j++) {
                System.out.print    (" ");
            }

            for (int j = 0; j < totalColInRow; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
