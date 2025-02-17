import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    long N = Integer.parseInt(input[0]);
	    long H = Integer.parseInt(input[1]);
	    long T = Integer.parseInt(input[2]);
	    PriorityQueue<Integer> gh = new PriorityQueue<>(Collections.reverseOrder());
	    for(int i=0;i<N;i++) {
	        gh.add(Integer.parseInt(br.readLine()));
	    }
	    int count = 0;
	    for(int i=0;i<T;i++) {
	        int max = gh.peek();
	        if(max < H || max <= 1) {
	            break;
	        }
	        count++;
	        gh.poll();
	        gh.add(max/2);
	    }
	    boolean possible = (gh.peek() < H);
	    System.out.println(possible ? "YES" : "NO");
	    System.out.println(possible ? count : gh.peek());
	}
}