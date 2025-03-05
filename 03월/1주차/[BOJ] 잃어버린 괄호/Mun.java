import java.io.*;
import java.util.*;

public class Mun{
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), "+-", true);
	    int sum = Integer.parseInt(st.nextToken());
	    while (st.hasMoreTokens()) {
	        String token = st.nextToken();
	        if(token.equals("-")) {
	            int temp = Integer.parseInt(st.nextToken());
	            while(st.hasMoreTokens()) {
	                String p = st.nextToken();
	                if(p.equals("-")) {
	                    sum-=temp;
	                    temp = Integer.parseInt(st.nextToken());
	                } else if(p.equals("+")) {
	                    temp+=Integer.parseInt(st.nextToken());
	                }
	            }
	            sum-=temp;
	        } else if(token.equals("+")) {
	            sum+=Integer.parseInt(st.nextToken());
	        }
	    }
	    System.out.print(sum);
	}
}