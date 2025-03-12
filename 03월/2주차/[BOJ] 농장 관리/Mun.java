import java.io.*;
import java.util.*;

public class Mun {
    
    static int[][] farm;
    static boolean[][] visited;
    static int count = 0;
    static int N, M;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    N = Integer.parseInt(input[0]);
	    M = Integer.parseInt(input[1]);
	    farm = new int[N][M];
	    visited = new boolean[N][M];
	    
	    for(int i=0;i<N;i++) {
	        String[] height = br.readLine().split(" ");
	        for(int j=0;j<M;j++) {
	            farm[i][j] = Integer.parseInt(height[j]);
	        }
	    }
	    
	    int count = 0;
	    for(int i=0;i<N;i++) {
	        for(int j=0;j<M;j++) {
	            if(visited[i][j] || farm[i][j]==0) continue;
	            if(existPeak(new int[]{i, j}, farm[i][j])) {
	                count++;
	            }
	        }
	    }
	    System.out.print(count);
	}
	
	private static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, 
	{-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
	
	
	private static boolean existPeak(int[] start, int number) {
	    Queue<int[]> que = new LinkedList<>();
	    que.add(start);
	    boolean isPeak = true;
	    while(que.size()>0) {
	        int[] now = que.poll();
	        for(int[] d : direction) {
	            int nx = now[0] + d[0];
	            int ny = now[1] + d[1];
	            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
	            if (farm[nx][ny] > number) {
	                isPeak = false;
	            } else if (farm[nx][ny] == number && !visited[nx][ny]) {
	                que.add(new int[]{nx, ny});
	                visited[nx][ny] = true;
	            }
	        }
	    }
	    return isPeak;
	}
}