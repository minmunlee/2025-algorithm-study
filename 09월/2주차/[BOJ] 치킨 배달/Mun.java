import java.io.*;
import java.util.*;

public class Mun {
    static int[][] HCDis;
    static int M;
    static int chds = Integer.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] info = br.readLine().split(" ");
	    int N = Integer.parseInt(info[0]);
	    M = Integer.parseInt(info[1]);
	    ArrayList<int[]> house = new ArrayList<>();
	    ArrayList<int[]> chicken = new ArrayList<>();
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=0;j<N;j++) {
	            int num = Integer.parseInt(input[j]);
	            if(num == 1) {
	                house.add(new int[]{i, j});
	            } else if(num == 2) {
	                chicken.add(new int[]{i, j});
	            }
	        }
	    }
	    
	    HCDis = new int[house.size()][chicken.size()];
	    for(int i=0;i<house.size();i++) {
	        int[] h = house.get(i);
	        for(int j=0;j<chicken.size();j++) {
	            HCDis[i][j] = getDis(h, chicken.get(j));
	        }
	    }
	    
	    dfs(0, 0, new int[M]);
	    
	    System.out.print(chds);
	}
	
	private static void dfs(int start, int index, int[] comb) {
	    if(index > 0 && index <= M) {
	        int sum = 0;
	        for(int[] ch : HCDis) {
	            int min = ch[comb[0]];
	            for(int i=0;i<index;i++) {
	                min = Math.min(ch[comb[i]], min);
	            }
	            sum+=min;
	        }
	        chds = Math.min(chds, sum);
	        if(index == M) {
	            return;
	        }
	    }
	    for(int i=start;i<HCDis[0].length;i++) {
	        comb[index] = i;
	        dfs(i+1, index+1, comb);
	    }
	}
	
	private static int getDis(int[] a, int[] b) {
	    return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
	
}