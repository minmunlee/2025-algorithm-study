import java.io.*;
import java.util.*;

public class Mun {
    static int N;
    static int[] mark;
    static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    mark = Arrays.stream(br.readLine().split(" "))
	                    .mapToInt(Integer::parseInt)
	                    .toArray();
	    for(int x : mark) {
	        set.add(x);
	    }
	    TreeSet<Integer> K = new TreeSet<>();
	    for(int i=1;i<=N/2;i++) {
	        int interval = mark[i] - mark[0];
	        if(isK(interval)) {
	            K.add(interval);
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    sb.append(K.size()).append("\n");
	    for(int k : K) {
	        sb.append(k).append(" ");
	    }
	    System.out.print(sb.toString());
	}
	
	private static boolean isK(int interval) {
        for (int x : mark) {
            if(set.contains(x+interval) || set.contains(x-interval)) {
                continue;
            }
            return false;
        }
        return true;
    }
}