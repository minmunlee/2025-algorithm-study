import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int tc=0;tc<t;tc++) {
	        int n = Integer.parseInt(br.readLine());
	        String[] pnList = new String[n];
	        for(int i=0;i<n;i++) {
	            pnList[i] = br.readLine();
	        }
	        Arrays.sort(pnList);
	        sb.append((isCons(n, pnList))?"YES":"NO").append("\n");
	    }
	    System.out.print(sb.toString());
	}
	
	private static boolean isCons(int n, String[] pnList) {
	    for(int i=1;i<n;i++) {
	        if(pnList[i].startsWith(pnList[i-1])) {
	            return false;
	        }
	    }
	    return true;
	}
}