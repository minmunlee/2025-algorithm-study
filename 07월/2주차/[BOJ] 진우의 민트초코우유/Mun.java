import java.io.*;
import java.util.*;

public class Mun {
    static ArrayList<int[]> mincho = new ArrayList<>();
    static int[] home = new int[2];
    static int maxMincho = 0;
    static int H;
    static boolean[] visit;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    H = Integer.parseInt(input[2]);
	    
	    for(int i=0;i<N;i++) {
	        String[] mapInput = br.readLine().split(" ");
	        for(int j=0;j<N;j++) {
	            if(mapInput[j].equals("2")) {
	                mincho.add(new int[]{i, j});
	            } else if(mapInput[j].equals("1")) {
	                home[0] = i;
	                home[1] = j;
	            }
	        }
	    }
	    
	    visit = new boolean[mincho.size()];
	    
	    findMaxMincho(home[0], home[1], M, 0);
	    System.out.print(maxMincho);
	    
	}
	
	private static void findMaxMincho(int x, int y, int hp, int minchoCount) {
	    if(getDistance(x, home[0], y, home[1]) <= hp) {
	        maxMincho = Math.max(maxMincho, minchoCount);
	        if(maxMincho == mincho.size()) {
	            return;
	        }
	    }
	    for(int i=0;i<mincho.size();i++) {
	        if(visit[i]) {
	            continue;
	        }
	        int[] next = mincho.get(i);
	        int dis = getDistance(x, next[0], y, next[1]);
	        if(hp >= dis) {
	            visit[i] = true;
	            findMaxMincho(next[0], next[1], hp - dis + H, minchoCount + 1);
	            visit[i] = false;
	        }
	    }
	}
	
	private static int getDistance(int x1, int x2, int y1, int y2) {
	    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
}