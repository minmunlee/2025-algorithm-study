import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        int[] parking = new int[N];
        for(int i = 0; i < N; i++) {
            parking[i] = Integer.parseInt(br.readLine());
        }
        int[] car = new int[M + 1];
        for(int i = 1; i <= M; i++) {
            car[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 1; i <= M; i++) {
            hm.put(i, car[i]);
        }

        int cost = 0;
        int[] current = new int[N];
        Queue<Integer> wait = new LinkedList<>();
        for(int i = 0; i < M * 2; i++) {
            boolean isFull = true;
            int idx = Integer.parseInt(br.readLine());
            if(idx > 0) {
                for(int j = 0; j < N; j++) {
                    if(current[j] == 0) {
                        current[j] = idx;
                        isFull = false;
                        break;
                    }
                }
                if(isFull) {
                    wait.offer(idx);
                }
            } else if(idx < 0) {
                idx = idx * -1;
                for(int j = 0; j < N; j++) {
                    if(current[j] == idx) {
                        cost += hm.get(current[j]) * parking[j];
                        current[j] = 0;
                        if(!wait.isEmpty()) {
                            current[j] = wait.poll();
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(cost);

    }
}
