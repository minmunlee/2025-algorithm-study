import java.io.*;
import java.util.*;

public class Mun {
    static int[][] box;
    static int[] hole;
    static int[] checkD;
    static Set<Integer> endSet = new HashSet<>();

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] NM = br.readLine().split(" ");
	    int N = Integer.parseInt(NM[0]);
	    int M = Integer.parseInt(NM[1]);
	    checkD = new int[]{N, N+M, N*2+M, N*2+M*2};
	    setting(N, M);
	    for(int i=1;i<=N;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=1;j<=M;j++) {
	            box[i][j] = Integer.parseInt(input[j-1]);
	        }
	    }
	    int maxNum = N*2 + M*2;
	    hole = new int[maxNum+1];
	    for(int loc : endSet) {
	        int x = loc / 10000;
	        int y = loc % 10000; 
	        int startNumber = box[x][y];
	        int d = getD(startNumber);;
	        findNumber(startNumber, new int[]{x, y}, d);
	    }
	    
	    for(int i=1;i<=maxNum;i++) {
	        System.out.print(hole[i]+" ");
	    }
	    
	}
	
	public static void setting(int N, int M) {
	    box = new int[N+2][M+2];
	    int w = N + M;
	    int num = 0;
	    for(int i=1;i<=N;i++) {
	        box[i][0] = ++num;
	        box[N+1-i][M+1] = num + w;
	        endSet.add(i*10000);
	        endSet.add(i*10000 + M+1);
	    }
	    for(int i=1;i<=M;i++) {
	        box[N+1][i] = ++num;
	        box[0][M+1-i] = num + w;
	        endSet.add((N+1)*10000 + i);
	        endSet.add(i);
	    }

	}
	
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	public static void findNumber(int startNumber, int[] startLoc, int d) {
	    Queue<int[]> que = new LinkedList<>();
	    que.add(startLoc);
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        int n = now[0];
	        int m = now[1];
	        int nextN = n + dir[d][0];
	        int nextM = m + dir[d][1];
	        if(box[nextN][nextM]==1) {
	            d = 3 - d;
	        }
	        
	        if(endSet.contains(nextN*10000 + nextM)) {
	            hole[startNumber] = box[nextN][nextM];
	            break;
	        }
	        que.add(new int[]{nextN, nextM});
	    }
	}
	
	public static int getD(int startNumber) {
	    if(startNumber <= checkD[0]) return 1;
	    if(startNumber <= checkD[1]) return 2;
	    if(startNumber <= checkD[2]) return 3;
	    return 0;
	}

}