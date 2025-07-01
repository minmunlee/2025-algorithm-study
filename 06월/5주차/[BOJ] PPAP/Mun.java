import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();
	    Stack<Character> stack = new Stack<>();
	    int size = str.length();
	    for(int i=0;i<size;i++) {
	        char c = str.charAt(i);
	        if(c == 'A') {
	            stack.push(c);
	            continue;
	        }
	        if(stack.size() >= 3) {
	            char[] can = new char[3];
	            for(int j=0;j<3;j++) {
	                can[j] = stack.pop();
	            }
	            if(!isPPAP(can)) {
	                for(int j=2;j>=0;j--) {
	                    stack.push(can[j]);
	                }
	            }
	        }
	        stack.push(c);
	    }
	    if(stack.size() == 1 && stack.peek() == 'P') {
	        System.out.print("PPAP");
	    } else {
	        System.out.print("NP");
	    }
	}
	
	private static boolean isPPAP(char[] can) {
	    if(can[0]=='A' && can[1]=='P' && can[2]=='P') {
	        return true;
	    }
	    return false;
	}
}