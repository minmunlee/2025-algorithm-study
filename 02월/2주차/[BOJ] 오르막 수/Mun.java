import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[][] count = new int[N+1][10];
	    for(int i=0;i<10;i++) {
	        count[0][i] = 1;
	    }
	    for(int i=1;i<=N;i++) {
	        for(int j=0;j<10;j++) {
	            for(int k=j;k<10;k++) {
	                count[i][j] += count[i-1][k];
	                count[i][j] %= 10007;
	            }
	        }
	    }
	    System.out.print(count[N][0]);
	}
}