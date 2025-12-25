import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxCnt = 0;
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        if(N == 1) {
            int num = Integer.parseInt(br.readLine());
            System.out.println(num);
            System.out.println(num);
            System.out.println(num);
            System.out.println(0);
            return;
        }

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            int cnt = hm.getOrDefault(num, 0) + 1;
            if(cnt > maxCnt) {
                maxCnt = cnt;
                list.clear();
                list.add(num);
            } else if(cnt == maxCnt) {
                list.add(num);
            }
            hm.put(num, cnt);
        }

        Arrays.sort(arr);
        int avg = (int)Math.round((double) sum / N);
        System.out.println(avg);
        
        int mid = arr[N / 2];
        System.out.println(mid);

        Collections.sort(list);
        if(list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            System.out.println(list.get(1));
        }

        System.out.println(arr[N - 1] - arr[0]);
    }    
}
