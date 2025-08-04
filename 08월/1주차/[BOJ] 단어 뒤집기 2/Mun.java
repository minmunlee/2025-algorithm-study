import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String S = br.readLine();
	    StringBuilder sb = new StringBuilder("");
	    Stack<Character> stack = new Stack<>();
	    for(int i=0;i<S.length();i++) {
	        char s = S.charAt(i);
	        if(s == '<') {
	            int cnt = i + 1;
	            while(cnt < S.length()) {
	                if(S.charAt(cnt) == '>') {
	                    break;
	                }
	                cnt++;
	            }
	            if(cnt < S.length() && S.charAt(cnt) == '>' && (cnt - i) > 1) {
	                while(stack.size() > 0) {
	                    sb.append(stack.pop());
	                }
	                for(int j=i;j<=cnt;j++) {
	                    sb.append(S.charAt(j));
	                }
	                i = cnt;
	            } else {
	                stack.add(s);
	            }
	        } else if(s == ' ') {
	            while(stack.size() > 0) {
	                sb.append(stack.pop());
	            }
	            sb.append(" ");
	        } else {
	            stack.add(s);
	        }
	    }
	    while(stack.size() > 0) {
	        sb.append(stack.pop());
	    }
	    System.out.print(sb.toString());
	}
}