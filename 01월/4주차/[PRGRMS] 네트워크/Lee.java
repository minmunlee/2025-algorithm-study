class Solution {
    static int copy_n;
    static int[][] copy_computers;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        copy_n = n;
        copy_computers = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int i) {
        for (int k = 0; k < copy_n; k++) {
            if (i == k || copy_computers[i][k] != 1 || visited[k]) {
                continue;
            }
            visited[k] = true; // 방문했다고 체크
            dfs(k);
        }
    }
}
