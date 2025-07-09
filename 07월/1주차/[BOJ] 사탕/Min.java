import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(str.nextToken()); // 사탕의 개수
            int N = Integer.parseInt(str.nextToken()); // 상자의 개수
            List<Integer> box = new ArrayList<>();
            int cnt = 0;

            for(int j = 0; j < N; j++) {
                str = new StringTokenizer(br.readLine());
                int R = Integer.parseInt(str.nextToken());
                int C = Integer.parseInt(str.nextToken());

                box.add(R * C);
            }

            Collections.sort(box, Collections.reverseOrder());

            for(int b : box) {
                if(J <= 0) break;
                J -= b;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}