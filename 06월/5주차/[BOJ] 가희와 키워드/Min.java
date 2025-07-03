import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        HashSet<String> memo = new HashSet<>();
        for(int i = 0; i < N; i++) {
            memo.add(br.readLine());
        }

        for(int i = 0; i < M; i++) {
            String[] words = br.readLine().split(",");
            for(String word : words) {
                memo.remove(word);
            }

            System.out.println(memo.size());
        }
    }
}
