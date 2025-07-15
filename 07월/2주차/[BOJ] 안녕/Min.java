import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    static int[] lose, happy;
    static int N, max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lose = new int[N];
        happy = new int[N];
        max = 0;

        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            lose[i] = Integer.parseInt(str.nextToken());
        }
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            happy[i] = Integer.parseInt(str.nextToken());
        } 

        dfs(0, 100, 0);
        System.out.println(max);
    }

    public static void dfs(int index, int hp, int happySum) {
        if(hp <= 0) return;

        if(N == index) {
            max = Math.max(happySum, max);
            return;
        }

        dfs(index + 1, hp, happySum);
        dfs(index + 1, hp - lose[index], happySum + happy[index]);
    }
}
