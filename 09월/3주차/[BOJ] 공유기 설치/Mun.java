import java.io.*;
import java.util.*;

public class Mun {
    static int[] house;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] info = br.readLine().split(" ");
	    int N = Integer.parseInt(info[0]);
	    int C = Integer.parseInt(info[1]);
	    house = new int[N];
	    for(int i=0;i<N;i++) {
	        house[i] = Integer.parseInt(br.readLine());
	    }
	    Arrays.sort(house);
        
	    int ans = 0;
	    int min = 1;
	    int max = house[N-1] - house[0];
	    while(min <= max) {
	        int mid = (min + max) / 2;
	        if(getMaxCount(mid) >= C) {
                ans = mid;
	            min = mid + 1;
	        } else {
	            max = mid - 1;
	        }
	    }
	    
	    System.out.print(ans);
	}
	
	private static int getMaxCount(int dis) {
	    int count = 1;
	    int front = 0;
	    for(int i=1;i<house.length;i++) {
	        int diff = house[i] - house[front];
	        if(diff >= dis) {
	            count++;
	            front = i;
	        }
	    }
	    return count;
	}
	
}