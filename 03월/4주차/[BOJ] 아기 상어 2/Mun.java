import java.io.*;
import java.util.*;

public class Mun {
    static Queue<int[]> que = new LinkedList<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    int[][] space = new int[N][M];
	    for(int i=0;i<N;i++) {
	        String[] Minput = br.readLine().split(" ");
	        for(int j=0;j<M;j++) {
	            space[i][j] = Integer.parseInt(Minput[j]);
	            if(space[i][j]==1) {
	                que.add(new int[]{i, j});
	            }
	        }
	    }
	    System.out.print(findMaxSafeDistance(N, M, space));
	}
	
	public static int findMaxSafeDistance(int N, int M, int[][] space) {
	    int[] nd = {0, 0, 1, -1, 1, 1, -1, -1};
	    int[] md = {1, -1, 0, 0, 1, -1, -1, 1};
	    int max = 0;
	    int[][] visited = new int[N][M];
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        int n = now[0];
	        int m = now[1];
	        int dis = visited[n][m];
	        if(max < dis) {
	            max = dis;
	        }
	        for(int i=0;i<8;i++) {
	            int nn = n + nd[i];
	            int nm = m + md[i];
	            if(nn<0 || nn>=N || nm<0 || nm>=M || visited[nn][nm]>0 || space[nn][nm]==1) {
	                continue;
	            }
	            que.add(new int[]{nn, nm});
	            visited[nn][nm] = dis + 1;
	        }
	    }
	    return max;
	}
}