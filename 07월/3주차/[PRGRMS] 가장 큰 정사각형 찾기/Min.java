class Min {
    public int solution(int [][]board){
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        
        if(board.length == 1) {
            for(int i : board[0]) {
                answer = Math.max(i, answer);
            }
        }else{
            for(int i = 1; i < row; i++) {
                for(int j = 1; j < col; j++) {
                    int cur = board[i][j];
                    if(cur == 1) {
                        board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
                        answer = Math.max(answer, board[i][j]);
                    }
                }
        }
        }
        answer = answer * answer;

        return answer;
    }
}