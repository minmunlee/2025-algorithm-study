import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if(s.equals("end")) return;

            String[][] board = new String[3][3];
            String[] arr = s.split("");
            int xCnt = 0;
            int oCnt = 0;
            int idx = 0;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    board[i][j] = arr[idx];

                    if(arr[idx].equals("X")) {
                        xCnt += 1;
                    }else if(arr[idx].equals("O")){
                        oCnt += 1;
                    }
                    idx += 1;
                }
            }

            if(!(xCnt == oCnt || xCnt == oCnt + 1)) {
                System.out.println("invalid");
                continue;
            } 

            boolean xWin = isWin(board, "X");
            boolean oWin = isWin(board, "O");

            if(xWin && oWin) {
                System.out.println("invalid");
                continue;
            }

            if(xWin && xCnt == oCnt + 1) {
                System.out.println("valid");
            } else if(oWin && xCnt == oCnt) {
                System.out.println("valid");
            } else if(!xWin && !oWin && xCnt + oCnt == 9) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }
    
    private static boolean isWin(String[][] board, String s) {
        for(int i = 0; i < 3; i++) {
            if(board[i][0].equals(s) && board[i][1].equals(s) && board[i][2].equals(s)) return true;
        }
        for(int i = 0; i < 3; i++) {
            if(board[0][i].equals(s) && board[1][i].equals(s) && board[2][i].equals(s)) return true;
        }

        if(board[0][0].equals(s) && board[1][1].equals(s) && board[2][2].equals(s)) return true;
        if(board[0][2].equals(s) && board[1][1].equals(s) && board[2][0].equals(s)) return true;

        return false;
    }
}
