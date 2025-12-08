import java.io.*;
import java.util.*;

public class Mun {
    static int R, C, max = 0;
    static char[][] board;
    static boolean[][] checked;
    static HashSet<Character> set = new HashSet<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    board = new char[R][C];
	    checked = new boolean[R][C];
	    for(int i=0;i<R;i++) {
	        board[i] = br.readLine().toCharArray();
	    }
	    checked[0][0] = true;
	    set.add(board[0][0]);
	    findMax(0, 0, 1);
	    System.out.print(max);
	}
	
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	private static void findMax(int x, int y, int count) {
	    if(max < count) {
	        max = count;
	    }
	    for(int i=0;i<4;i++) {
	        int nx = x + dir[i][0];
	        int ny = y + dir[i][1];
	        if(nx<0 || nx>=R || ny<0 || ny>=C || checked[nx][ny]) {
	            continue;
	        }
	        char alpa = board[nx][ny];
	        if(set.contains(alpa)) {
	            continue;
	        }
	        checked[nx][ny] = true;
	        set.add(alpa);
	        findMax(nx, ny, count + 1);
	        checked[nx][ny] = false;
	        set.remove(alpa);
	    }
	}

}