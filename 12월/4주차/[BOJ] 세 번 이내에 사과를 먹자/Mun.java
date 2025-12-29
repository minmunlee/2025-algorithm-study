import java.io.*;

public class Mun {
    static boolean[][] checked = new boolean[5][5];
    static int[][] board = new int[5][5];
    static boolean eatApple = false;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    for(int i=0;i<5;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=0;j<5;j++) {
	            board[i][j] = Integer.parseInt(input[j]);
	        }
	    }
	    String[] loc = br.readLine().split(" ");
	    int r = Integer.parseInt(loc[0]);
	    int c = Integer.parseInt(loc[1]);
	    checked[r][c] = true;
	    findRoot(r, c, 0, 0);
	    System.out.print((eatApple) ? 1 : 0);
	    
	}
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	private static void findRoot(int r, int c, int move, int appleCount) {
	    if(eatApple) {
	        return;
	    }
	    if(board[r][c] == 1) {
	        appleCount++;
	    }
	    if(move == 3) {
	        eatApple = appleCount >= 2;
	        return;
	    }
	    for(int[] d : dir) {
	        int nr = r + d[0];
	        int nc = c + d[1];
	        if(outOfRange(nr, nc) || checked[nr][nc] || board[nr][nc] == -1) {
	            continue;
	        }
	        checked[nr][nc] = true;
	        findRoot(nr, nc, move + 1, appleCount);
	        checked[nr][nc] = false;
	    }
	    
	}
	
	private static boolean outOfRange(int nr, int nc) {
	    return (nr >= 5 || nr < 0 || nc >= 5 || nc < 0);
	}
}