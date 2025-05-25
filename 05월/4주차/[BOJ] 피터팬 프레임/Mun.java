import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] str = br.readLine().split("");
	    int size = str.length;
	    
	    StringBuilder sb1 = new StringBuilder("");
	    for(int i=1;i<=size;i++) {
	        String frame = (i%3==0) ? "*" : "#";
	        sb1.append(String.format("..%s.", frame));
	    }
	    sb1.append(".");
	    
	    StringBuilder sb2 = new StringBuilder("");
	    for(int i=1;i<=size;i++) {
	        String frame = (i%3==0) ? "*" : "#";
	        sb2.append(String.format(".%s.%s", frame, frame));
	    }
	    sb2.append(".");
	    
	    StringBuilder md = new StringBuilder("#");
	    for(int i=1;i<=size;i++) {
	        String frame = "#";
	        if(i%3==0) {
	            frame = "*";
	            md.setCharAt(md.length()-1, '*');
	        }
	        md.append(String.format(".%s.%s", str[i-1], frame));
	    }
	    
	    StringBuilder ans = new StringBuilder("");
	    ans.append(sb1.toString()).append("\n").append(sb2.toString()).append("\n");
	    ans.append(md.toString()).append("\n");
	    ans.append(sb2.toString()).append("\n").append(sb1.toString());
	    
	    System.out.print(ans.toString());
	}
}
