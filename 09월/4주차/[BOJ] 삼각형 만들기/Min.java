import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = -1;

        for(int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        while(!pq.isEmpty()) {
            long a = pq.poll();
            long b = pq.poll();
            long c = pq.poll();
            
            if(a < b + c) {
                sum = a + b + c;
                break;
            }

            if(!pq.isEmpty()) {
                pq.offer(b);
                pq.offer(c);
            }
        }

        System.out.println(sum);
    }
}