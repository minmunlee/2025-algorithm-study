import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Min {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][N];
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder()); 
        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Long.parseLong(str.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                queue.add(arr[i][j]);
            }
        }

        for(int i = 0; i < N - 1; i++){
            queue.poll();
        }

        System.out.println(queue.peek());
    }
}