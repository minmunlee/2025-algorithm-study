import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /**
         * k (0~9)
         * 각 k로 시작하는 N자리 수의 경우의 수를 저장, dp[N-1][k]
         * ex) dp[0][0] = 1  => 0으로 시작하는 수 중 1(N)자리 수 {0} 총 1개.
         * ex) dp[1][0] = 10  => 0으로 시작하는 수 중 2(N)자리 수 {00, 01, 02, 03, ... 09}로 총 10개.
         */
        long[][] dp = new long[N + 1][10];

        for (int i = 0; i <= 9; i++) { // 한자리수로 만들 수 있는 경우의 수 무조건 1
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) { // N자리 수까지 dp 배열 채워나감.
            for (int k = 0; k <= 9; k++) {
                for (int p = k; p <= 9; p++) {
                    dp[i][k] += dp[i - 1][p];
                    dp[i][k] %= 10007;
                }
            }
        }

        System.out.print(dp[N][0] % 10007);
    }
}
