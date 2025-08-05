import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Min {
    static StringBuilder answer;
    static boolean isTag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        isTag = false;
        answer = new StringBuilder();
        String tmp = "";

        for(int i = 0; i < str.length; i++) {
            if(isTag){
                if(str[i].equals(">")) {
                    isTag = false;
                }
                answer.append(str[i]);
            }else {
                if(str[i].equals("<")){
                    isTag = true;
                    reverse(tmp);
                    tmp = "";
                    answer.append(str[i]);
                }else {
                    if(str[i].equals(" ") || i == str.length - 1) {
                        if(i == str.length - 1) tmp += str[i];
                        reverse(tmp);
                        tmp = "";
                    }else {
                        tmp += str[i];
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static void reverse(String tmp) {
        String[] s = tmp.split("");

        for(int i = s.length - 1; i >= 0; i--) {
            answer.append(s[i]);
        }
        if(!isTag) answer.append(" ");
    }
}
