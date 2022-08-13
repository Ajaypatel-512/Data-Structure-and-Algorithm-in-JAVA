package Extra.TCS_NQT;

public class nonRepeating {
    static final int CHAR = 256;
    public static void main(String[] args) {
        String s = "leetcode";
//        int ans = nonRep(s);
//        System.out.println(ans);
        nonRep(s);

    }
    public static void nonRep(String s) {
        int[] count = new int[CHAR];
        int[] ans = new int[CHAR];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i)] == 1){
                System.out.print(i+" ");
            }
        }
    }
}
