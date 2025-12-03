import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        int cnt = 0;

        str = new StringTokenizer(br.readLine());
        Integer[] pen = new Integer[N];
        for(int i = 0; i < N; i++) {
            pen[i] = Integer.parseInt(str.nextToken());
        }
        Arrays.sort(pen, (a, b) -> b - a);

        int need = M * K;
        for(int i = 0; i < N; i++) {
            need -= pen[i];
            cnt += 1;
            if(need <= 0) {
                System.out.println(cnt);
                return;
            }
        }
        System.out.println("STRESS");
    }    
}
