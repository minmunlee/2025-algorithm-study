import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Min {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        int[] children  = new int[N];
        int[] arr = new int[N - 1];

        str = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < children.length; i++){
            children[i] = Integer.parseInt(str.nextToken());
        }
        int price = 0;

        for(int i = 0; i < N - 1; i++){
            arr[i] = children[i + 1] - children[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < N - K; i++){
            price += arr[i];
        }
        
        System.out.println(price);
    }
}