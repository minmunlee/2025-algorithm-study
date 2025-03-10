import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    static int R, C, wCnt, sCnt;
    static String[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1 , 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        arr = new String[R][C];
        cnt = new int[2];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String[] s = br.readLine().split("");
            for(int j = 0; j < C; j++){
                arr[i][j] = s[j];
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j]){
                    wCnt = 0;
                    sCnt = 0;
                    dfs(i, j);
                    if(wCnt >= sCnt){
                        cnt[1] += wCnt;
                    }else{
                        cnt[0] += sCnt;
                    }
                }
            }
        }
        System.out.println(cnt[0] + " " + cnt[1]);
    }
    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && !arr[nx][ny].equals("#")){
                if(arr[nx][ny].equals("v")){
                    wCnt++;
                }else if(arr[nx][ny].equals("k")){
                    sCnt++;
                }
                dfs(nx, ny);
            }
        }
    }
}
