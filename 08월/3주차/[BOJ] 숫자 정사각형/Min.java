import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Min {
    static List<Integer> space;
    static String[][] square;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        square = new String[N][M];
        space = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            square[i] = br.readLine().split("");
        }

        if(N == 1) {
            System.out.println(1);
        } else {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    getSpace(i, j);
                }
            }
            Collections.sort(space, Collections.reverseOrder());
    
            System.out.println(space.get(0));
        }
    }

    public static void getSpace(int x, int y) {
        String num = square[x][y];
        int garo = 1;
        List<Integer> gList = new ArrayList<>();
        int sero = 1;
        int max = 1;
        for(int i = y + 1; i < M; i++) {
            garo++;
            if(num.equals(square[x][i])) gList.add(garo);
        }

        for(int i = x + 1; i < N; i++) {
            sero++;
            if(num.equals(square[i][y])) {
                if(gList.contains(sero)) {
                    int endX = x + sero - 1;
                    int endY = y + sero - 1;
                    if(endX < N && endY < M && num.equals(square[endX][endY])){
                        max = Math.max(max, sero);
                    }
                }
            }
        }
        space.add(max * max);
    }
}