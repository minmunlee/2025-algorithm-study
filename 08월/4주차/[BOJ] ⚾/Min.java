import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    static int[] order;
    static int[][] inn;
    static boolean[] visited;
    static int max;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inn = new int[N][9];
        order = new int[9];
        visited = new boolean[9];
        for(int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                inn[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        order[3] = 0;
        visited[0] = true;

        dfs(0);
        System.out.println(max);
    }

    public static void dfs(int idx) {
        if(idx == 9) {
            max = Math.max(max, getScore());
            return;
        }

        if(idx == 3) {
            dfs(idx + 1);
        }else {
            for(int i = 0; i < 9; i++) {
                if(!visited[i]) {
                    order[idx] = i;
                    visited[i] = true;

                    dfs(idx + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static int getScore() {
        int idx = 0;
        int score = 0;
    
        for (int i = 0; i < N; i++) {
            int out = 0;
            boolean[] ground = new boolean[3];
    
            while (out < 3) {
                int player = order[idx];
                int result = inn[i][player];
    
                if (result == 0) {
                    out++;
                } else {
                    for (int j = 2; j >= 0; j--) {
                        if (ground[j]) {
                            ground[j] = false;
                            if (j + result >= 3) {
                                score++;
                            } else {
                                ground[j + result] = true;
                            }
                        }
                    }
    
                    if (result == 4) {
                        score++;
                    } else {
                        ground[result - 1] = true;
                    }
                }
    
                idx++;
                if(idx == 9) idx = 0;
            }
        }
    
        return score;
    }
}