import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer str = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for(int j = 0; j < N; j++){
                arr[j] = Integer.parseInt(str.nextToken());
            }

            int max = 0;
            long profit = 0;
            for(int j = N - 1; j >= 0; j--){
                if(max < arr[j]){
                    max = arr[j];
                }else{
                    profit += max - arr[j];
                }
            }
            System.out.println(profit);
        }  
    }
}
    
