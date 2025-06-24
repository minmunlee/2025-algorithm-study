import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    static int[][] ingre;
    static boolean[] visited;
    static int N, min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingre = new int[N][2];
        min = Integer.MAX_VALUE;
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            ingre[i][0] = Integer.parseInt(str.nextToken());
            ingre[i][1] = Integer.parseInt(str.nextToken());
        }

        cook(0, 0, 1, 0);
        System.out.println(min);
    }

    public static void cook(int start, int cnt, int s, int b){
        if(cnt > 0){
            int tmp = Math.abs(s - b);
            min = Math.min(min, tmp);
        }
        
        for(int i = start; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                cook(i, cnt + 1, ingre[i][0] * s, ingre[i][1] + b);
                visited[i] = false;
            }
        }
    }
}
