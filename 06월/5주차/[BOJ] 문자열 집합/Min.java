import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        List<String> list = new ArrayList<>();
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            if(list.contains(br.readLine())){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}