import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int L = Integer.parseInt(input[1]);
	    int[] leaky = Arrays.stream(br.readLine().split(" "))
	                        .mapToInt(Integer::parseInt)
	                        .sorted()
	                        .toArray();
	    int last = 0;
	    int count = 0;
	    for(int n : leaky) {
	        if(n > last) {
	            count++;
	            last = n + L -1;
	        }
	    }
	    System.out.print(count);
	}
}
