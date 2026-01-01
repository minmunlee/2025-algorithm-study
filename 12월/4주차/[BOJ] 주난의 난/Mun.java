import java.io.*;
import java.util.*;

public class Mun {
    
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    String[] loc = br.readLine().split(" ");
	    int x1 = Integer.parseInt(loc[0]) - 1;
	    int y1 = Integer.parseInt(loc[1]) - 1;
	    int x2 = Integer.parseInt(loc[2]) - 1;
	    int y2 = Integer.parseInt(loc[3]) - 1;
	    char[][] map = new char[N][M];
	    int[][] distance = new int[N][M];
	    for(int i=0;i<N;i++) {
	        map[i] = br.readLine().toCharArray();
	    }
	    distance[x1][y1] = 1;
	    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[]{x1, y1, 1});
	    while(que.size() > 0 ) {
	        int[] now = que.poll();
	        for(int[] d : dir) {
	            int nx = now[0] + d[0];
	            int ny = now[1] + d[1];
	            if(nx < 0 || nx >= N || ny < 0 || ny >= M)
	                continue;
	            
	            int olddis = distance[nx][ny];
	            int newdis = now[2] + ((map[nx][ny] == '1') ? 1 : 0);
	            if(olddis == 0 || olddis > newdis) {
	                distance[nx][ny] = newdis;
	                if(map[nx][ny] == '#') {
	                    continue;
	                }
	                que.add(new int[]{nx, ny, newdis});
	            }
	        }
	    }
	    System.out.print(distance[x2][y2]);
    }
}