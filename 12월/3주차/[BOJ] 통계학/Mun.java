import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    long[] nums = new long[N];
	    double sum = 0;
	    HashMap<Long, Integer> ncount = new HashMap<>();
	    for(int i=0;i<N;i++) {
	        nums[i] = Long.parseLong(br.readLine());
	        sum+=nums[i];
	        ncount.put(nums[i], ncount.getOrDefault(nums[i], 0) + 1);
	    }
	    int count = 0;
	    for(Long n : ncount.keySet()) {
	        int c = ncount.get(n);
	        if(c > count) {
	            count = c;
	        }
	    }
	    ArrayList<Long> list = new ArrayList<>();
	    for(Long n : ncount.keySet()) {
	        if(ncount.get(n) == count) {
	            list.add(n);
	        }
	    }
	    Collections.sort(list);
	    Arrays.sort(nums);
	    System.out.println(Math.round(sum/N));
	    System.out.println(nums[N/2]);
	    System.out.println((list.size()>1)?list.get(1):list.get(0));
	    System.out.print(nums[N-1]-nums[0]);
	}
}
