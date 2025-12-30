import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        String[][] arr = new String[N][M];
        str = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(str.nextToken()) - 1;
        int y1 = Integer.parseInt(str.nextToken()) - 1;
        int x2 = Integer.parseInt(str.nextToken()) - 1;
        int y2 = Integer.parseInt(str.nextToken()) - 1;

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().split("");
        }

        boolean[][] visited = new boolean[N][M];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.offer(new int[]{x1, y1, 0});
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int x = tmp[0];
            int y = tmp[1];
            int cnt = tmp[2];
            
            if(visited[x][y]) continue;
            visited[x][y] = true;
            
            if(x == x2 && y == y2) {
                System.out.println(cnt);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!isValid(nx, ny, N, M) || visited[nx][ny]) continue;

                if(nx == x2 && ny == y2) {
                    System.out.println(cnt + 1);
                    return;
                }

                if (arr[nx][ny].equals("1")) {
                    pq.offer(new int[]{nx, ny, cnt + 1});
                } else { 
                    pq.offer(new int[]{nx, ny, cnt});
                }
                
            }
        }
    }
    
    private static boolean isValid(int x, int y, int N, int M) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
