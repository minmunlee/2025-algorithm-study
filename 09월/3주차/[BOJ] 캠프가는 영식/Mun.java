import java.io.*;

public class Mun {
    static int T;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    T = Integer.parseInt(input[1]);
	    int ans = -1;
	    for(int i=0;i<N;i++) {
	        String[] busInfo = br.readLine().split(" ");
	        int S = Integer.parseInt(busInfo[0]);
	        int I = Integer.parseInt(busInfo[1]);
	        int C = Integer.parseInt(busInfo[2]);
	        int[] bus = new int[C];
	        for(int b=0;b<C;b++) {
	            bus[b] = S + (I * b);
	        }
	        int t = getTime(S, I, C, bus);
	        if(t < 0) {
	            continue;
	        }
	        ans = (ans < 0) ? t : Math.min(ans, t);
	    }
	    System.out.print(ans);
	}
	
	private static int getTime(int S, int I, int C, int[] bus) {
	    if(bus[C-1] < T) {
	        return -1;
	    }
	    int start = 0;
	    int end = C;
	    int min = Integer.MAX_VALUE;
	    while(start <= end) {
	        int mid = (start + end) / 2;
	        int time = bus[mid];
	        if(time < T) {
	            start = mid + 1;
	        } else if(time > T) {
	            end = mid - 1;
	            min = Math.min(Math.abs(time - T), min);
	        } else {
	            return 0;
	        }
	    }
	    return min;
	}
	
}
