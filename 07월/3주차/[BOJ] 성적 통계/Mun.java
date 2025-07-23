import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int K = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<K;i++) {
	        String[] input = br.readLine().split(" ");
	        int N = Integer.parseInt(input[0]);
	        ArrayList<Integer> arr = new ArrayList<>();
	        for(int j=1;j<=N;j++) {
	            arr.add(Integer.parseInt(input[j]));
	        }
	        arr.sort(Collections.reverseOrder());
	        int max = arr.get(0);
	        int min = arr.get(N-1);
	        int gap = getGap(arr);
	        sb.append("Class "+(i+1)+"\n");
	        sb.append(String.format("Max %d, Min %d, Largest gap %d\n",max, min, gap));
	    }
	    System.out.print(sb.toString());
	}
	
	private static int getGap(ArrayList<Integer> arr) {
	    int max = 0;
	    for(int i=0;i<arr.size()-1;i++) {
	        max = Math.max(max, arr.get(i) - arr.get(i+1));
	    }
	    return max;
	}
}