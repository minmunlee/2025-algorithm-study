import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    long N = Long.parseLong(input[0]);
	    long M = Long.parseLong(input[1]);
	    Set<String> set = new HashSet<>();
	    for(long i=0;i<N;i++) {
	        set.add(br.readLine());
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(long i=0;i<M;i++) {
	        String[] keyword = br.readLine().split(",");
	        for(String k : keyword) {
	            if(set.contains(k)) {
	                set.remove(k);
	            }
	        }
	        sb.append(set.size()).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}