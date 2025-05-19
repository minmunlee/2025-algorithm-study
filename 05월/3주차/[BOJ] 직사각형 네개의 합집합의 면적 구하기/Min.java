import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] area = new boolean[101][101];
        int answer = 0;
        for(int i = 0; i < 4; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(str.nextToken());
            int leftY = Integer.parseInt(str.nextToken());
            int rightX = Integer.parseInt(str.nextToken());
            int rightY = Integer.parseInt(str.nextToken());

            for(int j = leftY; j < rightY; j++){
                for(int k = leftX; k < rightX; k++){
                    area[j][k] = true;
                }
            }
        }

        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(area[i][j]) answer++;
            }
        }

        System.out.println(answer);
    }    
}
