import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Min {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++){
            StringTokenizer str  = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(str.nextToken());
            int W = Integer.parseInt(str.nextToken());
            String[][] arr = new String[H][W];
            visited = new boolean[H][W];
            for(int j = 0; j < H; j++){
                arr[j] = br.readLine().split("");
            }

            int cnt = 0;
            for(int j = 0; j < H; j++){
                for(int k = 0; k < W; k++){
                    if(!visited[j][k] && arr[j][k].equals("#")){
                        cnt++;
                        cnt += getHerd(arr, j, k);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static int getHerd(String[][] arr, int x, int y){
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int cnt = 0;
        while(!queue.isEmpty()){
            int[] tmp  = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length){
                    if(!visited[nx][ny] && arr[nx][ny].equals("#")){
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return cnt;
        
    }
}