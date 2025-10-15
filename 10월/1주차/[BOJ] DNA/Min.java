import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Min {
    static String[][] dna;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());

        dna = new String[N][M];

        for(int i = 0; i < N; i++) {
            dna[i] = br.readLine().split("");
        }

        String answer = "";
        for(int i = 0; i < M; i++) {
            answer += getLetter(i, N);
        }

        int diff = 0;
        String[] ans = answer.split("");
        for(int i = 0; i < N; i++) {
            diff += getDiff(ans, i, M);
        }

        System.out.println(answer);
        System.out.println(diff);
        
    }   

    private static String getLetter(int idx, int N) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("A", 0);
        hm.put("C", 0);
        hm.put("G", 0);
        hm.put("T", 0);

        for(int i = 0; i < N; i++) {
            hm.put(dna[i][idx], hm.get(dna[i][idx]) + 1);
        }

        int max = 0;
        String[] words = {"A", "C", "G", "T"};
        String letter = "";

        for(String word : words) {
            if(max < hm.get(word)) {
                max = hm.get(word);
                letter = word;
            }
        }
        return letter;
    }

    private static int getDiff(String[] s, int idx, int M) {
        String[] compare = dna[idx];
        int cnt = 0;

        for(int i = 0; i < M; i++) {
            if(!compare[i].equals(s[i])) {
                cnt += 1;
            }
        }

        return cnt;
    }

}
