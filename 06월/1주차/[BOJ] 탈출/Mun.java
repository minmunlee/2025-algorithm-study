import java.io.*;
import java.util.*;

public class Mun {
    static String[][] map;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int R = Integer.parseInt(input[0]);
	    int C = Integer.parseInt(input[1]);
	    map = new String[R][C];
	    
	    boolean[][] visit = new boolean[R][C];
	    Queue<int[]> water = new LinkedList<>();
	    Queue<int[]> que = new LinkedList<>();
	    for(int i=0;i<R;i++) {
	        map[i] = br.readLine().split("");
	        for(int j=0;j<C;j++) {
	            if(map[i][j].equals("*")) {
	                water.add(new int[]{i, j, 0});
	            } else if(map[i][j].equals("S")) {
	                que.add(new int[]{i, j, 0});
	                visit[i][j] = true;
	            }
	        }
	    }
	    
	    int[][] waterTime = new int[R][C];
	    checkWaterTime(water, waterTime, R, C);
	    
	    System.out.print(findHedgehogTime(que, waterTime, visit, R, C));
	}
	
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	private static String findHedgehogTime(
	    Queue<int[]> que, int[][] waterTime, boolean[][] visit, int R, int C
	) {
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        int nt = now[2] + 1;
	        for(int[] d : dir) {
	            int nr = now[0] + d[0];
	            int nc = now[1] + d[1];
	            if(isExceedIndex(nr, nc, R, C) || isNotEmpty(map[nr][nc]) || 
	            visit[nr][nc] || (waterTime[nr][nc]>0 &&waterTime[nr][nc]<=nt)) {
	                continue;
	            }
	            if(map[nr][nc].equals("D")) {
	                return String.valueOf(nt);
	            }
	            visit[nr][nc] = true;
	            que.add(new int[]{nr, nc, nt});
	        }
	    }
	    return "KAKTUS";
	}
	
	private static void checkWaterTime(
	    Queue<int[]> water, int[][] waterTime, int R, int C
	) {
	    while(water.size() > 0) {
	        int[] now = water.poll();
	        int nt = now[2] + 1;
	        for(int[] d : dir) {
	            int nr = now[0] + d[0];
	            int nc = now[1] + d[1];
	            if(isExceedIndex(nr, nc, R, C) || isNotEmpty(map[nr][nc]) || 
	            (waterTime[nr][nc]>0 && waterTime[nr][nc]<=nt)) {
	                continue;
	            }
	            if(map[nr][nc].equals("D")) {
	                continue;
	            }
	            waterTime[nr][nc] = nt;
	            water.add(new int[]{nr, nc, nt});
	        }
	    }
	}
	
	private static boolean isExceedIndex(int nr, int nc, int R, int C) {
	    if(nr<0 || nr>=R || nc<0 || nc>=C) {
	        return true;
	    }
	    return false;
	}
	
	private static boolean isNotEmpty(String str) {
	    if(str.equals("*") || str.equals("X")) {
	        return true;
	    }
	    return false;
	}
}