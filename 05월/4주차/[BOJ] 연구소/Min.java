import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Min {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        map = new int[N][M];
        answer = 0;

        for(int i = 0; i < N; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        setWall(0);

        System.out.println(answer);

    }

    public static void setWall(int wall){
        if(wall == 3){
            setVirus();
            return;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    setWall(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void setVirus(){
        Queue<int[]> virus = new LinkedList<>();
        int[][] infectMap = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int safe = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                infectMap[i][j] = map[i][j];
                if(map[i][j] == 2){
                    virus.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while(!virus.isEmpty()){
            int[] cur = virus.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M){
                    if(!visited[nx][ny] && infectMap[nx][ny] == 0){
                        infectMap[nx][ny] = 2;
                        virus.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(infectMap[i][j] == 0){
                    safe++;
                }
            }
        }

        answer = Math.max(safe, answer);
    }
}