import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    PriorityQueue<int[]> task = new PriorityQueue<>((o1, o2) -> {
	        return o1[0] - o2[0];
	    });
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        int d = Integer.parseInt(input[0]);
	        int w = Integer.parseInt(input[1]);
	        task.add(new int[]{d, w});
	    }
	    PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> {
	        return o1[1] - o2[1];
	    });
	    int max = 0;
	    while(task.size() > 0) {
	        int[] t = task.poll();
	        que.add(t);
	        if(que.size() > t[0]) {
	            que.poll();
	        }
	    }
	    int score = 0;
	    while(que.size() > 0) {
	        score+=que.poll()[1];
	    }
	    System.out.print(score);
	}
}