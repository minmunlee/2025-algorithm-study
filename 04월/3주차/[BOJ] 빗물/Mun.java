import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int H = Integer.parseInt(input[0]);
	    int W = Integer.parseInt(input[1]);
	    boolean[][] world = new boolean[H][W];
	    int[] rainwater = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .toArray();
	    for(int i=0;i<W;i++) {
	        for(int j=0;j<rainwater[i];j++) {
	            world[j][i] = true;
	        }
	    }
	    int allcount = 0;
	    for(int i=0;i<H;i++) {
	        int count = 0;
	        for(int j=0;j<W;j++) {
	            if(world[i][j]) {
	                j++;
	                while(j < W) {
	                    if(world[i][j]) {
	                        break;
	                    }
	                    count++;
	                    j++;
	                }
	                if(j<W && world[i][j]) {
	                    allcount+=count;
	                    count = 0;
	                    j--;
	                }
	            }
	        }
	    }
	    System.out.print(allcount);
	}
}