import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    int K = Integer.parseInt(input[2]);
	    int X = Integer.parseInt(input[3]);
	    ArrayList<Integer>[] arr = new ArrayList[N+1];
	    for(int i=1;i<=N;i++) {
	        arr[i] = new ArrayList<>();
	    }
	    for(int i=0;i<M;i++) {
	        String[] road = br.readLine().split(" ");
	        int a = Integer.parseInt(road[0]);
	        int b = Integer.parseInt(road[1]);
	        arr[a].add(b);
	    }
	    HashSet<Integer> visit = new HashSet<>();
	    visit.add(X);
	    Queue<int[]> que = new LinkedList<>();
	    que.add(new int[]{X, 0});
	    TreeSet<Integer> kct = new TreeSet<>();
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        int nct = now[0];
	        int dis = now[1];
	        if(dis > K) {
	            break;
	        } else if(dis == K) {
	            kct.add(nct);
	        }
	        for(int n : arr[nct]) {
	            if(visit.contains(n)) {
	                continue;
	            }
	            visit.add(n);
	            que.add(new int[]{n, dis+1});
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    if(kct.size() > 0) {
	        for(int n : kct) {
	            sb.append(n).append("\n");
	        }
	    } else {
	        sb.append("-1");
	    }
	    
	    System.out.print(sb.toString());
	}
	
}