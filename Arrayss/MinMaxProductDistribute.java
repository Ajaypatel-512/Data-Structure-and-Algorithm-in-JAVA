package Arrayss;

public class MinMaxProductDistribute {
    public static void main(String[] args) {
        int n = 6;
        int[] quantities = {11,6};
        System.out.println(minimizedMaximum(n,quantities));
    }

    //Solution 1 O(n) O(1)
    public static int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = 0;
        for (int num : quantities)
            high = Math.max(num, high);
        while(low<=high){
            int st_need = 0;
            int mid =(int)(low+high)/2;
            for(int q:quantities){
                st_need +=(int)(q+mid-1)/mid;
            }
            if(st_need<=n) high =mid-1;
            else low = mid+1;
        }
        return low;
    }
}
