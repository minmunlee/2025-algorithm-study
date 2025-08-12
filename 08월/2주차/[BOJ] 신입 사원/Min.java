import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for(int j = 0; j < N; j++) {
                String[] str = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(str[0]);
                arr[j][1] = Integer.parseInt(str[1]);
            }
            Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]));
            System.out.println(getCnt(arr));
        }
    }

    public static int getCnt(int[][] arr) {
        int cnt = 1;
        int meet = arr[0][1];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i][1] < meet) cnt++;
            
            meet = Math.min(arr[i][1], meet);
        }

        return cnt;
    }
}