import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[][] ride = new int[N][2];
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        ride[i][0] = getTime(Integer.parseInt(input[0]))-10;
	        ride[i][1] = getTime(Integer.parseInt(input[1]))+10;
	    }
	    Arrays.sort(ride, (o1, o2)->{
	        return (o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0];
	    });
	    int end = getTime(1000);
	    int time = 0;
	    for(int[] r : ride) {
	        if(r[0] > end && (r[0] - end) > time) {
	            time = r[0] - end;
	        }
	        if(end < r[1]) end = r[1];
	    }
	    if(getTime(2200) - end > time) time = getTime(2200) - end;
	    
	    System.out.print(time);
	}
	
	private static int getTime(int t) {
	    return (t/100)*60 + (t%100);
	}

}