import java.io.*;
import java.util.*;

public class Mun {
    
    static HashMap<String, HashSet<String>> map = new HashMap<>();
    static HashSet<String> visitSet = new HashSet<>();
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    int caseNumber = 1;
	    
	    int N = Integer.parseInt(br.readLine());
	    while(N!=0) {
	        for(int i=0;i<N;i++) {
	            String[] input = br.readLine().split(" ");
	            setMap(input[0], input[1]);
	            setMap(input[1], input[0]);
	        }
	        
	        int Link = 0;
	        for(String human : map.keySet()) {
	            if(visitSet.contains(human)) continue;
	            Link++;
	            visitSet.add(human);
	            dfs(map.get(human));
	        }
	        
	        sb.append(caseNumber).append(" ").append(Link).append("\n");
	        
	        map.clear();
	        visitSet.clear();
	        caseNumber++;
	        N = Integer.parseInt(br.readLine());
	    }
	    System.out.print(sb.toString());
	}
	
	private static void setMap(String h1, String h2) {
	    if(!map.containsKey(h1)) {
	        map.put(h1, new HashSet<>());
	    }
	    map.get(h1).add(h2);
	}
	
	private static void dfs(HashSet<String> linked){
	    for(String m : linked) {
	        if(visitSet.contains(m)) continue;
	        visitSet.add(m);
	        dfs(map.get(m));
	    }
	}
}