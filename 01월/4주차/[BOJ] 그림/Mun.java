import java.io.*;
import java.util.*;

public class Mun {
    static boolean[][] visited;
    static int[][] paper;
    static int n;
    static int m;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    n = Integer.parseInt(input[0]);
	    m = Integer.parseInt(input[1]);
	    visited = new boolean[n][m];
	    paper = new int[n][m];
	    for(int i=0;i<n;i++) {
	        String[] painting = br.readLine().split(" ");
	        for(int j=0;j<m;j++) {
	            paper[i][j] = Integer.parseInt(painting[j]);
	        }
	    }
	    int count = 0;
	    int maxSize = 0;
	    for(int x=0;x<n;x++) {
	        for(int y=0;y<m;y++) {
	            if(paper[x][y] != 1 || visited[x][y]) {
	                continue;
	            }
	            visited[x][y] = true;
	            count++;
	            maxSize = Math.max(maxSize, getSize(x, y));
	        }
	    }
	    System.out.print(count + "\n" + maxSize);
	}
	
	private static int getSize(int x, int y) {
	    int[][] Direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[]{x, y});
	    int size = 0;
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        size++;
	        int nowx = now[0];
	        int nowy = now[1];
	        for(int[] dir : Direction) {
	            int nextx = nowx + dir[0];
	            int nexty = nowy + dir[1];
	            if(nextx<0 || nextx>=n || nexty<0 || nexty>=m) {
	                continue;
	            }
	            if(!visited[nextx][nexty] && paper[nextx][nexty] == 1) {
	                que.add(new int[]{nextx, nexty});
	                visited[nextx][nexty] = true;
	            }
	        }
	    }
	    return size;
	}
}