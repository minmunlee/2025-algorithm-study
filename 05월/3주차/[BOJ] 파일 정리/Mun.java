import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    TreeMap<String, Integer> map = new TreeMap<>();
	    for(int i=0;i<N;i++) {
	        String extension = br.readLine().split("\\.")[1];
	        map.put(extension, map.getOrDefault(extension, 0) + 1);
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(String k : map.keySet()) {
	        sb.append(k).append(" ").append(map.get(k)).append("\n");
	    }
	    System.out.print(sb.toString());
	}
}