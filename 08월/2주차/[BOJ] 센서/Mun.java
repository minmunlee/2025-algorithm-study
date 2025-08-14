import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int K = Integer.parseInt(br.readLine());
	    int[] sensors = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .sorted()
	                            .toArray();
	    int[] interval = new int[N-1];
	    for(int i=0;i<N-1;i++) {
	        interval[i] = sensors[i+1] - sensors[i];
	    }
	    Arrays.sort(interval);
	    int sum = 0;
	    for(int i=0;i<N-K;i++) {
	        sum+=interval[i];
	    }
	    System.out.print(sum);
	}
}