import java.io.*;
import java.util.*;

public class Mun {
    static HashMap<Integer, List<Integer>> map;
    static boolean[] visit;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    map = new HashMap<>();
	    for(int i=1;i<=N;i++) {
	        map.put(i, new ArrayList<>());
	    }
	    for(int i=0;i<N-2;i++) {
	        String[] input = br.readLine().split(" ");
	        int a = Integer.parseInt(input[0]);
	        int b = Integer.parseInt(input[1]);
	        map.get(a).add(b);
	        map.get(b).add(a);
	    }
	    visit = new boolean[N+1];
	    int[] ans = new int[2];
	    int count = 0;
	    for(int i=1;i<=N;i++) {
	        if(visit[i]) continue;
	        ans[count]+=i;
	        if(++count > 1) break;
	        DFS(i);
	    }
	    System.out.print(ans[0]+" "+ans[1]);
	}
	public static void DFS(int island) {
	    visit[island] = true;
	    for(int n : map.get(island)) {
	        if(visit[n]) continue;
	        DFS(n);
	    }
	}
}