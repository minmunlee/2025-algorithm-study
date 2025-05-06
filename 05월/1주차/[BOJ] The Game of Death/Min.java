import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int cnt = 0;
            int idx = 0;
            for(int j = 0; j < N; j++){
                arr[j] = Integer.parseInt(br.readLine());
            }

            while(true){
                cnt++;
                idx = arr[idx] - 1; // 지목 한 사람
                if(N - 1 == idx){
                    System.out.println(cnt);
                    break;
                }
                if(cnt >= N){
                    System.out.println(0);
                    break;
                }
            }
        }
    }
}
