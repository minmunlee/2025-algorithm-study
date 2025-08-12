import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(str.nextToken());
        long m = Long.parseLong(str.nextToken());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long sum = 0;

        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(str.nextToken()));
        }

        while(m > 0) {
            long a = pq.poll();
            long b = pq.poll();

            pq.offer(a + b);
            pq.offer(a + b);
            m -= 1;
        }

        while(!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}
