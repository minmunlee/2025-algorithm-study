class Min {
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int area;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        area = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea += 1;
                    dfs(i, j, picture);
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                area = 0;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private void dfs(int x, int y, int[][] picture) {
        visited[x][y] = true;
        area += 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx >= 0 && nx < picture.length && ny >= 0 && ny < picture[0].length) {
                if(!visited[nx][ny] && picture[nx][ny] == picture[x][y]) {
                    dfs(nx, ny, picture);
                }
            }
        }
    }
}