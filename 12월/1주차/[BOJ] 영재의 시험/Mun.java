import java.io.*;
import java.util.*;

public class Mun {
    static long combo = 0;
    static int[] ans = new int[10];
    static int[] num = new int[10];
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    for(int i=0;i<10;i++) {
	        ans[i] = Integer.parseInt(st.nextToken());
	    }
	    findCombo(0, 0);
	    System.out.print(combo);
	}
	
	private static void findCombo(int index, int wrong) {
	    if(wrong > 5) {
	        return;
	    }
	    if(index == 10) {
	        combo++;
	        return;
	    }
	    for(int i=1;i<=5;i++) {
	        if(index >= 2) {
	            if(i == num[index-1] && num[index-2] == num[index-1]) {
	                continue;
	            }
	        }
	        num[index] = i;
	        findCombo(index+1, wrong+((ans[index] != i) ? 1 : 0));
	    }
	}
}