import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
	    for(int i=0;i<N;i++) {
	        String[] inputs = br.readLine().split(" ");
	        for(String input : inputs) {
	            que.add(Integer.parseInt(input));
	        }
	    }
	    for(int i=1;i<N;i++) {
	        que.poll();
	    }
	    System.out.print(que.poll());
	}
}