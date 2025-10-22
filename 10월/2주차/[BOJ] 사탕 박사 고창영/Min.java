import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Min {
    static String[][] candy;
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            br.readLine();
            StringTokenizer str = new StringTokenizer(br.readLine());
            r = Integer.parseInt(str.nextToken());
            c = Integer.parseInt(str.nextToken());

            candy = new String[r][c];
            for(int j = 0; j < r; j++) {
                candy[j] = br.readLine().split("");
            }
            System.out.println(getCnt());
        }
    }

    private static int getCnt() {
        int cnt = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(candy[i][j].equals("o")) {
                    if(j + 1 < c && j - 1 >= 0) {
                        if(candy[i][j + 1].equals("<") && candy[i][j - 1].equals(">")) {
                            cnt += 1;
                        }
                    }
                }

                if(candy[i][j].equals("o")) {
                    if(i + 1 < r && i - 1 >= 0) {
                        if(candy[i + 1][j].equals("^") && candy[i - 1][j].equals("v")) {
                            cnt += 1;
                        }
                    }
                }
            }
        }

        return cnt;
    }
}