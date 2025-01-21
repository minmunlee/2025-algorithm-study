import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int[] arr = new int[M];

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int price = 0;
        int profit = 0;

        for (int i = 0; i < M; i++) {
            int num = arr[i];
            int sum = 0;
            int count = Math.min(N, M - i); // 가격 별 팔 수 있는 최대 수량

            sum = num * count;

            if (profit < sum) {
                profit = sum;
                price = num;
            }
        }

        System.out.println(price + " " + profit);
    }
}