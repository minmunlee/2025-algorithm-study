import java.io.*;

public class Mun {
    static int N;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    boolean[] now1 = new boolean[N];
	    boolean[] now2 = new boolean[N];
	    boolean[] goal = new boolean[N];
	    String[] nInput = br.readLine().split("");
	    for(int i=0;i<N;i++) {
	        now1[i] = nInput[i].equals("1");
	        now2[i] = now1[i];
	    }
	    now2[0] = !now2[0];
	    now2[1] = !now2[1];
	    String[] tInput = br.readLine().split("");
	    for(int i=0;i<N;i++) {
	        goal[i] = tInput[i].equals("1");
	    }
	    int n1Count = count(now1, goal);
	    int n2Count = count(now2, goal);
	    if(n2Count != -1)  {
	        n2Count++;
	    }
	    int ans = 0;
	    if (n1Count == -1) {
	        ans = n2Count;
	    } else if (n2Count == -1) {
	        ans = n1Count;
	    } else {
	        ans = Math.min(n1Count, n2Count);
	    }
	    System.out.print(ans);
	}
	
	private static int count(boolean[] now, boolean[] goal) {
	    int count = 0;
	    for(int i=0;i<N-2;i++) {
	        if(now[i] == goal[i]) {
	            continue;
	        }
	        count++;
	        now[i] = !now[i];
	        now[i+1] = !now[i+1];
	        now[i+2] = !now[i+2];
	    }
	    if(now[N-2] != goal[N-2]) {
	        count++;
	        now[N-2] = !now[N-2];
	        now[N-1] = !now[N-1];
	    }
	    return (now[N-1] == goal[N-1]) ? count : -1;
	}
}