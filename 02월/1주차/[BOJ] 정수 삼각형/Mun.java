import java.io.*;
public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[][] triangle = new int[n][n];
	    triangle[0][0] = Integer.parseInt(br.readLine());
	    for(int i=1;i<n;i++) {
	        String[] input = br.readLine().split(" ");
	        triangle[i][0] = Integer.parseInt(input[0]) + triangle[i-1][0];
	        triangle[i][i] = Integer.parseInt(input[i]) + triangle[i-1][i-1];
	        for(int j=1;j<i;j++) {
	            triangle[i][j] = Integer.parseInt(input[j]) 
	                            + Math.max(triangle[i-1][j-1], triangle[i-1][j]);
	        }
	    }
	    int max = 0;
	    for(int last : triangle[n-1]) {
	        max = Math.max(max, last);
	    }
	    System.out.print(max);
	}
}