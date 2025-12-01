import java.io.*;

public class Mun {
    static int N;
    static boolean[] state;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    char[] bulb = br.readLine().toCharArray();
	    N = bulb.length;
	    state = new boolean[N+1];
	    
	    for(int i=1;i<=N;i++) {
	        state[i] = bulb[i-1] == 'Y';
	    }
	    
	    int count = 0;
	    for(int i=1;i<=N;i++) {
	        if(state[i]) {
	            count++;
	            change(i);
	        }
	    }
	    System.out.print(count);
	}
	
	private static void change(int dr) {
	    for(int i=dr;i<=N;i+=dr) {
	        state[i] = !state[i];
	    }
	}
}