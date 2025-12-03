import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        str = new StringTokenizer(br.readLine());
        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(str.nextToken());
            if(N == 1) {
                System.out.println(num);
                return;
            }
            if(num > 0) {
                plus.add(num);
            } else {
                minus.add(Math.abs(num));
            }
        }


        Collections.sort(minus, Comparator.reverseOrder());
        Collections.sort(plus, Comparator.reverseOrder());
        int max = 0;
        if (!minus.isEmpty()) max = Math.max(max, minus.get(0));
        if (!plus.isEmpty()) max = Math.max(max, plus.get(0));
        int answer = getWorkDis(minus, M);
        answer += getWorkDis(plus, M);
        answer -= max;

        System.out.println(answer);

    }

    private static int getWorkDis(List<Integer> list, int M) {
        int sum = 0;
        for(int i = 0; i < list.size(); i += M) {
            sum += list.get(i) * 2;
        }
        return sum;
    }

}
