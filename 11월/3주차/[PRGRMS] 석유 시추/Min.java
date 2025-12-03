import java.util.*;

class Min {
    static boolean[][] visited;
    static int sum, width, height;
    public int solution(int[][] land) {
        int answer = 0;
        width = land[0].length;
        height = land.length;
        
        for(int i = 0; i < width; i++) {
            visited = new boolean[height][width];
            sum = 0;
            for(int j = 0; j < height; j++) {
                if(land[j][i] == 1 && !visited[j][i]) {
                    sum += 1;
                    getArea(land, j, i);
                }
            }
            answer = Math.max(sum, answer);
        }
        return answer;
    }
    
    private static void getArea(int[][] land, int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        queue.offer(new int[]{x, y});
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                
                if(isInArea(nx, ny) && !visited[nx][ny] && land[nx][ny] == 1) {
                    sum += 1;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    private static boolean isInArea(int x, int y) {
        if(x >= 0 && x < height && y >= 0 && y < width) return true;
        return false;
    }
}