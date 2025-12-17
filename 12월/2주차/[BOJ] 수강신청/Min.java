import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(str.nextToken());
        int L = Integer.parseInt(str.nextToken());
        LinkedHashSet<String> hs = new LinkedHashSet<>();

        for(int i = 0; i < L; i++) {
            String student = br.readLine();
            if(hs.contains(student)) {
                hs.remove(student);
                hs.add(student);
            } else {
                hs.add(student);
            }
        }

        int cnt = 0;
        for(String s : hs) {    
            cnt++;
            System.out.println(s);
            if(cnt == K) return;
        }
    }
}