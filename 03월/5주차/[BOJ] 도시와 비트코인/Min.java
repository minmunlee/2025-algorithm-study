import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int[][] arr = new int[M][N];

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        queue.offer(new int[]{0 ,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int nx = x + 1; // 남쪽 이동
            int ny = y + 1; // 동쪽 이동

            if((nx == M - 1 && y == N - 1) || (x == M - 1 && y == N - 1)){
                System.out.println("Yes");
                return;
            }

            if(nx >= 0 && nx < M){
                if(!visited[nx][y] && arr[nx][y] == 1){
                    visited[nx][y] = true;
                    queue.offer(new int[]{nx, y});
                }
            }

            if(ny >= 0 && ny < N){
                if(!visited[x][ny] && arr[x][ny] == 1){
                    visited[x][ny] = true;
                    queue.offer(new int[]{x, ny});
                }
            }
        }
        System.out.println("No");
    }
}
