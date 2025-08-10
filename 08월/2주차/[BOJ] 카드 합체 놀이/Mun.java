import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int n = Integer.parseInt(input[0]);
	    int m = Integer.parseInt(input[1]);
	    String[] cards = br.readLine().split(" ");
	    PriorityQueue<Long> que = new PriorityQueue<>();
	    for(String c : cards) {
	        que.add(Long.parseLong(c));
	    }
	    for(int i=0;i<m;i++) {
	        long x = que.poll();
	        long y = que.poll();
	        long mix = x + y;
	        que.add(mix);
	        que.add(mix);
	    }
	    long min = 0;
	    while(que.size() > 0) {
	        min += que.poll();
	    }
	    System.out.print(min);
	}
}