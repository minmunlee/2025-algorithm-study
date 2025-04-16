import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Min {
    static int[] dx = {1, 0, -1, 0}; // 아래 오른쪽 위 왼쪽
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int N, target;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        setArr();
        
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == target){
                    x = i + 1;
                    y = j + 1;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(x + " " + y);

        System.out.println(sb);
    }

    public static void setArr(){
        int x = 0;
        int y = 0;
        int dir = 0;
        arr[x][y] = N * N;

        while(true){
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 0){
                arr[nx][ny] = arr[x][y] - 1;
                if(arr[nx][ny] == 1) break;
                x = nx;
                y = ny;
            }else{
                dir = (dir + 1) % 4;
            }
        }
    }
}
