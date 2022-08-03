package LinkedList;

public class Happy_Number {
    public boolean isHappy(int n){
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(fast != slow);

        if (slow == 1){
            return true;
        }
        return false;
    }
    private int findSquare(int i){
        int ans = 0;
        while(i>0) {
            int r = i % 10;
            ans += r * r;
            i = i / 10;
        }
        return ans;
    }
}
