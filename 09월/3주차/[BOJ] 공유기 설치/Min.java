import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Min {
    static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken()); // 집 개수
        int C = Integer.parseInt(str.nextToken()); // 공유기 개수
        house = new int[N];

        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int min = 1;
        int max = house[N - 1] - house[0] + 1;

        while(min < max) {
            int mid = (max + min) / 2; // 임의의 최소 거리
            int cnt = getCnt(mid);

            if(cnt < C) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
    
    private static int getCnt(int mid) {
        int cnt = 1;
        int cur = house[0];

        for(int i = 1; i < house.length; i++) {
            int dis = house[i] - cur;

            if(dis >= mid) {
                cnt++;
                cur = house[i];
            }
        }

        return cnt;
    }
}
