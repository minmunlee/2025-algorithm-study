import java.io.*;
import java.util.*;
public class Mun {
	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int[][] lectures = new int[N][3];
	    for(int i=0;i<N;i++) {
	        lectures[i] = Arrays
	                            .stream(br.readLine()
	                            .split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .toArray();
	    }
	    Arrays.sort(lectures, (o1, o2) -> {
	        if(o1[1]==o2[1]) {
	            return o1[2] - o2[2];
	        }
	        return o1[1] - o2[1];
	    });
	    
	    PriorityQueue<Integer> que = new PriorityQueue<>();
	    for(int[] lec : lectures) {
	        if(que.isEmpty()) {
	            que.add(lec[2]);
	            continue;
	        }
	        if(lec[1] >= que.peek()) {
	            que.poll();
	        }
	        que.add(lec[2]);
	    }
	    System.out.print(que.size());
	}
}