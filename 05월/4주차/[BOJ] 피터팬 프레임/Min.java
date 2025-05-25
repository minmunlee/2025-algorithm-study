import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        int len = X.length();

        StringBuilder[] sb = new StringBuilder[5];
        sb[0] = new StringBuilder(".");
        sb[1] = new StringBuilder(".");
        sb[2] = new StringBuilder("#");
        sb[3] = new StringBuilder(".");
        sb[4] = new StringBuilder(".");

        for (int n = 0; n < len; n++) {
            char word = X.charAt(n);
            int num = n + 1;
            char symbol = '#';

            if (num % 3 == 0) {
                symbol = '*';
                sb[2].setCharAt(sb[2].length() - 1, symbol);
            }

            sb[0].append(".").append(symbol).append("..");
            sb[1].append(symbol).append(".").append(symbol).append(".");
            sb[2].append(".").append(word).append(".").append(symbol);
            sb[3].append(symbol).append(".").append(symbol).append(".");
            sb[4].append(".").append(symbol).append("..");
        }

        for (StringBuilder line : sb) {
            System.out.println(line);
        }
    }
}