import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<T;i++) {
	        int N = Integer.parseInt(br.readLine());
	        int[][] rank = new int[N][2];
	        for(int j=0;j<N;j++) {
	            String[] input = br.readLine().split(" ");
	            rank[j][0] = Integer.parseInt(input[0]);
	            rank[j][1] = Integer.parseInt(input[1]);
	        }
	        Arrays.sort(rank, (o1, o2) -> {
	            return o1[0] - o2[0];
	        });
	        int count = 1;
	        int min = rank[0][1];
	        for(int j=1;j<N;j++) {
	            if(rank[j][1] < min) {
	                count++;
	                min = rank[j][1];
	            }
	        }
	        sb.append(count).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}