class Min {
    public int solution(String[] board) {
        int answer = 0;
        int xCnt = 0;
        int oCnt = 0;
        String[][] tic = new String[3][3];
        for(int i = 0; i < 3; i++) {
            String[] arr = board[i].split("");
            for(int j = 0; j < 3; j++) {
                tic[i][j] = arr[j];
                if(arr[j].equals("X")) {
                    xCnt++;
                } else if(arr[j].equals("O")) {
                    oCnt++;
                }
            }
        }
        
        if(!(xCnt == oCnt || oCnt == xCnt + 1)) {
            return answer;
        }
        
        boolean xWin = win(tic, "X");
        boolean oWin = win(tic, "O");
        
        if (xWin && oWin) {
            return answer;
        }
        
        if((xWin && oCnt == xCnt) || (oWin && xCnt + 1 == oCnt)
          || (!xWin && !oWin)) {
            answer = 1;
            return answer;
        }
        return answer;
    }
    
    private static boolean win(String[][] arr, String s) {
        for(int i = 0; i < 3; i++) {
            if(arr[i][0].equals(s) && arr[i][1].equals(s) && arr[i][2].equals(s)) return true;
        }
        for(int i = 0; i < 3; i++) {
            if(arr[0][i].equals(s) && arr[1][i].equals(s) && arr[2][i].equals(s)) return true;
        }

        if(arr[0][0].equals(s) && arr[1][1].equals(s) && arr[2][2].equals(s)) return true;
        if(arr[0][2].equals(s) && arr[1][1].equals(s) && arr[2][0].equals(s)) return true;
        return false;
    }
    
}