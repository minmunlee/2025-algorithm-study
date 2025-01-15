import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<n;i++) {
	        String[] input = br.readLine().split(" ");
	        int a = Integer.parseInt(input[0]);
	        if(a==0) {
	            sb.append((que.isEmpty()) ? -1 : que.poll()).append("\n");
	            continue;
	        }
	        for(int j=1;j<=a;j++) {
	            que.add(Integer.parseInt(input[j]));
	        }
	    }
	    System.out.print(sb.toString());
	}
}