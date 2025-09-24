import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int X = Integer.parseInt(input[0]);
	    int Y = Integer.parseInt(input[1]);
	    int Z = (int) ((long) Y * 100 / X);
	    int start = 0;
	    int end = 1000000000;
	    int ans = -1;
	    while(start <= end) {
	        int mid = (start + end) / 2;
	        int newZ = (int) ((long) (Y + mid) * 100 / (X + mid));
	        if(Z < newZ) {
	            end = mid - 1;
	            ans = mid;
	        } else {
	            start = mid + 1;
	        }
	    }
	    System.out.print(ans);
	}
}