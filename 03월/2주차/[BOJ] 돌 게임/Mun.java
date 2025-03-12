import java.io.*;

public class Mun {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String ans = (N%2==0) ? "CY" : "SK";
	    System.out.print(ans);
	}
}