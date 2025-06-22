import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Min {
    static String[] alpha;
    static int L, C;
    static TreeSet<String> ts;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        L = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(br.readLine());
        alpha = new String[C];
        for(int i = 0 ; i < C; i++){
            alpha[i] = str.nextToken();
        }

        Arrays.sort(alpha); // a c i s t w
        ts = new TreeSet<>();
        visited = new boolean[C];
        makePassword(0, "");

        for(String s : ts) {
            System.out.println(s);
        }
    }
    
    public static void makePassword(int len, String s) {
        if(len == L) {
            if(isCollectPassWord(s)){
                ts.add(s);
            }
            return;
        }

        for(int i = len; i < C; i++) {
            if(!visited[i]){
                visited[i] = true;
                if(s.length() > 0 && alpha[i].compareTo(s.substring(s.length() - 1)) < 0){
                    visited[i] = false;
                    continue;
                } 
                makePassword(len + 1, s + alpha[i]);
                visited[i] = false;
            }
        }
    }

    public static boolean isCollectPassWord(String s) {
        if(s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")){
            s = s.replace("a", "");
            s = s.replace("e", "");
            s = s.replace("i", "");
            s = s.replace("o", "");
            s = s.replace("u", "");
            if(s.length() >= 2) return true;
        }
        return false;
    }
}
