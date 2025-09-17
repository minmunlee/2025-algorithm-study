import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    Queue<Integer> que = new LinkedList<>();
	    for(int i=1;i<=N;i++) {
	        que.add(i);
	    }
	    StringBuilder sb = new StringBuilder("");
	    while(que.size() > 1){
	        sb.append(que.poll()).append(" ");
	        int num = que.poll();
	        que.add(num);
	    }
	    sb.append(que.poll());
	    System.out.print(sb.toString());
	}
}