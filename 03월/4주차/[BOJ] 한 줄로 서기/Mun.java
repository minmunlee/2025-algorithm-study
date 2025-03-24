import java.io.*;
import java.util.*;

public class Mun {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	    
	    LinkedList<Integer> list = new LinkedList<>();
	    for(int i=N-1;i>=0;i--) {
	        list.add(arr[i], i+1);
	    }

	    for(int seq : list) {
	        System.out.print(seq+" ");
	    }
	}
}