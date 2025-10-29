import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int j = 0; j < n; j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr);
            boolean check = true;

            for(int j = 0; j < n - 1; j++) {
                if(arr[j + 1].startsWith(arr[j])){
                    check = false;
                    break;
                }
            }
            if(check) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }    
}
