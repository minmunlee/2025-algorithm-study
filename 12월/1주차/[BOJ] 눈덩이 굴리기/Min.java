import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static int N, M, answer;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        answer = 0;

        str = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        bt(1, 0, 1);
        if(N > 1) bt(1, 1, 0);

        System.out.println(answer);

    } 
    
    private static void bt(int time, int idx, int size) {
        size += arr[idx];

        if(time == M) {
            answer = Math.max(answer, size);
            return;
        }

        if(idx == N - 1) {
            answer = Math.max(answer, size);
            return;
        }

        if(idx + 1 < N) {
            bt(time + 1, idx + 1, size);
        }

        if(idx + 2 < N) {
            bt(time + 1, idx + 2, size / 2);
        }
    }
}
