import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        if(arr.length == 2){
            list.add(arr[1] - arr[0]);
            cnt = 1;
        }else{
            for(int k = 1; k <= arr.length / 2; k++){
                int n = arr[0 + k] - arr[0];
                boolean check = false;
                for(int i = 1; i < arr.length - k; i++){
                    if(((i - k >= 0) && n == arr[i - k] - arr[i]) || n == arr[i + k] - arr[i]){
                        check = true;
                        break;
                    }
                }
                
                if(check) {
                    list.add(n);
                    cnt++;
                }
            }
        }
        
        Collections.sort(list);
        if(list.isEmpty()){
            System.out.println(0);
        }else{
            for(int i : list){
                sb.append(i).append(" ");
            }
            System.out.println(cnt);
            System.out.println(sb.toString());
        }
    }
    
}
