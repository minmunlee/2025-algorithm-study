import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    Deque<Integer> que = new ArrayDeque<>();
	    que.add(N);
	    while(N > 0) {
	        for(int i=N;i>0;i--) {
	            int last = que.removeLast();
	            que.addFirst(last);
	        }
	        N--;
	        if(N < 1) {
	            break;
	        }
	        que.addFirst(N);
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int n : que) {
	        sb.append(n).append(" ");
	    }
	    System.out.print(sb.toString());
	}
}