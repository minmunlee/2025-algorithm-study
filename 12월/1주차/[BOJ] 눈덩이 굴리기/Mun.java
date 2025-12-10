import java.io.*;
import java.util.*;

public class Mun {
    static int N, M, max = 0;
    static int[] garden;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    garden = new int[N+1];
	    st = new StringTokenizer(br.readLine(), " ");
	    for(int i=1;i<=N;i++) {
	        garden[i] = Integer.parseInt(st.nextToken());
	    }
	    findMax(0, 1, 0);
	    System.out.print(max);
	}
	
	private static void findMax(int now, int sum, int time) {
	    if(now > N || time > M){
	        max = Math.max(max, sum);
	        return;
	    }
	    findMax(now + 1, sum + garden[now], time + 1);
	    findMax(now + 2, (sum + garden[now]) / 2, time + 1);
	}
}