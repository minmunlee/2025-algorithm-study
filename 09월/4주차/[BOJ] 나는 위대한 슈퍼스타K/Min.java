import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        int K = Integer.parseInt(str.nextToken());
        double[] maxSkill = new double[N];

        for(int i = 0; i < M; i++) {
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(str.nextToken());
                double score = Double.parseDouble(str.nextToken());
                if(maxSkill[num - 1] < score) {
                    maxSkill[num - 1] = score;
                }
            }
        }
        
        Double sum = 0.0;
        Arrays.sort(maxSkill);
        for(int i = 1; i <= K; i++) {
            sum += maxSkill[maxSkill.length - i];
        }

        System.out.printf("%.1f", sum);
    }
}
