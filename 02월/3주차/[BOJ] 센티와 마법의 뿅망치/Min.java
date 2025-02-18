import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 인구수
        int CH = Integer.parseInt(str.nextToken()); // 센티의 키
        int T = Integer.parseInt(str.nextToken()); // 횟수 제한
        int cnt = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < N; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        while (T > 0 && !queue.isEmpty()) {
            int hit = queue.poll();

            if (hit < CH) {
                queue.add(hit);
                break;
            }

            if (hit == 1) {
                queue.add(1);
                break;
            }

            queue.add(hit / 2);
            cnt++;
            T--;
        }

        if(queue.peek() < CH){
            System.out.println("YES");
            System.out.println(cnt);
        }else{
            System.out.println("NO");
            System.out.println(queue.peek());
        }
    }
}
