import java.io.*;
import java.util.*;

public class Mun {
    static int N;
    static int[] nums = {1, 5, 10, 50};
    static HashSet<Integer> set = new HashSet<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    findNum(0, 0, 0);
	    System.out.print(set.size());
	    
	}
	
	private static void findNum(int deep, int sum, int index) {
	    if(deep == N) {
	        set.add(sum);
	        return;
	    }
	    for(int i=index;i<4;i++) {
	        findNum(deep + 1, sum + nums[i], i);
	    }
	}
	
}