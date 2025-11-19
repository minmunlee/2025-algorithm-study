import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            str = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] arr = new int[N + 1];
        queue.offer(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            for(int n : list.get(num)) {
                if(!visited[n]) {
                    visited[n] = true;
                    arr[n] = num;
                    queue.offer(n);
                }

            }
        }
        for(int i = 2; i <= N; i++) {
            System.out.println(arr[i]);
        }

    }

}