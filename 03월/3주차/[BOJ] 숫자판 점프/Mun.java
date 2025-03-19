import java.io.*;
import java.util.*;

public class Mun {
    static HashSet<Integer> set = new HashSet<>();
    static int[][] plate = new int[5][5];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    for(int i=0;i<5;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=0;j<5;j++) {
	            plate[i][j] = Integer.parseInt(input[j]);
	        }
	    }
	    for(int i=0;i<5;i++) {
	        for(int j=0;j<5;j++) {
	            dfs(i, j, plate[i][j], 1);
	        }
	    }
	    System.out.print(set.size());
	}
	
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	private static void dfs(int x, int y, int num, int deep) {
	    if(deep==6) {
	        set.add(num);
	        return;
	    }
	    for(int[] d : dir) {
	        int nextX = x + d[0];
	        int nextY = y + d[1];
	        if(nextX<0 || nextX>=5 || nextY<0 || nextY>=5) {
	            continue;
	        }
	        dfs(nextX, nextY, num*10 + plate[nextX][nextY], deep+1);
	    }
	}
}