import java.io.*;

public class Mun {
    static int N, max = 0;
    static int[] nums;
    static boolean[] visit;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    String[] input = br.readLine().split(" ");
	    nums = new int[N];
	    for(int i=0;i<N;i++) {
	        nums[i] = Integer.parseInt(input[i]);
	    }
	    visit = new boolean[N];
	    int[] order = new int[N];
	    findCom(0, order);
	    System.out.print(max);
	}
	
	private static void findCom(int deep, int[] order) {
	    if(deep == N) {
	        int sum = cal(order);
	        if(max < sum) {
	            max = sum;
	        }
	        return;
	    }
	    for(int i=0;i<N;i++) {
	        if(visit[i]) {
	            continue;
	        }
	        visit[i] = true;
	        order[deep] = nums[i];
	        findCom(deep+1, order);
	        visit[i] = false;
	    }
	}
	
	private static int cal(int[] order) {
	    int sum = 0;
	    for(int i=0;i<N-1;i++) {
	        sum+= Math.abs(order[i] - order[i+1]);
	    }
	    return sum;
	}
}