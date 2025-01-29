import java.io.*;
import java.util.*;

public class Mun {
    static String ansFormat = "Escaped in %d minute(s).";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	public static void main(String[] args) throws IOException {
	    StringBuilder sb = new StringBuilder("");
	    String[] input = br.readLine().split(" ");
	    while(!input[0].equals("0")) {
	        int L = Integer.parseInt(input[0]);
	        int R = Integer.parseInt(input[1]);
	        int C = Integer.parseInt(input[2]);
	        String[][][] building = init(L, R, C);
	        int[] start = findStart(L, R, C, building);
	        int time = getTime(L, R, C, start, building);
	        String ans = (time==0) ? "Trapped!" : String.format(ansFormat, time);
	        sb.append(ans).append("\n");
	        input = br.readLine().split(" ");
	    }
	    System.out.print(sb.toString());
	}
	
	private static String[][][] init(int L, int R, int C) throws IOException {
	    String[][][] building = new String[L][R][C];
	    for(int l=0;l<L;l++) {
	        for(int r=0;r<R;r++) {
	            building[l][r] = br.readLine().split("");
	        }
	        br.readLine();
	    }
	    return building;
	}
	
	private static int[] findStart(int L, int R, int C, String[][][] building) {
	    for(int l=0;l<L;l++) {
	        for(int r=0;r<R;r++) {
	            for(int c=0;c<C;c++) {
	                if(building[l][r][c].equals("S")) {
	                    return new int[]{l, r, c};
	                }
	            }
	        }
	    }
	    return null;
	}
	
	static int[][] Direction = 
	{{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};
	
	private static int getTime(int L, int R, int C, int[] start, String[][][] building) {
	    Queue<int[]> que = new LinkedList<>();
	    que.add(start);
	    boolean[][][] visited = new boolean[L][R][C];
	    visited[start[0]][start[1]][start[2]] = true;
	    int[][][] time = new int[L][R][C];
	    while(que.size() > 0) {
	        int[] now = que.poll();
	        int nowF = now[0];
	        int nowX = now[1];
	        int nowY = now[2];
	        int nowTime = time[nowF][nowX][nowY];
	        for(int[] dir : Direction) {
	            int nextF = nowF + dir[0];
	            int nextX = nowX + dir[1];
	            int nextY = nowY + dir[2];
	            if(nextF<0 || nextF>=L || nextX<0 || nextX>=R || nextY<0 || nextY>=C) {
	                continue;
	            }
	            if(visited[nextF][nextX][nextY] || building[nextF][nextX][nextY].equals("#")) {
	                continue;
	            }
	            if(building[nextF][nextX][nextY].equals("E")) {
	                return nowTime + 1;
	            }
	            que.add(new int[]{nextF, nextX, nextY});
	            visited[nextF][nextX][nextY] = true;
	            time[nextF][nextX][nextY] = nowTime + 1;
	        }
	    }
	    return 0;
	}
}
