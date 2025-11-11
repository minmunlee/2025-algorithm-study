import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String[] serials = new String[N];
	    for(int i=0;i<N;i++) {
	        serials[i] = br.readLine();
	    }
	    Arrays.sort(serials, (o1, o2) -> {
	        if(o1.length() != o2.length()) {
	            return o1.length() - o2.length();
	        }
	        int AS = 0;
	        int BS = 0;
	        for(int i=0;i<o1.length();i++) {
	            char a = o1.charAt(i);
	            char b = o2.charAt(i);
	            if(Character.isDigit(a)) {
	                AS+=(a - '0');
	            }
	            if(Character.isDigit(b)) {
	                BS+=(b - '0');
	            }
	        }
	        if(AS != BS) {
	            return AS - BS;
	        }
	        return o1.compareTo(o2);
	    });
	    StringBuilder sb = new StringBuilder("");
	    for(String s : serials) {
	        sb.append(s).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}