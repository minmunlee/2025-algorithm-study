import java.util.*;

class Min {
    static int cnt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] miro;
    static int[] start;
    static int n, m;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        miro = new String[n][m];
        start = new int[2];
        
        for(int i = 0; i < miro.length; i++){
            String[] map = maps[i].split("");
            for(int j = 0; j < map.length; j++){
                miro[i][j] = map[j];
                if(map[j].equals("S")){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        cnt = 0;
        move("L");
        
        if(cnt == 0) return -1;
        int answer = cnt;
        move("E");
        return answer == cnt ? -1 : cnt;
    }
    
    public static void move(String target){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int[][] dis = new int[n][m];
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx < n && nx >= 0 && ny < m && ny >= 0){
                    if(!visited[nx][ny] && !miro[nx][ny].equals("X")){
                        if(miro[nx][ny].equals(target)){
                            if(target.equals("L")) start = new int[]{nx, ny};
                            cnt += dis[x][y] + 1;
                            return;
                        }
                        dis[nx][ny] = dis[x][y] + 1;
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
                
            }
        }
    }
}