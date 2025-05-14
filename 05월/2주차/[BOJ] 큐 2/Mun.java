import java.io.*;
import java.util.*;

public class Mun {
    static Deque<String> que = new ArrayDeque<>();
    
	public static void main(String[] args) throws IOException { 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<N;i++){
	        String output = print(br.readLine().split(" "));
	        if(output.length()==0) continue;
	        sb.append(output).append("\n");
	    }
	    System.out.print(sb.toString());
	}
	
	private static String print(String[] input) {
	    switch(input[0]) {
	        case "push":
	            que.add(input[1]);
	            return "";
	        case "pop":
	            return (que.isEmpty()) ? "-1" :que.poll();
	        case "size":
	            return String.valueOf(que.size());
	        case "empty":
	            return (que.isEmpty()) ? "1" : "0";
	        case "front":
	            return (que.isEmpty()) ? "-1" : que.getFirst();
	        case "back":
	            return (que.isEmpty()) ? "-1" : que.getLast();
	        default:
	            return "";
	    }
	}
}
