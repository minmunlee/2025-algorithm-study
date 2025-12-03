import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        int cnt = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i].equals("Y")) {
                cnt += 1;
                for(int j = i; j < s.length; j += (i + 1)) {
                    if(s[j].equals("N")) {
                        s[j] = "Y";
                    }else {
                        s[j] = "N";
                    }
                }
            }
        }
        
        for(String str : s) {
            if(str.equals("Y")) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);
    }
}