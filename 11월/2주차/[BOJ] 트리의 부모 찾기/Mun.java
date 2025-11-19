import java.io.*;
import java.util.*;

public class Mun {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    ArrayList<Integer>[] list = new ArrayList[N+1];
	    for(int i=1;i<=N;i++) {
	        list[i] = new ArrayList<>();
	    }
	    for(int i=1;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        int a = Integer.parseInt(input[0]);
	        int b = Integer.parseInt(input[1]);
	        list[a].add(b);
	        list[b].add(a);
	    }
	    int[] parents = new int[N+1];
	    boolean[] checked = new boolean[N+1];
	    checked[1] = true;
	    Queue<Integer> que = new LinkedList<>();
	    que.add(1);
	    while(que.size() > 0) {
	        int now = que.poll();
	        for(int c : list[now]) {
	            if(checked[c]) {
	                continue;
	            }
	            parents[c] = now;
	            checked[c] = true;
	            que.add(c);
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int i=2;i<=N;i++) {
	        sb.append(parents[i]).append("\n");
	    }
	    System.out.print(sb.toString());
	}

}