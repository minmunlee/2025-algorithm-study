import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Min {
    static int[][] arr;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        n = Integer.parseInt(str.nextToken());
        m = Integer.parseInt(str.nextToken());
        arr = new int[n][m];
        int[] start = new int[2];
        for(int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
                if(arr[i][j] == 2){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int answer = bfs(start);

        if(answer == 0) {
            System.out.println("NIE");
        }else {
            System.out.println("TAK");
            System.out.println(bfs(start));
        }
        
    }
    
    public static int bfs(int[] start) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int[][] dis = new int[n][m];

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && arr[nx][ny] != 1) {
                        if(arr[nx][ny] == 0){
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                            dis[nx][ny] = dis[tmp[0]][tmp[1]] + 1;
                        } else {
                            return dis[tmp[0]][tmp[1]] + 1;
                        }
                    }
                }
            }
        }

        return 0;
    }
}
