import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                tri[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        dp[1][1] = tri[1][1];

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                if(j == 1){ // 왼쪽 끝
                    dp[i][j] = dp[i - 1][1] + tri[i][j];
                }else if(j == i){ // 오른쪽 끝
                    dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + tri[i][j], dp[i - 1][j] + tri[i][j]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(max, dp[n][i]);
        }

        System.out.println(max);

    }
}