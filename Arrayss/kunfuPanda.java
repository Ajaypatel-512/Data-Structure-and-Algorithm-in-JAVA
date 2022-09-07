package Arrayss;

import java.util.HashMap;

public class kunfuPanda {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {3,3,4,5,6};
//        System.out.println(maxCost(arr,n));
        System.out.println(deleteAndEarn(arr));
    }

    static int maxCost(int a[], int n) {
        int l = 1,r = 1;
        int mx = 0, k;

        for (int i = 0; i < n; ++i)
            mx = Math.max(mx, a[i]);

        int[] count = new int[mx + 1];
        for(int i = 0; i < count.length; i++)
            count[i] = 0;

        for (int i = 0; i < n; i++)
            count[a[i]]++;
        int[] res = new int[mx + 1];
        res[0] = 0;
        l = Math.min(l, r);
        for (int num = 1; num <= mx; num++) {
            k = Math.max(num - l - 1, 0);
            res[num] = Math.max(res[num - 1], num * count[num] + res[k]);
        }
        return res[mx];
    }

    public static int deleteAndEarn(int[] nums) {
        var numToCount = new HashMap<Integer, Integer>();
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;
        for (var num : nums) {
            numToCount.compute(num, (k, v) -> v == null ? 1 : ++v);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        var prevIncEarn = 0;
        var prevExcEarn = 0;
        for (var i = min; i <= max; i++) {
            var incEarn = prevExcEarn + i * numToCount.getOrDefault(i, 0);
            var excEarn = Math.max(prevIncEarn, prevExcEarn);
            prevIncEarn = incEarn;
            prevExcEarn = excEarn;
        }
        return Math.max(prevIncEarn, prevExcEarn);
    }
}
