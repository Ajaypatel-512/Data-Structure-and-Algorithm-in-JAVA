package Arrayss;

import java.util.*;
import java.util.stream.IntStream;

public class UnionOfTwoSortedArrays {
    /**
     * Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
     *
     * The union of two arrays can be defined as the common and distinct elements in the two arrays.
     * NOTE: Elements in the union should be in ascending order.
     *
     * Example 1:
     * Input:
     * n = 5,m = 5.
     * arr1[] = {1,2,3,4,5}
     * arr2[] = {2,3,4,4,5}
     * Output:
     *  {1,2,3,4,5}
     *
     * Explanation:
     * Common Elements in arr1 and arr2  are:  2,3,4,5
     * Distnict Elements in arr1 are : 1
     * Distnict Elemennts in arr2 are : No distinct elements.
     * Union of arr1 and arr2 is {1,2,3,4,5}
     *
     * Example 2:
     * Input:
     * n = 10,m = 7.
     * arr1[] = {1,2,3,4,5,6,7,8,9,10}
     * arr2[] = {2,3,4,4,5,11,12}
     * Output: {1,2,3,4,5,6,7,8,9,10,11,12}
     * Explanation:
     * Common Elements in arr1 and arr2  are:  2,3,4,5
     * Distnict Elements in arr1 are : 1,6,7,8,9,10
     * Distnict Elemennts in arr2 are : 11,12
     * Union of arr1 and arr2 is {1,2,3,4,5,6,7,8,9,10,11,12}
     * */
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 4, 5};
        int n = arr1.length;
        int m = arr2.length;

        int[] unionArray = findUnion(arr1, arr2, n, m);
        for (int num : unionArray) {
            System.out.print(num + " ");
        }
    }

    //Solution 1: Two Pointer
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m) for the union array
    public static int[] findUnion(int[] arr1, int[] arr2, int n, int m) {
        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();

        while (i<n && j<m){
            if (arr1[i] < arr2[j]){
                result.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                result.add(arr2[j]);
                j++;
            } else {
                // If both are equal, add one and move both pointers
                result.add(arr1[i]);
                i++;
                j++;
            }
        }

        while (i < n) result.add(arr1[i++]);
        while (j < m) result.add(arr2[j++]);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    //Solution 2: Using HashSet
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m) for the union array
    public static int[] findUnionUsingHashSet(int[] arr1, int[] arr2, int n, int m) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            set.add(num);
        }

        result.addAll(set);
        result.sort(Integer::compareTo); // Sort the result to maintain ascending order

        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    //Solution 3: Using Stream
    // Time Complexity: O(n + m)
    // Space Complexity: O(n + m) for the union array
    public static int[] findUnionUsingStream(int[] arr1, int[] arr2, int n, int m) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .distinct()
                .sorted()
                .toArray();
    }

    //Solution 4: Using Binary Search
    // Time Complexity: O(n log m + m log n) in the worst case
    // Space Complexity: O(n + m) for the union array
    public static boolean binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x) return true;
            else if (arr[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

    public static void union(int[] a, int[] b) {
        Set<Integer> unionSet = new TreeSet<>();
        for (int num : a) unionSet.add(num);
        for (int num : b) {
            if (!binarySearch(a, num)) unionSet.add(num);
        }

        for (int num : unionSet) System.out.print(num + " ");
    }

}
