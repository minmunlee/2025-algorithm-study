import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Min {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(isGood(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean isGood(int idx) {
        int start = 0;
        int end = N - 1;
        int target = arr[idx];

        while(start < end) {
            int tmp = arr[start] + arr[end];
            
            if(start == idx){
                start++;
                continue;
            }

            if(end == idx) {
                end--;
                continue;
            }
            
            if(tmp == target) return true;

            
            if(target > tmp) {
                start++;
            }else if(target < tmp) {
                end--;
            }
        }
        return false;
    }
}
