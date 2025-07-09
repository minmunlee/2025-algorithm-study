import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] house = Arrays.stream(br.readLine().split(" "))
	                        .mapToInt(Integer::parseInt)
	                        .sorted()
	                        .toArray();
	    System.out.print(house[(N-1)/2]);
	}
}