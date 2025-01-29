import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int L = Integer.parseInt(str.nextToken()); // 테이프 길이

        List<Integer> list = new ArrayList<>(); // 물 새는 위치
        str = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(str.nextToken()));
        }

        Collections.sort(list);

        int cnt = 0; // 필요한 테이프 개수
        int tape = 0; // 테이프 끝 위치

        for (int l : list) {
            if (l > tape) {
                cnt++;
                tape = l + L - 1;
            }
        }

        System.out.println(cnt);
    }
}