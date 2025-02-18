import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mqueue = new PriorityQueue<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num > 1) {
                pqueue.add(num);
            }else if(num == 1){
                sum += 1;
            }
            else {
                mqueue.add(num);
            }
        }

        if(!pqueue.isEmpty()){
            sum += calculatequeue(pqueue);
        }
        if(!mqueue.isEmpty()){
            sum += calculatequeue(mqueue);
        }
        
        System.out.println(sum);
    }

    public static int calculatequeue(PriorityQueue<Integer> pqueue){
        int sum = 0;
        if(pqueue.size() % 2 == 0){
            while (!pqueue.isEmpty()) {
                sum += pqueue.poll() * pqueue.poll();
            }
        }else{
            while(pqueue.size() > 1){
                sum += pqueue.poll() * pqueue.poll();
            }
            sum += pqueue.poll();
        }
        return sum;
    }
}
