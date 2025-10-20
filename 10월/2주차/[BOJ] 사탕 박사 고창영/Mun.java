import java.io.*;

public class Mun {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            br.readLine();
            String[] rc = br.readLine().split(" ");
            int r = Integer.parseInt(rc[0]);
            int c = Integer.parseInt(rc[1]);

            char[][] box = new char[r][c];
            for (int i=0;i<r;i++) {
                box[i] = br.readLine().toCharArray();
            }

            int count = 0;
            for(int i=0;i<r;i++) {
                for(int j=0;j<c;j++) {
                    if (box[i][j] != 'o') {
                        continue;
                    }
                    if (j-1 >= 0 && j+1 < c && box[i][j-1] == '>' && box[i][j+1] == '<') {
                        count++;
                    }
                    if (i-1 >= 0 && i+1 < r && box[i-1][j] == 'v' && box[i+1][j] == '^') {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb.toString());
    }
}