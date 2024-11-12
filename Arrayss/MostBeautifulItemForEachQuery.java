package Arrayss;

import java.util.Arrays;
import java.util.Comparator;

public class MostBeautifulItemForEachQuery {
    public static void main(String[] args) {
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = {1,2,3,4,5,6};

        int[] result = maximumBeauty2(items,queries);
        System.out.println(Arrays.toString(result));
    }

    //Solution 1 O(q*n) O(q)
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int q = queries.length;
        int n = items.length;

        int[] result = new int[q];

        for (int i=0; i<q; i++){
            int maxBeauty = 0;
            for (int j=0; j<n; j++){
                if (queries[i] >= items[j][0]){
                    maxBeauty = Math.max(maxBeauty,items[j][1]);
                }
            }
            result[i] = maxBeauty;
        }
        return result;
    }

    //Solution 2 Using Binary Search
    //O(n) O(q)
    public static int[] maximumBeauty2(int[][] items, int[] queries) {
        int n = items.length;
        int m = queries.length;
        int[] result = new int[m];

        // Step 1: Sort the items based on price in ascending order
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        // Update beauty values to make them non-decreasing
        int maxBeautySeen = items[0][1];
        for (int i = 1; i < n; i++) {
            maxBeautySeen = Math.max(maxBeautySeen, items[i][1]);
            items[i][1] = maxBeautySeen;
        }

        // Process each query using custom binary search
        for (int i = 0; i < m; i++) {
            int queryPrice = queries[i];
            result[i] = customBinarySearch(items, queryPrice);
        }

        return result;
    }

    private static int customBinarySearch(int[][] items, int queryPrice) {
        int l = 0;
        int r = items.length-1;
        int maxBeauty = 0;

        while (l<=r){
            int mid = l+ (r-l)/2;
            if (items[mid][0] > queryPrice){
                r = mid-1;
            } else {
                maxBeauty = Math.max(maxBeauty,items[mid][1]);
                l = mid+1;
            }
            return maxBeauty;
        }

        return 0;
    }

}
