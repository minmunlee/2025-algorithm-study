import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Min {
    static boolean[] visited;
    static List<ArrayList<Integer>> list;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        list = new ArrayList<>();
        int[] cnt = new int[N + 1];
        List<Integer> answer = new LinkedList<>();
        int max = 0;

        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            list.get(b).add(a);
        }

        for(int i = 1; i <= N; i++){
            cnt[i] = bfs(i);
            if(cnt[i] > max){
                answer.clear();
                answer.add(i);
                max = cnt[i];
            }else if(cnt[i] == max){
                answer.add(i);
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int i : answer){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static int bfs(int start){
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int idx = queue.poll();
            for(int i : list.get(idx)){
                if(!visited[i]){
                    cnt++;
                    visited[i] = true;
                    queue.offer(i);
                }
            }
            
        }
        return cnt;
    }
}