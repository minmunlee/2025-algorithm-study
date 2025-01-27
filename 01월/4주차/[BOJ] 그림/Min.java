import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Min {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m, pictureSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken()); // 세로 크기
        m = Integer.parseInt(str.nextToken()); // 가로 크기
        pictureSize = 0;
        arr = new int[n][m];
        visited = new boolean[n][m];
        ArrayList<Integer> list = new ArrayList<>();
        boolean isAllZero = true;

        for(int i = 0; i < n; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    isAllZero = false;
                    dfs(i, j);
                    list.add(pictureSize);
                    pictureSize = 0;
                }
            }
        }
        if(isAllZero){
            System.out.println(0);
            System.out.println(0);
        }else{
            Collections.sort(list, Collections.reverseOrder());
            System.out.println(list.size()); // 그림의 개수
            System.out.println(list.get(0)); // 가장 넓은 그림
        }
    }

    public static void dfs(int a, int b){
        visited[a][b] = true;
        pictureSize++;
        for(int i = 0; i < 4; i++){
            int x = a + dx[i];
            int y = b + dy[i];
            if(x >= 0 && x < n && y >= 0 && y < m){
                if(arr[x][y] == 1 && !visited[x][y]){
                    dfs(x, y);
                }
            }
        }
        
    }
}