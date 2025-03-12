import java.io.*;
import java.util.*;

public class Mun {
    static int totalSheep = 0, totalWolf = 0;
    static int R, C;
    static String[][] space;
    static boolean[][] visited;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    R = Integer.parseInt(input[0]);
	    C = Integer.parseInt(input[1]);
	    space = new String[R][C];
	    visited = new boolean[R][C];
	    for(int i=0;i<R;i++) {
	        space[i] = br.readLine().split("");
	    }
	    for(int i=0;i<R;i++) {
	        for(int j=0;j<C;j++) {
	            if(visited[i][j] || space[i][j].equals("#")) continue;
	            visited[i][j] = true;
	            count(new int[]{i, j});
	        }
	    }
	    System.out.print(totalSheep+" "+totalWolf);
	}
	static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private static void count(int[] start) {
	    Queue<int[]> que = new LinkedList<>();
	    que.add(start);
	    int sheep = 0, wolf = 0;
	    while(que.size()>0) {
	        int[] now = que.poll();
	        String in = space[now[0]][now[1]];
	        if(in.equals("v")) wolf++;
	        else if(in.equals("k")) sheep++;
	        
	        for(int[] d : direction) {
	            int nextR = now[0] + d[0];
	            int nextC = now[1] + d[1];
	            if(nextR<0 || nextR>=R || nextC<0 || nextC>=C || 
	                visited[nextR][nextC] || space[nextR][nextC].equals("#")) {
	                continue;
	            }
	            visited[nextR][nextC] = true;
	            que.add(new int[]{nextR, nextC});
	        }
	    }
	    if(sheep > wolf) totalSheep+=sheep;
	    else totalWolf+=wolf;
	}
}