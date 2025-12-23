import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder("");
	    while(true) {
	        String input = br.readLine();
	        if(input.equals("end")) {
	            break;
	        }
	        char[][] board = getBoard(input);
	        sb.append((isVaild(board, countOX(input), getBingoInfo(board))) ? "valid" : "invalid");
	        sb.append("\n");
	    }
	    System.out.print(sb.toString());
	}
	
	private static char[][] getBoard(String str) {
	    char[][] b = new char[3][3];
	    for(int i=0;i<3;i++) {
	        for(int j=0;j<3;j++) {
	            b[i][j] = str.charAt(i*3+j);
	        }
	    }
	    return b;
	}
	
	private static int[] countOX(String str) {
	    int[] count = new int[3];
	    for(char c : str.toCharArray()) {
	        count[(c == 'X') ? 0 : (c == 'O') ? 1 : 2]++;
	    }
	    return count;
	}
	
	private static boolean isVaild(char[][] board, int[] count, boolean[] bingo) {
	    int xCount = count[0];
	    int oCount = count[1];
	    int pCount = count[2];
	    boolean xBingo = bingo[0];
	    boolean oBingo = bingo[1];
	    if(xCount == oCount && !xBingo && oBingo) {
	        return true;
	    }
	    if(xCount-1 == oCount && !oBingo && (xBingo || pCount == 0)) {
	        return true;
	    }
	    return false;
	}
	
	
	private static boolean[] getBingoInfo(char[][] board) {
	    boolean[] bingoInfo = new boolean[2];
        for(int i=0;i<3;i++) {
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][1] != '.') {
                bingoInfo[(board[i][1] == 'X') ? 0 : 1] = true;
            }
            if(board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[1][i] != '.') {
                bingoInfo[(board[1][i] == 'X') ? 0 : 1] = true;
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '.') {
            bingoInfo[(board[1][1] == 'X') ? 0 : 1] = true;
        }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != '.') {
            bingoInfo[(board[1][1] == 'X') ? 0 : 1] = true;
        }
        return bingoInfo;
    }

}