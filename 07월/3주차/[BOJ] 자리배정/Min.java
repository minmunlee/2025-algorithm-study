import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(str.nextToken());
        int R = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(br.readLine());
        int[][] concert = new int[R][C];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int dir = 0;
        int num = 1;
        concert[x][y] = num;

        if(K == 1){
            System.out.println((y + 1) + " " + (x + 1));
            return;
        }

        while(num < C * R) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx >= 0 && nx < R && ny >= 0 && ny < C && concert[nx][ny] == 0) {
                num += 1;
                concert[nx][ny] = num;
                if(num == K){
                    System.out.println((ny + 1) + " " + (nx + 1));
                    return;
                }
                x = nx;
                y = ny;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        System.out.println(0);
    }    
}
