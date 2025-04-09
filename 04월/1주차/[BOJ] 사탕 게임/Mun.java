import java.io.*;

public class Mun {
    
    static int max = 1;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    char[][] board = new char[N][N];
	    for(int i=0;i<N;i++) {
	        String input = br.readLine();
	        for(int j=0;j<N;j++) {
	            board[i][j] = input.charAt(j);
	        }
	    }
	    for(int i=0;i<N;i++) {
	        for(int j=0;j<N-1;j++) {
	            char now1 = board[i][j];
	            if(now1 != board[i][j+1]) {
	                board[i][j] = board[i][j+1];
	                board[i][j+1] = now1;
	                exp(N, board);
	                board[i][j+1] = board[i][j];
	                board[i][j] = now1;
	            }
	            char now2 = board[j][i];
	            if(now2 != board[j+1][i]) {
	                board[j][i] = board[j+1][i];
	                board[j+1][i] = now2;
	                exp(N, board);
	                board[j+1][i] = board[j][i];
	                board[j][i] = now2;
	            }
	        }
	    }
	    System.out.print(max);
	}
	
	public static void exp(int N, char[][] board) {
	    for(int i=0;i<N;i++) {
	        for(int j=0;j<N;j++) {
	            char point = board[i][j];
	            int linked = 1;
	            while(j < N - 1) {
	                if(point == board[i][++j]) {
	                    linked++;
	                } else {
	                    j--;
	                    break;
	                }
	            }
	            if(linked > max) {
	                max = linked;
	            }
	        }
	        for(int j=0;j<N;j++) {
	            char point = board[j][i];
	            int  linked = 1;
	            while(j < N - 1) {
	                if(point == board[++j][i]) {
	                    linked++;
	                } else {
	                    j--;
	                    break;
	                }
	            }
	            if(linked > max) {
	                max = linked;
	            }
	        }
	    }
	}
}