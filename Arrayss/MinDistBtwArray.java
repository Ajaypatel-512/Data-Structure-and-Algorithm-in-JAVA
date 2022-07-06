package Arrayss;

public class MinDistBtwArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,2};
        int n = 4, x=1, y=2;
        System.out.println(minDist(a,n,x,y));
    }
    static int minDist(int a[], int n, int x, int y) {
        int i=0;
        int xIndex = 0;
        int yIndex = 0;
        while (i<n) {
            if(a[i] != x && a[i] != y){
                return -1;
            }
            for(int j=0; j<n; j++){
                if(a[j] == x){
                    xIndex = j;
                }
                if(a[j] == y) {
                    yIndex = j;
                    break;
                }
            }
            i++;
        }
        return yIndex-xIndex;
    }
}
