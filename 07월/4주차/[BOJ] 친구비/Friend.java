import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Friend {
    static int N, M, k;
    static int[] cost;
    static List<ArrayList<Integer>> list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        k = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(br.readLine());
        cost = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(str.nextToken());
        }

        list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(str.nextToken());
            int w = Integer.parseInt(str.nextToken());

            list.get(v).add(w);
            list.get(w).add(v);
        }
        int answer = 0;

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                int min = bfs(i);
                answer += min;
            }
        }

        if(answer <= k) {
            System.out.println(answer);
        }else{
            System.out.println("Oh no");
        }
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int min = cost[start];

        while(!queue.isEmpty()) {
            int tmp  = queue.poll();
            for(int i : list.get(tmp)) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    min = Math.min(min, cost[i]);
                }
            }
        }
        return min;
    }
}
