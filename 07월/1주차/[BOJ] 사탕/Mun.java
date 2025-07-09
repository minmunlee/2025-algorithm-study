import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    int T = Integer.parseInt(br.readLine());
	    for(int i=0;i<T;i++) {
	        String[] input = br.readLine().split(" ");
	        int J = Integer.parseInt(input[0]);
	        int N = Integer.parseInt(input[1]);
	        Integer[] boxs = new Integer[N];
	        for(int b=0;b<N;b++) {
	            String[] size = br.readLine().split(" ");
	            boxs[b] = Integer.parseInt(size[0]) * Integer.parseInt(size[1]);
	        }
	        Arrays.sort(boxs, Collections.reverseOrder());
	        int min = 0;
	        while(J>0) {
	            J-=boxs[min];
	            min++;
	        }
	        sb.append(min).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}