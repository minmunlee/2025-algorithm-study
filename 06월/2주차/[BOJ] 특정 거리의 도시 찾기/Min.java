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
    static int K, cnt;
    static List<ArrayList<Integer>> list;
    static List<Integer> answer;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        K = Integer.parseInt(str.nextToken()); // 거리 정보
        int X = Integer.parseInt(str.nextToken()); // 출발 도시
        cnt = 0;

        distance = new int[N + 1];
        answer = new ArrayList<>();
        visited = new boolean[N + 1];
        list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            list.get(a).add(b);
        }

        bfs(X);
        Collections.sort(answer);
        for(int i : answer){
            System.out.println(i);
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i : list.get(tmp)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                    distance[i] = distance[tmp] + 1;
                    if(distance[i] == K) answer.add(i);
                }
            }
        }
        if(answer.isEmpty()) answer.add(-1);
        
    }
}