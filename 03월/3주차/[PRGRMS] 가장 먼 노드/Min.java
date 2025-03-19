import java.util.*;

class Min {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static Integer[] distance;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n + 1];
        arr = new ArrayList[n + 1];
        distance = new Integer[n + 1];
        Arrays.fill(distance, 0);
        
        for(int i = 1; i <= n;  i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            arr[a].add(b);
            arr[b].add(a);
        }
        
        bfs(1);
        
        Arrays.sort(distance, Comparator.reverseOrder());
        int max = distance[0];
        for(int i = 0; i < distance.length; i++){
            if(max == distance[i]){
                answer++;
            }else{
                break;
            }
        }
        
        return answer;
    }
    
    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        distance[node] = 0;
        
        while(!q.isEmpty()){
            int current = q.poll();
            
            for(int i = 0; i < arr[current].size(); i++){
                int now = arr[current].get(i);
                if(!visited[now]){
                    visited[now] = true;
                    q.add(now);
                    distance[now] = distance[current] + 1;
                }
            }
        }
    }
}