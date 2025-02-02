import java.io.*;
import java.util.*;
public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] bridge = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .toArray();
	    int s = Integer.parseInt(br.readLine());
	    System.out.print(getCount(n, s-1, bridge));
	}
	
	private static int getCount(int n, int start, int[] bridge) {
	    int count = 0;
	    Queue<Integer> que = new LinkedList<>();
	    boolean[] visited = new boolean[n];
	    que.add(start);
	    visited[start] = true;
	    while(que.size()>0) {
	        int now = que.poll();
	        count++;
	        for(int i=-1;i<2;i+=2) {
	            int next = now + bridge[now] * i;
	            if(next<0 || next>=n || visited[next]) {
	                continue;
	            }
	            que.add(next);
	            visited[next] = true;
	        }
	    }
	    return count;
	}
}