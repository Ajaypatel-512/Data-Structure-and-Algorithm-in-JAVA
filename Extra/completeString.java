package Extra;

public class completeString {
    public static void main(String[] args) {
        String w = "beautiful";
        String i = "butl";
        System.out.println(isComplete(i, w));
    }

    public static boolean isComplete(String i, String w){
        int v = -1;
        String newstr = "";
        for(int k = 0; k<i.length(); k++){
            for(int j=v+1; j<w.length(); j++){
                if(i.charAt(k) == w.charAt(j)){
                    v = j;
                    newstr = newstr+i.charAt(k);
                    break;
                }
            }
        }
        return newstr.equals(i);
    }
}
