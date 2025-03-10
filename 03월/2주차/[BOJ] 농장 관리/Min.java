import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    static int[][] arr;
    static int[] dx = {1, -1 , 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static boolean[][] visited;
    static boolean isTop;
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        int cnt = 0;

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && arr[i][j] != 0){
                    isTop = true;
                    dfs(i, j);
                    if(isTop) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 8; i++){
            int changeX = x + dx[i];
            int changeY = y + dy[i];
            if(changeX >= 0 && changeX < N && changeY >= 0 && changeY < M  && arr[changeX][changeY] != 0){
                if(arr[changeX][changeY] > arr[x][y]){
                    isTop = false;
                }
                if(!visited[changeX][changeY] && arr[changeX][changeY] == arr[x][y]){
                    dfs(changeX, changeY);
                }
            }
        }
    }
}
