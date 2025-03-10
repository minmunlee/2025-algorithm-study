import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int n = Integer.parseInt(input[0]);
	    int k = Integer.parseInt(input[1]);
	    int[] nums = new int[n];
	    for(int i=0;i<n;i++) {
	        nums[i] = Integer.parseInt(br.readLine());
	    }
	    int[] dp = new int[k+1];
	    dp[0] = 1;
	    for(int i=0;i<n;i++) {
	        int num = nums[i];
	        for(int j=num;j<=k;j++) {
	            dp[j] += dp[j-num];
	        }
	    }
	    System.out.print(dp[k]);
	}
}