import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Min{
    static String[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashSet<String> hs;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[5][5];
        hs = new HashSet<>();

        for(int i = 0; i < 5; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = str.nextToken();
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(i, j, arr[i][j]);
            }
        }
        System.out.println(hs.size());
        
    }

    public static void dfs(int x , int y, String s){
        if(s.length() == 6){
            hs.add(s);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5){
                dfs(nx, ny, s + arr[nx][ny]);
            }
        }
    }
}