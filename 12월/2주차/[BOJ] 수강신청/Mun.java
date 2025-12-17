import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int K = Integer.parseInt(input[0]);
	    int L = Integer.parseInt(input[1]);
	    HashMap<String, Integer> map = new HashMap<>();
	    TreeMap<Integer, String> orderMap = new TreeMap<>((o1, o2) -> o1 - o2);
	    int order = 0;
	    for(int i=0;i<L;i++) {
	        order++;
	        String student = br.readLine();
	        if(map.containsKey(student)) {
	            int o = map.get(student);
	            orderMap.remove(o);
	            map.remove(student);
	        }
	        map.put(student, order);
	        orderMap.put(order, student);
	    }
	    StringBuilder sb = new StringBuilder("");
	    int count = 0;
	    for(int o : orderMap.keySet()) {
	        count++;
	        sb.append(orderMap.get(o)).append("\n");
	        if(count == K) {
	            break;
	        }
	    }
	    System.out.print(sb.toString());
	}
	
}