import java.io.*;
import java.util.*;

public class Mun {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[][] distance = new int[N+1][N+1];
	    
	    ArrayList<Integer>[] way = new ArrayList[N+1];
	    for(int i=1;i<=N;i++) {
	        way[i] = new ArrayList<>();
	    }
	    
	    for(int i=0;i<N-1;i++) {
	        String[] input = br.readLine().split(" ");
	        int A = Integer.parseInt(input[0]);
	        int B = Integer.parseInt(input[1]);
	        int C = Integer.parseInt(input[2]);
	        way[A].add(B);
	        way[B].add(A);
	        distance[A][B] = C;
	        distance[B][A] = C;
	    }
	    System.out.print(findMax(N, way, distance));
	}
	
	public static long findMax(int N, ArrayList<Integer>[] way, int[][] distance) {
	    long[] move = new long[N+1];
	    boolean[][] visit = new boolean[N+1][N+1];
	    Queue<Integer> que = new LinkedList<>();
	    que.add(1);
	    long max = 0;
	    while(que.size() > 0) {
	        int now = que.poll();
	        long cu_d = move[now];
	        if(max < cu_d) {
	            max = cu_d;
	        }
	        for(int next : way[now]) {
	            int d = distance[now][next];
	            if(!visit[now][next] && cu_d + d > move[next]) {
	                move[next] = cu_d + d;
	                que.add(next);
	                visit[now][next] = true;
	                visit[next][now] = true;
	            }
	        }
	    }
	    return max;
	}
}