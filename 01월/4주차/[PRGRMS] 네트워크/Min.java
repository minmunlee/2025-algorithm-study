class Min {
    static int num;
    static boolean[] visited;;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(n, i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public static void dfs(int n, int node, int[][] computers){
        visited[node] = true;
        for(int i = 0; i < n; i++){
            if(computers[node][i] == 1 && !visited[i]){
                dfs(n, i, computers);
            }
        }
    }
}