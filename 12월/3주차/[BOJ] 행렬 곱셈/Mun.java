import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] Asize = br.readLine().split(" ");
	    int N = Integer.parseInt(Asize[0]);
	    int M = Integer.parseInt(Asize[1]);
	    int[][] A = new int[N][M];
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=0;j<M;j++) {
	            A[i][j] = Integer.parseInt(input[j]);
	        }
	    }
	    int K = Integer.parseInt(br.readLine().split(" ")[1]);
	    int[][] B = new int[M][K];
	    for(int i=0;i<M;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=0;j<K;j++) {
	            B[i][j] = Integer.parseInt(input[j]);
	        }
	    }
	    int[][] ans = new int[N][K];
	    for(int i=0;i<N;i++) {
	        for(int j=0;j<K;j++) {
	            int sum = 0;
	            for(int p=0;p<M;p++) {
	                sum+=(A[i][p]*B[p][j]);
	            }
	            ans[i][j] = sum;
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int[] a : ans) {
	        for(int n : a) {
	            sb.append(n).append(" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb.toString());
	}
}
