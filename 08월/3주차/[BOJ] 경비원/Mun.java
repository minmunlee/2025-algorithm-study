import java.io.*;
import java.util.*;

public class Mun {
    static int X, Y;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    Y = Integer.parseInt(input[0]);
	    X = Integer.parseInt(input[1]);
	    ArrayList<int[]> store = new ArrayList<>();
	    int storeNum = Integer.parseInt(br.readLine());
	    for(int i=0;i<storeNum;i++) {
	        String[] storeInput = br.readLine().split(" ");
	        int d1 = Integer.parseInt(storeInput[0]);
	        int d2 = Integer.parseInt(storeInput[1]);
	        store.add(new int[]{d1, d2});
	    }
	    String[] dongun = br.readLine().split(" ");
	    int d1 = Integer.parseInt(dongun[0]);
	    int d2 = Integer.parseInt(dongun[1]);
	    int entire = X*2 + Y*2;
	    int sum = 0;
	    for(int[] s : store) {
	        int d = getOneDistance(d1, d2, s[0], s[1]);
	        sum+=Math.min(d, entire - d);
	    }
	    System.out.print(sum);
	}
	
	private static int getOneDistance(int d1, int d2, int s1, int s2) {
	    if(d1 == s1) {
	        return Math.abs(d2 - s2);
	    }
	    if(d1 == 1) {
	        switch (s1) {
	            case 2:
	                return d2 + X + s2;
	            case 3:
	                return d2 + s2;
	            case 4:
	                return Y - d2 + s2;
	        }
	    } else if(d1 == 2) {
	        switch (s1) {
	            case 1: 
	                return d2 + X + s2;
	            case 3:
	                return d2 + X - s2;
	            case 4: 
	                return Y - d2 + X - s2;
	        }
	    } else if(d1 == 3) {
	        switch (s1) {
	            case 1:
	                return d2 + s2;
	            case 2: 
	                return X - d2 + s2;
	            case 4:
	                return d2 + Y + s2;
	        }
	    } else {
	        switch (s1) {
	            case 1: 
	                return d2 + Y - s2;
	            case 2:
	                return X - d2 + Y - s2;
	            case 3:
	                return d2 + Y + s2;
	        }
	    }
	    return 0;
	}

}