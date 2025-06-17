import java.io.*;
import java.util.*;

public class Mun {
    static HashSet<Integer> set = new HashSet<>();
    static int[] card;
    static boolean[] visit;
    static int n, k;
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(br.readLine());
	    k = Integer.parseInt(br.readLine());
	    card = new int[n];
	    visit = new boolean[n];
	    for(int i=0;i<n;i++) {
	        card[i] = Integer.parseInt(br.readLine());
	    }
	    findNumber(0, 0);
	    System.out.print(set.size());
	}
	
	private static void findNumber(int number, int deep) {
	    if(deep == k) {
	        set.add(number);
	        return;
	    }
	    for(int i=0;i<n;i++) {
	        if(visit[i]) {
	            continue;
	        }
	        visit[i] = true;
	        findNumber(number*((card[i]/10==0)?10:100)+card[i], deep+1);
	        visit[i] = false;
	    }
	}
}