import java.io.*;
public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] str1 = br.readLine().split("");
	    String[] str2 = br.readLine().split("");
	    int size1 = str1.length;
	    int size2 = str2.length;
	    int[][] count = new int[size1+1][size2+1];
	    for(int i=1;i<=size1;i++) {
	        for(int j=1;j<=size2;j++) {
	            if(str1[i-1].equals(str2[j-1])) {
	                count[i][j] = count[i-1][j-1] + 1;
	            } else {
	                count[i][j] = Math.max(count[i-1][j], count[i][j-1]);
	            }
	        }
	    }
	    System.out.print(count[size1][size2]);
	}
}