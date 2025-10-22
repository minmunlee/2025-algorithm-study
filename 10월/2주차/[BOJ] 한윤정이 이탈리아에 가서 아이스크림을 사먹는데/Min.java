import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        List<ArrayList<Integer>> list = new ArrayList<>();
        int com = 0;

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 1; i <= N - 2; i++) {
            for(int j = i + 1; j <= N - 1; j++) {
                if(list.get(i).contains(j)) continue;
                for(int k = j + 1; k <= N; k++) {
                    if(list.get(i).contains(k) || list.get(j).contains(k)) continue;
                    com += 1;
                }
            }
        }

        System.out.println(com);
    }    
}
