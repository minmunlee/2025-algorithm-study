import java.io.*;

public class Mun {
    static int N, M;
    static int[][] rect;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    N = Integer.parseInt(input[0]);
	    M = Integer.parseInt(input[1]);
	    rect = new int[N][M];
	    for(int i=0;i<N;i++) {
	        String[] lineInput = br.readLine().split("");
	        for(int j=0;j<M;j++) {
	            rect[i][j] = Integer.parseInt(lineInput[j]);
	        }
	    }
	    int maxSize = 1;
	    for(int i=0;i<N-1;i++) {
	        for(int j=0;j<M-1;j++) {
	            maxSize = Math.max(maxSize, getSize(i, j, rect[i][j]));
	        }
	    }
	    System.out.print(maxSize);
	}
	
	private static int getSize(int x, int y, int num) {
	    int max = 1;
	    for(int i=y+1;i<M;i++) {
	        int diff = i - y;
	        if(x + diff >= N) {
	            break;
	        }
	        if(rect[x][i]==num && rect[x+diff][y]==num && rect[x+diff][i]==num) {
	            max = Math.max(max, diff+1);
	        }
	    }
	    return max * max;
	}
}