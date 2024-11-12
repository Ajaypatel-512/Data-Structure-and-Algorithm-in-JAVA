package Arrayss;

import java.util.Arrays;

public class MostBeautifulItemForEachQuery {
    public static void main(String[] args) {
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = {1,2,3,4,5,6};

        int[] result = maximumBeauty(items,queries);
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
}
