import java.io.*;

public class Mun {
    static int[] list;
    static boolean[] visit;
    static int count = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    list = new int[N+1];
	    for(int i=1;i<=N;i++) {
	        list[i] = Integer.parseInt(br.readLine());
	    }
	    int max = 0;
	    int ans = 0;
	    for(int i=1;i<=N;i++) {
	        visit = new boolean[N+1];
	        countNum(i);
	        if(count > max) {
	            max = count;
	            ans = i;
	        }
	        count = 0;
	    }
	    System.out.print(ans);
	}
	
	private static void countNum(int now) {
	    if(visit[now]) {
	        return;
	    }
	    count++;
	    visit[now] = true;
	    countNum(list[now]);
	}
}