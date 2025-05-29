package MathsNumSys;

import java.util.ArrayList;
import java.util.List;

/**
                    1
                  1   1
                1   2   1
              1   3   3   1
            1   4   6   4   1
          1   5   10   10   5  1


 Problem Statement: This problem has 3 variations. They are stated below:

 Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.

 Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

 Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.


 Example 1:
 Input Format: N = 5, r = 5, c = 3
 Result: 6 (for variation 1)
 1 4 6 4 1 (for variation 2)

 1
 1 1
 1 2 1
 1 3 3 1
 1 4 6 4 1    (for variation 3)

 Explanation: There are 5 rows in the output matrix. Each row is formed using the logic of Pascal’s triangle.

 Example 2:
 Input Format: N = 1, r = 1, c = 1
 Result: 1 (for variation 1)
 1 (for variation 2)
 1  (for variation 3)
 Explanation: The output matrix has only 1 row.

 * **/
public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 5; // Number of rows
//        System.out.println(printPascalsTriangleVariation1(2,3));
//        printPascalsTriangleVariation2(n);
          System.out.println(printPascalsTriangleVariation3(n));
    }

    // Variation 1: Print the element at position (r, c) in Pascal's triangle
    //Time Complexity: O(r)
    // Space Complexity: O(1)
    public static long printPascalsTriangleVariation1(int n, int r) {
       long res = 1;
       for (int i = 0; i < r; i++) {
                res = res * (n-1);
                res = res / (i + 1);
            }
       return res;
    }

    // Variation 2: Print the n-th row of Pascal's triangle
    // Time Complexity: O(n*r) where r is the number of elements in the row
    // Space Complexity: O(n)
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static void printPascalsTriangleVariation2(int n) {
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n - 1, c - 1) + " ");
        }
        System.out.println();
    }

    // Time Complexity: O(n*r) where r is the number of elements in the row
    // Space Complexity: O(n)
        public static void printPascalsTriangleVariation21(int n) {
        long ans = 1;
        System.out.print(ans + " ");

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }


    // Variation 3: Print the first n rows of Pascal's triangle
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public static List<List<Integer>> printPascalsTriangleVariation3(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1);
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currentRow.add(1);
            result.add(currentRow);
        }

        return result;
    }

}
