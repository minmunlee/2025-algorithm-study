import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Min {
    static int[] num = {1, 5, 10, 50};
    static int N, cnt;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        visited = new boolean[1001];
        dfs(0, 0, 0);
        System.out.println(cnt);
    }

    public static void dfs(int depth, int sum, int index) {
        if(depth == N) {
            if(!visited[sum]) {
                visited[sum] = true;
                cnt++;
            }
            return;
        }

        for(int i = index; i < 4; i++) {
            dfs(depth + 1, sum + num[i], i);
        }
    }
}