import java.io.*;
import java.util.*;

public class Mun {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<T;i++) {
	        String[] input = br.readLine().split(" ");
	        int H = Integer.parseInt(input[0]);
	        int W = Integer.parseInt(input[1]);
	        String[][] pasture = new String[H][W];
	        for(int j=0;j<H;j++) {
	            pasture[j] = br.readLine().split("");
	        }
	        sb.append(geFlockOfSheep(pasture, H, W)).append("\n");
	    }
	    System.out.print(sb.toString());
	}
	
	private static int geFlockOfSheep(String[][] pasture, int H, int W) {
	    boolean[][] checked = new boolean[H][W];
	    int count = 0;
	    for(int i=0;i<H;i++) {
	        for(int j=0;j<W;j++) {
	            if(pasture[i][j].equals("#") && !checked[i][j]) {
	                count++;
	                checked[i][j] = true;
	                flockCheck(new int[]{i, j}, pasture, checked, H, W);
	            }
	        }
	    }
	    return count;
	}
	
	private static void flockCheck(
	    int[] start, String[][] pasture, boolean[][] checked, int H, int W
	) {
	    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	    Queue<int[]> que = new LinkedList<>();
	    que.add(start);
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        for(int[] d : dir) {
	            int nh = now[0] + d[0];
	            int nw = now[1] + d[1];
	            if(nh>=H || nh<0 || nw>=W || nw<0 || pasture[nh][nw].equals(".") || checked[nh][nw]) {
	                continue;
	            }
	            checked[nh][nw] = true;
	            que.add(new int[]{nh, nw});
	        }
	    }
	    
	}
	
}