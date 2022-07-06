package StringPac;

public class Performance {
    public static void main(String[] args) {
//        String series = "";
//        for(int i=0; i<26; i++){
//            char ch = (char) ('a'+i);
//            System.out.print(ch +" ");  // TIME COMPLEXITY O(N^2)
//            series += ch;
//        }
//        System.out.println();
//        System.out.print(series);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++){
            char ch = (char) ('a'+i);
            sb.append(ch);
        }
        System.out.println(sb);
        System.out.println(sb.deleteCharAt(0));
        System.out.println(sb.reverse());

    }
}
