import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int K = Integer.parseInt(br.readLine());
	    String num = Integer.toBinaryString(K+1).replace("0", "4").replace("1", "7");
	    System.out.print(num.substring(1, num.length()));
	}
}