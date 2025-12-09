import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Min {
    static int[] answer;
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        answer = new int[10];
        arr = new int[10];
        cnt = 0;
        for(int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(str.nextToken());
        }
        getCnt(0);
        System.out.println(cnt);

    }

    private static void getCnt(int depth) {
        if(depth == 10) {
            int c = 0;
            for(int i = 0; i < 10; i++) {
                if(arr[i] == answer[i]) c++;
            }

            if(c >= 5) {
                cnt++;
            }
            return;
        }

        for(int i = 1; i <= 5; i++) {
            if(depth >= 2 && arr[depth - 1] == i && arr[depth - 2] == i) continue;
            
            arr[depth] = i;
            getCnt(depth + 1);
        }
    }

}