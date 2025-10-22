import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Min {
    static List<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            combine(i);
        }

        Collections.sort(list);

        System.out.println(N > list.size() ? -1 : list.get(N - 1));
    }

    private static void combine(long num) {
        list.add(num);
        long last = num % 10;

        for(long i = 0; i < last; i++) {
            combine(num * 10 + i);
        }
    }
}
