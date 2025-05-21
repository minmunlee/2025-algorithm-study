import java.util.*;

class Min {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] arr;
    static int startX, startY;
    static boolean[][] visited;
    
    public int solution(String[] board) {
        arr = new String[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        startX = 0;
        startY = 0;
        init(board);
        int answer = bfs(startX, startY);
        return answer;
    }
    
    public static void init(String[] board){
        for(int i = 0; i < arr.length; i++){
            String[] tmp = board[i].split("");
            for(int j = 0; j < tmp.length; j++){
                arr[i][j] = tmp[j];
                if(tmp[j].equals("R")){
                    startX = i;
                    startY = j;
                }
            }
        }
    }
    
    public static int bfs(int startX, int startY){
        visited[startX][startY] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int cnt = tmp[2];
            if(arr[x][y].equals("G")){
                return cnt;
            }
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                while(true){
                    if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length 
                       && !arr[nx][ny].equals("D")){
                        nx += dx[i];
                        ny += dy[i];
                    }else{
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                    
                }
                
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return -1;
    }
}