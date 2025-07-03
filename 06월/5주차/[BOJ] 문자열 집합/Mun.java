import java.io.*;
import java.util.*;


public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] nums = br.readLine().split(" ");
	    int N = Integer.parseInt(nums[0]);
	    int M = Integer.parseInt(nums[1]);
	    
	    HashMap<String, Integer> SCount = new HashMap<>();
	    for(int i=0;i<N;i++) {
	        SCount.put(br.readLine(), 0);
	    }
	    
	    for(int i=0;i<M;i++) {
	        String input = br.readLine();
	        if(SCount.containsKey(input)) {
	            SCount.replace(input, SCount.get(input) + 1);
	        }
	    }
	    
	    int count = 0;
	    Collection<Integer> values = SCount.values();
	    for(int v : values) {
	        count+=v;
	    }
	    System.out.print(count);
	}
}