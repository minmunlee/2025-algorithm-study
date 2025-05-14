import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken()); // 문서 개수
            int M = Integer.parseInt(str.nextToken()); // 현재 문서가 놓인 순서
            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 중요도 담을 큐

            str = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(str.nextToken());
                queue.offer(new int[]{priority, j}); // {중요도, 순서}
                pq.offer(priority);
            }

            int answer = 0;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                if (cur[0] == pq.peek()) {
                    answer++;
                    pq.poll();
                    if (cur[1] == M) { 
                        System.out.println(answer);
                        break;
                    }
                } else {
                    queue.offer(cur);
                }
            }
        }
    }
}
