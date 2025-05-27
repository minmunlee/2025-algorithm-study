import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] work = new boolean[1321];
        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int start = Math.max(getTime(str.nextToken(), -10), 600);
            int end = Math.min(getTime(str.nextToken(), 10), 1320);
            for (int j = start; j < end; j++) {
                work[j] = true;
            }
        }

        int max = 0;
        int rest = 0;

        for (int t = 600; t < 1320; t++) {
            if (!work[t]) {
                rest++;
                max = Math.max(max, rest);
            } else {
                rest = 0;
            }
        }

        System.out.println(max);
    }

    private static int getTime(String s, int time) {
        int h = Integer.parseInt(s.substring(0, 2));
        int m = Integer.parseInt(s.substring(2)) + time;

        if(m < 0){
            h -= 1;
            m += 60;
        }else if(m > 59){
            h += 1;
            m -= 60;
        }
        return h * 60 + m;
    }
}
