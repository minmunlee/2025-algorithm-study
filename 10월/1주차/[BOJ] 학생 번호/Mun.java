import java.io.*;
import java.util.*;


public class Mun {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String[] s_number = new String[N];
	    for(int i=0;i<N;i++) {
	        s_number[i] = br.readLine();
	    }
	    int len = s_number[0].length();
	    int ans = 0;
	    for(int i=1;i<=len;i++) {
	        HashSet<String> set = new HashSet<>();
	        for(int j=0;j<N;j++) {
	            set.add(s_number[j].substring(len-i, len));
	        }
	        if(set.size() == N) {
	            ans = i;
	            break;
	        }
	    }
	    System.out.print(ans);
	}
}