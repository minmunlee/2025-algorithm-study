import java.io.*;
import java.util.*;

public class Mun {
    static boolean[][] check = new boolean[101][101];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    for(int i=0;i<4;i++) {
	        int[] rec = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .toArray();
	        fill(rec[0], rec[2], rec[1], rec[3]);
	    }
	    System.out.print(getSize());
	}
	
	private static void fill(int x1, int x2, int y1, int y2) {
	    for(int i=x1;i<x2;i++) {
	        for(int j=y1;j<y2;j++) {
	            check[i][j] = true;
	        }
	    }
	}
	
	private static int getSize() {
	    int count = 0;
	    for(boolean[] line : check) {
	        for(boolean c : line) {
	            if(c) count++;
	        }
	    }
	    return count;
	}
}