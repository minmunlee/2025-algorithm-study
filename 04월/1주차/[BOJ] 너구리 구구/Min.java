import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Min {
    static long[][] arr;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N  = Integer.parseInt(br.readLine());
        arr = new long[N + 1][N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < N - 1; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(str.nextToken());
            int B = Integer.parseInt(str.nextToken());
            int C = Integer.parseInt(str.nextToken());
            arr[A][B] = C;
            arr[B][A] = C;
        }


        System.out.println(bfs(1));
    }
    public static long bfs(int start){
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{start, 0});
        visited[start] = true;
        long max = 0;
    
        while (!queue.isEmpty()) {
            long[] cur = queue.poll();
            int node = (int)cur[0];
            long dis = cur[1];

            max = Math.max(max, dis);
            for(int i = 1; i <= N; i++){
                if (!visited[i] && arr[node][i] > 0) {
                    visited[i] = true;
                    queue.offer(new long[]{i, dis + arr[node][i]});
                }
            }
        }
        return max;
    }
}