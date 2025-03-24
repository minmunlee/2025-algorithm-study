import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Min {
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[][] arr;
    static boolean[][] visited; // 탐색 했는지 방문 여부
    static int N, M, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i ++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && arr[i][j] == 0){
                    visited[i][j] = true;
                    cnt = Math.max(cnt, bfs(i, j));
                }
            }
        }
        System.out.println(cnt);
    }

    public static int bfs(int x, int y){
        boolean[][] check = new boolean[N][M]; // 탐색 시작 노드로부터 탐색 했는지 여부
        check[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int[][] distance = new int[N][M];

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int i = 0; i < 8; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!check[nx][ny] && arr[nx][ny] == 0){
                        check[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        distance[nx][ny] = distance[current[0]][current[1]] + 1;
                    }
                    if(arr[nx][ny] == 1) return distance[current[0]][current[1]] + 1;
                }
            }
        }

        return 0;
    }
}
