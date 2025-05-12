import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int testCase = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder("");
	    while(testCase > 0) {
	        String[] input = br.readLine().split(" ");
	        int N = Integer.parseInt(input[0]);
	        int M = Integer.parseInt(input[1]);
	        TreeMap<Integer, Integer> order = new TreeMap<>(Collections.reverseOrder());
	        Queue<int[]> que = new LinkedList<>();
	        int[] imp = Arrays.stream(br.readLine().split(" "))
	                            .mapToInt(Integer::parseInt)
	                            .toArray();
	        for(int i=0;i<N;i++) {
	            que.add(new int[]{imp[i], i});
	            order.put(imp[i], order.getOrDefault(imp[i], 0) + 1);
	        }
	        sb.append(getSequenceBy(M, order, que)).append("\n");
	        testCase--;
	    }
	    System.out.print(sb.toString());
	}
	
	public static int getSequenceBy(
	    int target, TreeMap<Integer, Integer> order, Queue<int[]> que
	) {
	    int count = 0;
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        int nowImp = now[0];
	        int nowNum = now[1];
	        if(order.firstKey() != nowImp) {
	            que.add(now);
	        } else if(nowNum == target) {
	            return ++count;
	        } else {
	            count++;
	            order.replace(nowImp, order.get(nowImp) - 1);
	            if(order.get(nowImp) == 0) {
	                order.remove(nowImp);
	            }
	        }
	    }
	    return count;
	}
}