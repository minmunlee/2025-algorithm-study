import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<3; i++) {
			String[] input = br.readLine().split(" ");
			int[] num1 = convertArray(input[0]);
			int[] num2 = convertArray(input[1]);                 
			if(isFriends(num1, num2)) {
			    sb.append("friends");
			} else if(isAlmostFriends(num1, num2) || isAlmostFriends(num2, num1)) {
			    sb.append("almost friends");
			} else {
			    sb.append("nothing");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	private static boolean isAlmostFriends(int[] changed, int[] num) {
	    int[] cArray1 = changed.clone();
	    for(int i=0;i<changed.length-1;i++) {
	        cArray1[i]++;
	        cArray1[i+1]--;
	        if(checkValid(cArray1[i], cArray1[i+1]) && isFriends(cArray1, num)) {
	            return true;
	        }
	        cArray1[i]--;
	        cArray1[i+1]++;
	    }
	    int[] cArray2 = changed.clone();
	    for(int i=0;i<changed.length-1;i++) {
	        cArray2[i]--;
	        cArray2[i+1]++;
	        if(i==0 && cArray2[i]==0) {
	            continue;
	        }
	        if(checkValid(cArray2[i], cArray2[i+1]) && isFriends(cArray2, num)) {
	            return true;
	        }
	        cArray2[i]++;
	        cArray2[i+1]--;
	    }
	    return false;
	}
	
	private static boolean checkValid(int n1, int n2) {
	    return (n1 < 10 && n1 >= 0 && n2 < 10 && n2 >=0);
	}
	
	private static boolean isFriends(int[] num1, int[] num2) {
	    boolean[] a = new boolean[10];
	    boolean[] b = new boolean[10];
	    for(int n : num1) {
	        a[n] = true;
	    }
	    for(int n : num2) {
	        b[n] = true;
	    }
	    for(int i=0;i<10;i++) {
	        if(a[i] != b[i]) {
	            return false;
	        }
	    }
	    return true;
	}
	
	private static int[] convertArray(String s) {
	    return Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
	}
}