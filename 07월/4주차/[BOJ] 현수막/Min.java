import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    static int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());

        M = Integer.parseInt(str.nextToken());
        N = Integer.parseInt(str.nextToken());

        arr = new int[M][N];
        for(int i = 0; i < M; i ++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        visited = new boolean[M][N];
        int cnt = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && arr[i][j] == 1){
                    cnt += 1;
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isLetter(nx, ny)){
                dfs(nx, ny);
            }
        }
    }

    public static boolean isLetter(int x, int y) {
        if(x >= 0 && x < M && y >= 0 && y < N) {
            if(!visited[x][y] && arr[x][y] == 1) {
                return true;
            }
        }
        return false;
    }
    
}
