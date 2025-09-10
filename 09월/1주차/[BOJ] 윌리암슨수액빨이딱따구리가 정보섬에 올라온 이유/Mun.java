import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] size = br.readLine().split(" ");
	    int n = Integer.parseInt(size[0]);
	    int m = Integer.parseInt(size[1]);
	    int[][] map = new int[n][m];
	    int[] start = new int[3];
	    boolean[][] visit = new boolean[n][m];
	    for(int i=0;i<n;i++) {
	        String[] input = br.readLine().split("");
	        for(int j=0;j<m;j++) {
	            map[i][j] = Integer.parseInt(input[j]);
	            if(map[i][j] == 2) {
	                start[0] = i;
	                start[1] = j;
	                visit[i][j] = true;
	            }
	        }
	    }
	    int minCount = 0;
	    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	    Queue<int[]> que = new LinkedList<>();
	    que.add(start);
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        for(int[] d : dir) {
	            int nx = now[0] + d[0];
	            int ny = now[1] + d[1];
	            if(nx < 0 || nx >= n || ny < 0 || ny >= m || visit[nx][ny] || map[nx][ny] == 1) {
	                continue;
	            }
	            if(map[nx][ny] != 0) {
	                minCount = now[2] + 1;
	                que.clear();
	                break;
	            }
	            visit[nx][ny] = true;
	            que.add(new int[]{nx, ny, now[2] + 1});
	        }
	    }
	    String ans = (minCount > 0) ? "TAK\n"+minCount : "NIE";
	    System.out.print(ans);
	}

}