import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Min {
    static boolean[] visited;
    static int[] stone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 돌 ㄱ개수
        StringTokenizer str = new StringTokenizer(br.readLine());
        stone = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            stone[i] = Integer.parseInt(str.nextToken());
        }

        int s = Integer.parseInt(br.readLine()) - 1; // 출발점

        bfs(s, n);

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) cnt++;
        }

        System.out.println(cnt);
    }

    public static void bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            int right = current + stone[current];
            if (right >= 0 && right < n && !visited[right]) {
                queue.offer(right);
                visited[right] = true;
            }

            int left = current - stone[current];
            if (left >= 0 && left < n && !visited[left]) {
                queue.offer(left);
                visited[left] = true;
            }
        }
    }
}