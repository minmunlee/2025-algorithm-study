import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!isCycleWordExists(words, word)) {
                words.add(word);
            }
        }

        System.out.println(words.size());
    }

    public static boolean isCycleWordExists(List<String> words, String word) {
        for (String w : words) {
            if (isCycle(w, word)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        String combine = word1 + word1;
        return combine.contains(word2);
    }
}