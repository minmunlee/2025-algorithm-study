import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    while(T > 0) {
	        int N = Integer.parseInt(br.readLine());
	        HashMap<Integer, Integer> map = new HashMap<>();
	        for(int i=1;i<=N;i++) {
	            map.put(i, Integer.parseInt(br.readLine()));
	        }
	        sb.append(findK(N, N, map)).append("\n");
	        T--;
	    }
	    System.out.print(sb.toString());
	}
	private static int findK(int max, int target, HashMap<Integer, Integer> map) {
	    int now = 1;
	    for(int count=1;count<=max;count++){
	        now = map.get(now);
	        if(now==target) return count;
	    }
	    return 0;
	}
}