import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int[][] arr1 = new int[N][M];
        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr1[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        str = new StringTokenizer(br.readLine());
        M = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        int[][] arr2 = new int[M][K];
        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++) {
                arr2[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        int[][] answer = new int[N][K];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                for(int k = 0; k < M; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}