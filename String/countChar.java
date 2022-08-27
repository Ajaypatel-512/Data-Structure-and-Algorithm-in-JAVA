package String;

public class countChar {
    public static void main(String[] args) {
        String str = "leetcode";
        int count = 0;
        char search = 'e';

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == search){
                count++;
            }
        }
        System.out.println(search +" : "+ count);
    }
}
