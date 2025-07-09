import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    PriorityQueue<Long> que = new PriorityQueue<>();
	    for(int i=0;i<N;i++) {
	        que.add(Long.parseLong(br.readLine()));
	    }
	    long sum = 0;
	    while(que.size()>1) {
	        long A = que.poll();
	        long B = que.poll();
	        long count = A + B;
	        que.add(A+B);
	        sum+=count;
	    }
	    System.out.print(sum);
	}
}