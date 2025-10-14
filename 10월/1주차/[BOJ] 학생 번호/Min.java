import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] num = new String[N];

        for(int i = 0; i < N; i++) {
            num[i] = br.readLine();
        }
        int len = num[0].length();

        for(int i = 1; i <= len; i++) {
            HashSet<String> hs = new HashSet<>();
            for(int j = 0; j < N; j++) {
                hs.add(num[j].substring(len - i, len));
            }
            if(hs.size() == num.length) {
                System.out.println(i);
                return;
            }
        }
        
    }
}