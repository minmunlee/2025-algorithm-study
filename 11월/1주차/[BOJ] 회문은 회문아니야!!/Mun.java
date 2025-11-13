import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();
	    int len = str.length();
	    int mid = len/2;
	    int right = mid - 1;
	    int left = (len%2==0) ? mid : mid + 1;
	    
	    char c = str.charAt(0);
	    boolean isPalin = true;
	    boolean isSame = (c == str.charAt(mid));
	    
	    while(right >= 0 && left < len) {
	        char r = str.charAt(right);
	        char l = str.charAt(left);
	        if(r != l) {
	            isPalin = false;
	            break;
	        }
	        if(isSame && ((c != r) || (c != l))) {
	            isSame = false;
	        }
	        right--;
	        left++;
	    }
	    int ans = 0;
	    if(!isPalin) {
	        ans = len;
	    } else if(isSame) {
	        ans = -1;
	    } else {
	        ans = len - 1;
	    }
	    System.out.print(ans);
	}
}