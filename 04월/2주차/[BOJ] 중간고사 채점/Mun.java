import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    
	    int[] point = new int[N+1];
	    String[] p_input = br.readLine().split(" ");
	    for(int i=1;i<=N;i++) {
	        point[i] = Integer.parseInt(p_input[i-1]);
	    }
	    
	    int[][] score = new int[M][2];
	    for(int i=0;i<M;i++) {
	        String[] s_input = br.readLine().split(" ");
	        score[i][0] = Integer.parseInt(s_input[0]);
	        for(int j=1;j<=N;j++) {
	            if(s_input[j].equals("O")) {
	                score[i][1]+=point[j];
	            }
	        }
	    }
	    Arrays.sort(score, (o1, o2)->{
	        return o1[1]==o2[1] ? o1[0] - o2[0] : o2[1] - o1[1];
	    });
	    System.out.print(score[0][0]+" "+score[0][1]);
	}
}