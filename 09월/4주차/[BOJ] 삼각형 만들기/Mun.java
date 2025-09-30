import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] straw = new int[N];
	    for(int i=0;i<N;i++) {
	        straw[i] = Integer.parseInt(br.readLine());
	    }
	    Arrays.sort(straw);
	    int max = -1;
	    for(int i=N-1;i>1;i--) {
	        int longest = straw[i];
	        int other1 = straw[i-1];
	        int other2 = straw[i-2];
	        if(longest < (other1 + other2)) {
	            max+=(longest+other1+other2+1);
	            break;
	        }
	    }
	    System.out.print(max);
	}
}