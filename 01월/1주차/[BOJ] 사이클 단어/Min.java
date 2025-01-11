import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            boolean isCycle = false;
            for (String w : words) {
                if (w.length() == word.length() && (w + w).contains(word)) {
                    isCycle = true;
                    break;
                }
            }
            if (!isCycle) {
                words.add(word);
            }
        }

        System.out.println(words.size());
    }
}