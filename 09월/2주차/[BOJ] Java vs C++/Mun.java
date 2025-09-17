import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    if(!mcheck(input)) {
	        System.out.print("Error!");
	        return;
	    }
	    String ans = "";
	    String[] deleted = input.split("_");
	    if(deleted.length == 1) {
	        String java = deleted[0];
	        ans = convertToCpp(java.toCharArray());
	    } else if(isAllLowCase(deleted)) {
	        ans = convertToJava(deleted);
	    } else {
	        ans = "Error!";
	    }
	    System.out.print(ans);
	}
	
	private static boolean mcheck(String s) {
	    if(Character.isUpperCase(s.charAt(0))) {
	        return false;
	    }
	    if(s.charAt(0) == '_' || s.charAt(s.length()-1) == '_') {
	        return false;
	    }
	    for(int i=0;i<s.length()-1;i++) {
	        if(s.charAt(i) == '_' && s.charAt(i+1) == '_') {
	            return false;
	        }
	    }
	    return true;
	}
	
	private static String convertToCpp(char[] java) {
	    StringBuilder sb = new StringBuilder("");
	    for(char c : java) {
	        if(Character.isUpperCase(c)) {
	            sb.append("_");
	            c = Character.toLowerCase(c);
	        }
	        sb.append(c);
	    }
	    return sb.toString();
	}
	
	private static String convertToJava(String[] cpp) {
	    StringBuilder sb = new StringBuilder("");
	    for(String s : cpp) {
	        sb.append(Character.toUpperCase(s.charAt(0)));
	        for(int i=1;i<s.length();i++) {
	            sb.append(s.charAt(i));
	        }
	    }
	    sb.setCharAt(0, cpp[0].charAt(0));;
	    return sb.toString();
	}
	
	private static boolean isAllLowCase(String[] arr) {
	    for(String s : arr) {
	        for(char c : s.toCharArray()) {
	            if(Character.isUpperCase(c)) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
}