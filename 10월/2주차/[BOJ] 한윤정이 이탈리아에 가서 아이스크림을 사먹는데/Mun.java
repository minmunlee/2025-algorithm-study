import java.io.*;

public class Mun {
    static boolean[][] avoid;
    static int count = 0;
    static int N;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] info = br.readLine().split(" ");
	    N = Integer.parseInt(info[0]);
	    int M = Integer.parseInt(info[1]);
	    avoid = new boolean[N+1][N+1];
	    for(int i=0;i<M;i++) {
	        String[] iceInfo = br.readLine().split(" ");
	        int a = Integer.parseInt(iceInfo[0]);
	        int b = Integer.parseInt(iceInfo[1]);
	        avoid[a][b] = true;
	        avoid[b][a] = true;
	    }
	    dfs(1, 0, new int[3]);
	    System.out.print(count);
	}
	
	private static void dfs(int start, int index, int[] check) {
	    if(index == 3) {
	        count++;
	        return;
	    }
	    for(int i=start;i<=N;i++) {
	        boolean pos = true;
	        for(int j=0;j<=index;j++) {
	            if(avoid[check[j]][i]) {
	                pos = false;
	                break;
	            }
	        }
	        if(pos) {
	            check[index] = i;
	            dfs(i + 1, index + 1, check);
	            check[index] = 0;
	        }
	    }
	}
}