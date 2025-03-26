import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    HashMap<String, Integer> map = new HashMap<>();
	    for(int i=0;i<N;i++) {
	        String[] word = br.readLine().split("");
	        int size = word.length - 1;
	        for(int j=0;j<=size; j++) {
	            map.put(word[j],
	                    map.getOrDefault(word[j], 0) + (int)Math.pow(10, size - j));
	        }
	    }
	    
	    List<String> words = new ArrayList<>(map.keySet());
	    words.sort((o1, o2)->{
	        return map.get(o2) - map.get(o1);
	    });
	    
	    int num = 9;
	    int ans = 0;
	    for(String w : words) {
	        ans += (map.get(w) * num--);
	    }
	    System.out.print(ans);
	}
	
}