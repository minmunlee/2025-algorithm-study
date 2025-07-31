import java.util.*;

class Min {
    static String[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i = 0; i < 5; i++) {
            arr = new String[5][5];
            for(int j = 0; j < 5; j++) {
                arr[j] = places[i][j].split("");
            }
            answer[i] = bfs(arr) ? 1 : 0;
        }
        return answer;
    }
    
    public static boolean bfs(String[][] arr) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0 ; j < 5; j++) {
                if(arr[i][j].equals("P")){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j, 0});
                    boolean[][] visited = new boolean[5][5];
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for(int k = 0; k < 4; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];
                            int dis = cur[2];
 
                            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                                if(!visited[nx][ny] ) {
                                    if(dis == 2) continue;
                                    if(arr[nx][ny].equals("P") && dis < 2) {
                                        return false;
                                    }
                                    if(arr[nx][ny].equals("O") && dis < 2) {
                                        queue.offer(new int[]{nx, ny, dis + 1});
                                        visited[nx][ny] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}