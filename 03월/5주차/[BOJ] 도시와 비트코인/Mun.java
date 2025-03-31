import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    
	    int[][] map = new int[M][N];
	    for(int i=0;i<M;i++) {
	        String[] mapInput = br.readLine().split(" ");
	        for(int j=0;j<N;j++) {
	            map[i][j] = Integer.parseInt(mapInput[j]);
	        }
	    }
	    
	    System.out.print((isPossible(N, M, map))?"Yes":"No");
	}
	
	public static boolean isPossible(int N, int M, int[][] map) {
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[]{0, 0});

	    boolean[][] visited = new boolean[M][N];
	    visited[0][0] = true;
	    
	    int[][] dir = {{0, 1}, {1, 0}};
	    while(que.size() > 0 && !visited[M-1][N-1]) {
	        int[] now = que.poll();
	        int x = now[0];
	        int y = now[1];
	        for(int[] d : dir) {
	            int nx = x + d[0];
	            int ny = y + d[1];
	            if(nx>=M || ny>=N || visited[nx][ny] || map[nx][ny]==0) {
	                continue;
	            }
	            visited[nx][ny] = true;
	            que.add(new int[]{nx, ny});
	        }
	    }
	    
	    return visited[M-1][N-1];
	}
}