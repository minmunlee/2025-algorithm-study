import java.io.*;
import java.util.*;

public class Mun {
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int R = Integer.parseInt(br.readLine());
	    TreeMap<Integer, Candidate> numberMap = new TreeMap<>();
	    TreeSet<Candidate> pfSet = new TreeSet<>((o1, o2)->{
	        return (o1.count == o2.count) ? o1.order - o2.order : o1.count - o2.count;
	    });
	    String[] input = br.readLine().split(" ");
	    for(int i=0;i<R;i++) {
	        int number = Integer.parseInt(input[i]);
	        if(numberMap.containsKey(number)) {
	            Candidate cd = numberMap.get(number);
	            pfSet.remove(cd);
	            cd.count++;
	            pfSet.add(cd);
	            continue;
	        }
	        if(pfSet.size() >= N) {
	            Candidate cd = pfSet.pollFirst();
	            numberMap.remove(cd.number);
	        }
	        Candidate newcd = new Candidate(number, 1, i);
	        numberMap.put(number, newcd);
	        pfSet.add(newcd);
	    }
	    
	    for(int num : numberMap.keySet()) {
	        System.out.print(num+" ");
	    }

	}
	
	static class Candidate {
	    int number;
	    int count;
	    int order;
	    
	    Candidate(int number, int count, int order) {
	        this.number = number;
	        this.count = count;
	        this.order = order;
	    }
	}
	
}