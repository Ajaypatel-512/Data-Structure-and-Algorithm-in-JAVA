package Recursion.Array;

import java.util.ArrayList;
import java.util.List;
/**
 *
 *
 * TIME COMPLEXITY   -  O(n * 2^n)
 * Space Complexity  -  O(n * 2^n)
 *
 * **/
public class Subset {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = subSet(arr);
        for (List<Integer> list: ans) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> subSet(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int num : arr) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
}
