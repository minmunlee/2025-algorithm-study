import java.io.*;
import java.util.*;

public class Mun {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < 10; i++) {
            dfs(i, i);
        }
        Collections.sort(list);
        if (N > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N - 1));
        }
    }

    private static void dfs(long num, int last) {
        list.add(num);
        for (int next=0;next<last;next++) {
            dfs(num * 10 + next, next);
        }
    }
}
