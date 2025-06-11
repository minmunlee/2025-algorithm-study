import java.io.*;
import java.util.*;

public class Mun {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    HashSet<Integer>[] link = new HashSet[N+1];
	    for(int i=1;i<=N;i++) {
	        link[i] = new HashSet<>();
	    }
	    for(int i=0;i<M;i++) {
	        st = new StringTokenizer(br.readLine(), " ");
	        int A = Integer.parseInt(st.nextToken());
	        int B = Integer.parseInt(st.nextToken());
	        link[B].add(A);
	    }
	    int[] counts = new int[N+1];
	    int maxCount = 0;
	    for(int i=1;i<=N;i++) {
	        counts[i] = getCount(link, i);
	        if(counts[i] > maxCount) {
	            maxCount = counts[i];
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int i=1;i<=N;i++) {
	        if(counts[i] == maxCount) {
	            sb.append(i).append(" ");
	        }
	    }
	    System.out.print(sb.toString());
	}
	
	private static int getCount( HashSet<Integer>[] link, int start) {
	    Queue<Integer> que = new LinkedList<>();
	    que.add(start);
	    HashSet<Integer> visit = new HashSet<>();
	    visit.add(start);
	    int count = 1;
	    while(que.size() > 0) {
	        int com = que.poll();
	        for(int nc : link[com]) {
	            if(visit.contains(nc)) {
	                continue;
	            }
	            visit.add(nc);
	            que.add(nc);
	            count++;
	        }
	    }
	    return count;
	}
}