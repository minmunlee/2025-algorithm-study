import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    PriorityQueue<Long> que = new PriorityQueue<>((o1, o2)->{
	        Long abs1 = Math.abs(o1);
	        Long abs2 = Math.abs(o2);
	        return (abs1.equals(abs2)) ? o1.compareTo(o2) : abs1.compareTo(abs2);
	    });
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<N;i++) {
	        long input = Long.parseLong(br.readLine());
	        if(input==0) {
	            sb.append((que.isEmpty()) ? 0 :que.poll()).append("\n");
	        } else {
	            que.add(input);
	        }
	    }
	    System.out.print(sb.toString());
	}
}