package String;

public class RotateString {
    public static void main(String[] args) {
//        System.out.println(rotateString("abcde","cdeab"));
        System.out.println(rotateString2("abcde","cdeab"));
    }

    // Solution 1
    public static boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();

        if (n != m)
            return false;

        for (int i=0; i<n; i++){
            String shiftedString = s.substring(i) + s.substring(0, i);
            if (shiftedString.equals(goal))
                return true;
        }
        return false;
    }

    // Solution 2
    public static boolean rotateString2(String s, String goal) {
        int n = s.length();
        int m = goal.length();

        if (n != m)
            return false;

        String sb = s + s;
        return sb.contains(goal);
    }

}
