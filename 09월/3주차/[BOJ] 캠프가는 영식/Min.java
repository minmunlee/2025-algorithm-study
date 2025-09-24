import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int T = Integer.parseInt(str.nextToken());
        int time = 1000000;
        boolean hasBus = false;
        

        for(int i = 0; i < N; i++) {
            str = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(str.nextToken()); // 버스 시작
            int I = Integer.parseInt(str.nextToken()); // 버스 간격
            int C = Integer.parseInt(str.nextToken()); // 버스 대수

            int tmp = S;
            int wait = 1000000;
            for(int j = 0; j < C; j++) {
                if(T <= tmp) {
                    wait = Math.min(tmp - T, wait);
                    hasBus = true;
                    break;
                }
                tmp += I;
            }

            time = Math.min(wait, time);
        }

        if(hasBus) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }

    }    
}
