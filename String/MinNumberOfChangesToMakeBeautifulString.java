package String;

public class MinNumberOfChangesToMakeBeautifulString {
    public static void main(String[] args) {
        System.out.println(minChanges("1001"));
    }

    //Solution 1 O(n) O(n)
    public static int minChanges(String s) {
        int n = s.length();

        char currentCh = s.charAt(0);
        int count = 0;
        int changes = 0;

        for (int i=0; i<n; i++){
            if (s.charAt(i) == currentCh){
                count++;
                continue;
            }

            if (count %2 == 0){
                count = 1;
            } else {
                changes += 1;
                count = 0;
            }

            currentCh = s.charAt(i);

        }
        return changes;
    }

}
