import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    String[] team = br.readLine().split(" ");
	    int M = Integer.parseInt(team[0]);
	    int K = Integer.parseInt(team[1]);
	    int[] CTP = Arrays.stream(br.readLine().split(" "))
	                        .mapToInt(Integer::parseInt)
	                        .sorted()
	                        .toArray();
	    int remain = M*K;
	    int member = 0;
	    for(int i=N-1;i>=0;i--) {
	        remain-=CTP[i];
	        if(remain <= 0) {
	            member = N - i;
	            break;
	        }
	    }
	    System.out.print((member > 0) ? member : "STRESS");
	}
}