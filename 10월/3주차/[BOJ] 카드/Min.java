import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = N; i >= 1; i--) {
            deque.addFirst(i);
            for (int j = 0; j < i; j++) {
                deque.addFirst(deque.removeLast());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : deque) sb.append(x).append(" ");
        System.out.println(sb);
    }
}