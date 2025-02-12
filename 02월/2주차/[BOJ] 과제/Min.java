import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]); // 마감 시간 기준 오름차순

        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 점수 높은 순
        for (int[] tmp : arr) {
            queue.add(tmp[1]);
            if (queue.size() > tmp[0]) { // 마감 시간 넘었을 경우
                queue.poll();
            }
        }

        int score = 0;
        while (!queue.isEmpty()) {
            score += queue.poll();
        }

        System.out.println(score);
    }
}