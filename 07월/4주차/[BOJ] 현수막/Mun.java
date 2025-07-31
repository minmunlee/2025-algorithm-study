import java.io.*;
import java.util.*;

public class Mun {
    static int M, N;
    static int[][] Banner;
    static boolean[][] visit;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    M = Integer.parseInt(input[0]);
	    N = Integer.parseInt(input[1]);
	    Banner = new int[M][N];
	    visit = new boolean[M][N];
	    for(int i=0;i<M;i++) {
	        Banner[i] = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .toArray();
	    }
	    int letterCount = 0;
	    for(int i=0;i<M;i++) {
	        for(int j=0;j<N;j++) {
	            if(visit[i][j] || Banner[i][j] == 0) {
	                continue;
	            }
	            letterCount++;
	            visit[i][j] = true;
	            checkLetters(new int[]{i, j});
	        }
	    }
	    System.out.print(letterCount);
	}
	static int[][] dir = {
	    {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
	};
	
	private static void checkLetters(int[] start) {
	    Queue<int[]> que = new LinkedList<>();
	    que.add(start);
	    while(que.size() > 0){
	        int[] now = que.poll();
	        int x = now[0];
	        int y = now[1];
	        for(int[] d : dir) {
	            int nx = x + d[0];
	            int ny = y + d[1];
	            if(nx<0 || nx>=M || ny<0 || ny>=N || visit[nx][ny] || Banner[nx][ny]==0) {
	                continue;
	            }
	            visit[nx][ny] = true;
	            que.add(new int[]{nx, ny});
	        }
	    }
	}
}