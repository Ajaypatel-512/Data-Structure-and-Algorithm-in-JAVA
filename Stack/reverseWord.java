package Stack;

public class reverseWord {
    public static void main(String[] args) {
        String str = "ajay patel hi";
        String[] word = str.split("\\s");
        String rev = "";

//        for (int i=0; i<word.length; i++) {
//            if(i == word.length-1){
//                rev = word[i] +rev;
//            }else{
//                rev = " "+word[i]+rev;
//            }
//        }

        for (int i = word.length-1; i >= 0 ; i--) {
            rev = rev + " " + word[i];
        }
        System.out.println(rev.trim());
    }
}
