import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Min {
    static boolean[] visited;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int max = 0;
        int answer = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            cnt = 0;
            visited[i] = true;
            cnt += 1;
            int ask = dfs(i);
            if(ask > max) {
                max = ask;
                answer = i + 1;
            }
        }

        System.out.println(answer);
    }

    public static int dfs(int start) {
        int num = arr[start];

        if(!visited[num]) {
            cnt += 1;
            visited[num] = true;
            dfs(num);
        }

        return cnt;
    }
}