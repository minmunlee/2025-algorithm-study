import java.io.*;
import java.util.*;

public class Mun {
    static int L, C;
    static boolean[] visit;
    static String[] alpabet;
    static StringBuilder ans = new StringBuilder("");
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    L = Integer.parseInt(input[0]);
	    C = Integer.parseInt(input[1]);
	    alpabet = br.readLine().split(" ");
	    Arrays.sort(alpabet);
	    visit = new boolean[C];
	    findComb(0, 0, "");
	    System.out.print(ans.toString());
	}
	
	private static void findComb(int start, int deep, String s) {
	    if(deep == L) {
	        if(isPossible(s)) {
	            ans.append(s).append("\n");
	        }
	        return;
	    }
	    for(int i=start;i<C;i++) {
	        findComb(i+1, deep+1, s+alpabet[i]);
	    }
	}
	
	private static boolean isPossible(String str) {
	    String[] moum = {"a", "e", "i", "o", "u"};
	    int oLen = str.length();
	    for(String m : moum) {
	        str = str.replace(m, "");
	    }
	    int zLen = str.length();
	    int mLen = oLen - zLen;
	    if(mLen >= 1 && zLen >= 2) {
	        return true;
	    }
	    return false;
	}
}