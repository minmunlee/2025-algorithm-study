import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        long X = Long.parseLong(str.nextToken()); // 이긴 횟수
        long Y = Long.parseLong(str.nextToken()); // 이긴 게임
        long Z = (100 * Y) / X; // 승률
        long game = -1;

        long left = 0;
        long right = X;
        while(left <= right) {
            long mid = (left + right) / 2;

            if((100 * (Y + mid) / (X + mid) > Z)) {
                game = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(game);
    }    
}
