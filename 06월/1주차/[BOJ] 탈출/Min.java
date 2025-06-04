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
    static String[][] map;
    static Queue<int[]> go;
    static Queue<int[]> water;
    static int R, C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        map = new String[R][C];
        go = new LinkedList<>();
        water = new LinkedList<>();
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String[] tmp = br.readLine().split("");
            for(int j = 0; j < tmp.length; j++){
                map[i][j] = tmp[j];
                if(tmp[j].equals("S")){
                    go.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
                if(tmp[j].equals("*")){
                    water.offer(new int[]{i, j});
                }
            }
        }

        int time = bfs();
        if(time == -1){
            System.out.println("KAKTUS");
        }else{
            System.out.println(time);
        }
    }

    public static int bfs(){
        int time = 0;
        while(!go.isEmpty()){
            time++;
            int size = water.size();
            for(int i = 0; i < size; i++){
                int[] tmp = water.poll();
                for(int j = 0; j < 4; j++){
                    int nx = tmp[0] + dx[j];
                    int ny = tmp[1] + dy[j];
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                        if(map[nx][ny].equals(".")){
                            map[nx][ny] = "*";
                            water.offer(new int[]{nx, ny});
                        }
                    }
                }
            }

            size = go.size();
            for(int i = 0; i < size; i++){
                int[] tmp = go.poll();
                for(int j = 0; j < 4; j++){
                    int nx = tmp[0] + dx[j];
                    int ny = tmp[1] + dy[j];
    
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                        if(!map[nx][ny].equals("X") && !map[nx][ny].equals("*") && !visited[nx][ny]){
                            if(map[nx][ny].equals("D")) return time;
                            visited[nx][ny] = true;
                            go.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
        
    }
}
