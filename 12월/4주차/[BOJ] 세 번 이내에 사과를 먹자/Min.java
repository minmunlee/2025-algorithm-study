import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Min {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        StringTokenizer str;
        for(int i = 0; i < 5; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        str = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());
        visited = new boolean[5][5];
        int apple = arr[a][b] == 1 ? 1 : 0;
        answer = 0;
        visited[a][b] = true;
        dfs(a, b, 0, apple);
        System.out.println(answer);
    }

    private static void dfs(int col, int row, int move, int apple) {
        if(apple >= 2) {
            answer = 1;
            return;
        }
        if(move == 3) return;

        
        for(int i = 0; i < 4; i++) {
            int nx = col + dx[i];
            int ny = row + dy[i];
            
            if(isValid(nx, ny) && !visited[nx][ny]) {
                visited[col][row] = true;
                if(arr[nx][ny] == 1) {
                    dfs(nx, ny, move + 1, apple + 1);
                }else if(arr[nx][ny] == 0){
                    dfs(nx, ny, move + 1, apple);
                }
                visited[nx][ny] = false;
            }
        }
    }
    
    private static boolean isValid(int x, int y) {
        if(x >= 0 && x < 5 && y >= 0 && y < 5 && arr[x][y] != -1) {
            return true;
        }
        return false;
    }
}