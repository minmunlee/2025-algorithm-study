import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = 0; i < n; i++) {
            dp[i] = 1;

            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            cnt = Math.max(cnt, dp[i]);
        }

        System.out.println(cnt);
    }    
}
