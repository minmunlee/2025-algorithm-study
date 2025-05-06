import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    Stack<Integer> stack = new Stack<>();
	    HashMap<Integer, Integer> count = new HashMap<>();
	    HashMap<Integer, Integer> score = new HashMap<>();
	    
	    int totalScore = 0;
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        if(input[0].equals("1")) {
	            int A = Integer.parseInt(input[1]);
	            int T = Integer.parseInt(input[2]);
	            stack.add(i);
	            score.put(i, A);
	            count.put(i, T);
	        }
	        if(stack.isEmpty()) continue;
	        int top = stack.peek();
	        if(count.get(top)==1) {
	            totalScore+=score.get(top);
	            count.remove(top);
	            score.remove(top);
	            stack.pop();
	        } else {
	            count.replace(top, count.get(top)-1);
	        }
	    }
	    System.out.print(totalScore);
	}
}