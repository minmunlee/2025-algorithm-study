import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int K = Integer.parseInt(br.readLine());
	    int[][] board = new int[N+1][N+1];
	    for(int i=0;i<K;i++) {
	        String[] apple = br.readLine().split(" ");
	        int a1 = Integer.parseInt(apple[0]);
	        int a2 = Integer.parseInt(apple[1]);
	        board[a1][a2] = 1;
	    }
	    int L = Integer.parseInt(br.readLine());
	    String[] changeDir = new String[10001];
	    for(int i=0;i<L;i++) {
	        String[] change = br.readLine().split(" ");
	        int X = Integer.parseInt(change[0]);
	        changeDir[X] = change[1];
	    }
	    Queue<int[]> body = new LinkedList<>();
	    body.add(new int[]{1, 1});
	    board[1][1] = 2;
	    int x = 1;
	    int y = 1;
	    int time = 0;
	    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	    int d = 0;
	    while(true) {
	        time++;
	        int nx = x + dir[d][0];
	        int ny = y + dir[d][1];
	        if(nx < 1 || nx > N || ny < 1 || ny > N || board[nx][ny] == 2) {
	            break;
	        }
	        if(board[nx][ny] == 1) {
	            board[nx][ny] = 0;
	        } else {
	            int[] tail = body.poll();
	            board[tail[0]][tail[1]] = 0;
	        }
	        body.add(new int[]{nx, ny});
	        board[nx][ny] = 2;
	        x = nx;
	        y = ny;
	        if(changeDir[time] == null) {
	            continue;
	        } else if(changeDir[time].equals("L")) {
	            d = (d == 0) ? 3 : d - 1;
	        } else if(changeDir[time].equals("D")) {
	            d = (d == 3) ? 0 : d + 1;
	        }
	    }
	    System.out.print(time);
	}
}