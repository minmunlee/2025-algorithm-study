import java.io.*;

public class Mun {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    
	    int T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++) {
	        int N = Integer.parseInt(br.readLine());
	        String[] spInput = br.readLine().split(" ");
	        int[] sp = new int[N];
	        for(int i=0;i<N;i++) {
	            sp[N-1-i] = Integer.parseInt(spInput[i]);
	        }
	        int max = sp[0];
	        long sum = 0;
	        for(int i=1;i<N;i++) {
	            if(max < sp[i]) {
	                max = sp[i];
	            } else if(max > sp[i]) {
	                sum+=(max - sp[i]);
	            }
	        }
	        sb.append(sum).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}