import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    static int[][] arr;
    static int[] dx = {0, -1, 0, 1}; // 왼 위 오른 아래
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[1005][1005];
        for(int i = 1; i <= N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
                if(arr[i][j] == 1) arr[i][j] = -1; // 거울 있는 곳
            }
        }
        arr = setHole();

        // 왼쪽
        for(int i = 1; i <= N; i++){
            System.out.print(dfs(i, 0, 0) + " ");
        }

        // 아래
        for(int i = 1; i <= M; i++){
            System.out.print(dfs(N + 1, i, 1) + " ");
        }

        // 오른쪽
        for(int i = N; i > 0; i--){
            System.out.print(dfs(i, M + 1, 2) + " ");
        }

        // 위
        for(int i = M; i > 0; i--){
            System.out.print(dfs(0, i, 3) + " ");
        }
    }

    public static int[][] setHole(){
        int hole = 1;

        // 왼쪽
        for(int i = 1; i <= N; i++){
            arr[i][0] = hole;
            hole++;
        }

        // 아래
        for(int i = 1; i <= M; i++){
            arr[N + 1][i] = hole;
            hole++;
        }

        // 오른쪽
        for(int i = N; i > 0; i--){
            arr[i][M + 1] = hole;
            hole++;
        }

        // 위
        for(int i = M; i > 0; i--){
            arr[0][i] = hole;
            hole++;
        }

        return arr;
    }

    public static int dfs(int x, int y, int dir){
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(arr[nx][ny] > 0) return arr[nx][ny];

        if(arr[nx][ny] == -1){
            return dfs(nx, ny, changeDir(dir));
        }else{
            return dfs(nx, ny, dir);
        }
    }

    public static int changeDir(int dir){
        if(dir == 0) return 1; // 왼 -> 위
        if(dir == 1) return 0; // 위 -> 왼
        if(dir == 2) return 3; // 오 -> 아
        return 2; // 아 -> 오
    }
}