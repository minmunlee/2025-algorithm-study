import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        if(pq.size() != 1) {
            while(true) {
                int a = pq.poll();
                int b = pq.poll();
                pq.offer(a + b);
                sum += a + b;
                if(pq.size() == 1) break;
            }
        }  
        
        System.out.println(sum);
    }
}
