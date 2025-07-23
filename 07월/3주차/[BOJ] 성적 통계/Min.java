import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int[] arr = new int[N];
            for(int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(str.nextToken());
            }
            Arrays.sort(arr);
            int gap = 0;
            for(int j = arr.length - 1; j > 0; j--) {
                gap = Math.max(gap, arr[j] - arr[j - 1]);
            }
            System.out.println("Class " + (i + 1));
            System.out.printf("Max %d, Min %d, Largest gap %d", arr[arr.length - 1], arr[0], gap);
            System.out.println();
        }
    }
}