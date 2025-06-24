import java.io.*;

public class Mun {
    static long min = 1000000000;
    static int N;
    static long[][] material;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    material = new long[N][2];
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        material[i][0] = Long.parseLong(input[0]);
	        material[i][1] = Long.parseLong(input[1]);
	    }
	    for(int i=0;i<N;i++) {
	        findComb(i+1, material[i][0], material[i][1]);
	    }
	    System.out.print(min);
	}
	
	private static void findComb(int start, long sour, long bitter) {
	    long diff = Math.abs(sour-bitter);
	    if(min > diff) {
	        min = diff;
	    }
	    for(int i=start;i<N;i++) {
	        findComb(i+1, sour*material[i][0], bitter+material[i][1]);
	    }
	}
}