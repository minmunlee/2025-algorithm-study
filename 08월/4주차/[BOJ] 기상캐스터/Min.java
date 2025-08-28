import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(str.nextToken());
        int W = Integer.parseInt(str.nextToken());
        String[][] area = new String[H][W];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < H; i++) {
            area[i] = br.readLine().split("");
        }

        for(int i = 0; i < H; i++) {
            int cloud = -1;
            for(int j = 0; j < W; j++) {
                if(area[i][j].equals("c")) {
                    sb.append("0").append(" ");
                    cloud = j;
                }else {
                    if(cloud == -1) {
                        sb.append("-1").append(" ");
                    }else {
                        sb.append(String.valueOf(j - cloud) + " ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}