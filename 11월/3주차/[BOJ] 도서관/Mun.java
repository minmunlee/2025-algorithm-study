import java.io.*;
import java.util.*;

public class Mun {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int[] location = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .sorted()
	                            .toArray();
	    boolean find = false;
	    int mid = N;
	    for(int i=0;i<N;i++) {
	        if(!find && location[i] > 0) {
	            find = true;
	            mid = i;
	        }
	    }
	    ArrayList<Integer> cut = new ArrayList<>();
	    for(int i=0;i<mid;i+=M) {
	        cut.add(Math.abs(location[i]));
	    }
	    for(int i=N-1;i>=mid;i-=M) {
	        cut.add(location[i]);
	    }
	    Collections.sort(cut, Collections.reverseOrder());
	    long sum = 0;
	    sum+=cut.get(0);
	    for(int i=1;i<cut.size();i++) {
	        sum+=(cut.get(i)*2);
	    }
	    System.out.print(sum);
	}
	
}