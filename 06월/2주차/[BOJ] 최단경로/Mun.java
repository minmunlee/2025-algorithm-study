import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int V = Integer.parseInt(input[0]);
	    int E = Integer.parseInt(input[1]);
	    int K = Integer.parseInt(br.readLine());
	    ArrayList<int[]>[] list = new ArrayList[V+1];
	    for(int i=1;i<=V;i++) {
	        list[i] = new ArrayList<>();
	    }
	    for(int i=0;i<E;i++) {
	        String[] in = br.readLine().split(" ");
	        int u = Integer.parseInt(in[0]);
	        int v = Integer.parseInt(in[1]);
	        int w = Integer.parseInt(in[2]);
	        list[u].add(new int[]{v, w});
	    }
	    int[] dis = new int[V+1];
	    boolean[] visit = new boolean[V+1];
	    PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
	        return o1[1] - o2[1];
	    });
	    que.add(new int[]{K, 0});
	    visit[K] = true;
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        int nv = now[0];
	        int nd = now[1];
	        for(int[] next : list[nv]) {
	            int nxtv = next[0];
	            int nxtd = nd + next[1];
	            if(visit[nxtv] && dis[nxtv] <= nxtd) {
	                continue;
	            }
	            visit[nxtv] = true;
	            dis[nxtv] = nxtd;
	            que.add(new int[]{nxtv, nxtd});
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int i=1;i<=V;i++) {
	        if(visit[i]) {
	            sb.append(dis[i]);
	        } else {
	            sb.append("INF");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb.toString());
	}
}