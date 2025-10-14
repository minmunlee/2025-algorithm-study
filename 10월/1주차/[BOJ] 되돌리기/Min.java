import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Re {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] texts = new String[N + 1];
        int[] times = new int[N + 1];

        texts[0] = ""; 
        times[0] = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("type")) {
                String c = st.nextToken();
                int time = Integer.parseInt(st.nextToken());

                texts[i] = texts[i - 1] + c;
                times[i] = time;

            } else { 
                int back = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                int backTime = time - back;

                int idx = i - 1;
                while (idx > 0 && times[idx] >= backTime) {
                    idx--;
                }

                texts[i] = texts[idx];
                times[i] = time;
            }
        }

        System.out.println(texts[N]);
    }
}
