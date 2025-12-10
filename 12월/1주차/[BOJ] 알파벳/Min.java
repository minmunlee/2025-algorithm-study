import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    static char[][] board;
    static int R, C;
    static int answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        R = Integer.parseInt(str.nextToken());
        C = Integer.parseInt(str.nextToken());
        board = new char[R][C];
        visited = new boolean[26];
        for(int i = 0; i < R; i ++) {
            board[i] = br.readLine().toCharArray();
        }

        answer = 1;
        visited[board[0][0] - 'A'] = true;
        getMove(0, 0, 1);
        System.out.println(answer);
    }   
    
    private static void getMove(int x, int y, int size) {
        answer = Math.max(answer, size);
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!isInBoard(nx, ny) || visited[board[nx][ny] - 'A']) continue;

            visited[board[nx][ny] - 'A'] = true;
            getMove(nx, ny, size + 1);
            visited[board[nx][ny] - 'A'] = false;
        }
    }

    private static boolean isInBoard(int x, int y) {
        if(x >= 0 && x < R && y >= 0 && y < C) return true;
        return false;
    }
}
