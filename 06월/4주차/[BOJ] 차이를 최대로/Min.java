import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Min {
    static int[] arr;
    static int[] newArr;
    static boolean[] visited;
    static int max, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        newArr = new int[N];
        visited = new boolean[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        combine(0);
        System.out.println(max);

    }

    public static void combine(int idx){
        if(idx == N){
            getMax();
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                newArr[idx] = arr[i];
                combine(idx + 1);
                visited[i] = false;
            }
        }
    }

    public static void getMax() {
        int sum = 0;
        for(int i = 0; i < N - 1; i++){
            sum += Math.abs(newArr[i] - newArr[i + 1]);
        }
        max = Math.max(sum, max);
    }

}