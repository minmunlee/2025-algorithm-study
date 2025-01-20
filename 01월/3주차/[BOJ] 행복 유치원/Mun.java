import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int K = Integer.parseInt(input[1]);
	    int[] height = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt).toArray();
	    ArrayList<Integer> diff = new ArrayList<>();
	    for(int i=1;i<N;i++) {
	        diff.add(height[i] - height[i-1]);
	    }
	    Collections.sort(diff);
	    long sum = 0;
	    for(int i=0;i<N-K;i++) {
	        sum+=diff.get(i);
	    }
	    System.out.print(sum);
	}
}