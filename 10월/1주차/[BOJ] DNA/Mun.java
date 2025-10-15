import java.io.*;
import java.util.*;


public class Mun {
    static HashMap<Character, Integer> map = new HashMap<>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};
    static HashMap<Integer, Character> dnaMap = new HashMap<>() {{
        put(0, 'A');
        put(1, 'C');
        put(2, 'G');
        put(3, 'T');
    }};
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    String[] str = new String[N];
	    for(int i=0;i<N;i++) {
	        str[i] = br.readLine();
	    }
	    int[][] idx = new int[M][4];
	    for(String s : str) {
	        for(int i=0;i<M;i++) {
	            idx[i][map.get(s.charAt(i))]++;
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    int hdSum = 0;
	    for(int i=0;i<M;i++) {
	        int maxIdx = 0;
	        int maxNum = idx[i][0];
	        for(int j=1;j<4;j++) {
	            if(maxNum < idx[i][j]) {
	                maxIdx = j;
	                maxNum = idx[i][j];
	            }
	        }
	        sb.append(dnaMap.get(maxIdx));
	        for(int j=0;j<4;j++) {
	            if(j == maxIdx) {
	                continue;
	            }
	            hdSum+=idx[i][j];
	        }
	    }
	    
	    System.out.print(sb.toString() + "\n" + hdSum);
	}
}