package String;

public class Panagram {
    public static void main(String[] args) {
        String s = "abc dfekmf ghi jkl mno pqrst ux vxyzw tht";
        System.out.println(isPanagram(s));
    }

    private static boolean isPanagram(String s) {
        if(s.length()<26){
            return false;
        }
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c>='a' && c<='z'){
                visited[c - 'a'] = true;
            }
            if(c>='A' && c<='Z'){
                visited[c - 'A'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if(visited[i] == false)
                return false;
        }
        return true;
    }
}
