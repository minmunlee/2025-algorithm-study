import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer str;
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(str.nextToken());
            int destination = Integer.parseInt(str.nextToken());
            int cost = Integer.parseInt(str.nextToken());

            list.get(departure).add(new int[]{destination, cost});
        }

        str = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(str.nextToken());
        int end = Integer.parseInt(str.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        boolean[] visited = new boolean[N + 1];

        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int city = tmp[0];
            int money = tmp[1];
            if(city == end) {
                System.out.println(money);
                return;
            }

            if(!visited[city]) {
                visited[city] = true;
                for(int[] arr : list.get(city)) {
                    pq.offer(new int[]{arr[0], arr[1] + money});
                }
            }
        }
        
    }
}
