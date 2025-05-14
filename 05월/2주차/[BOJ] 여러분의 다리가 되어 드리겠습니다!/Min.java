import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Min {
    static int N;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < N - 2; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                bfs(i);
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    public static void bfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int i = 0; i < list.get(num).size(); i++){
                int idx = list.get(num).get(i);
                if(!visited[idx]){
                    visited[idx] = true;
                    queue.offer(idx);
                }
            }
        }
    }
}
