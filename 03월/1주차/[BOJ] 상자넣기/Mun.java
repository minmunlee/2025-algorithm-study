import java.io.*;

public class Mun{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] nums = new int[n];
	    String[] input = br.readLine().split(" ");
	    for(int i=0;i<n;i++) {
	        nums[i] = Integer.parseInt(input[i]);
	    }
	    int[] maxs = new int[n];
	    maxs[0] = 1;
	    int max = 0;
	    for(int i=1;i<n;i++) {
	        maxs[i] = 1;
	        for(int j=0;j<i;j++) {
	            if(nums[j] < nums[i]) {
	                maxs[i] = Math.max(maxs[i], maxs[j] + 1);
	            }
	        }
	        max = Math.max(max, maxs[i]);
	    }
	    System.out.print(max);
	}
}