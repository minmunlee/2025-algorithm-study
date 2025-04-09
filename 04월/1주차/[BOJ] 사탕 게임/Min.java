import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Min {
    static char[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            arr[i] = s.toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, changeCandy(i, j));
            }
        }

        System.out.println(max);
    }

    public static int changeCandy(int x, int y) {
        char[][] change = new char[N][N];
        for (int i = 0; i < N; i++) {
            change[i] = arr[i].clone();
        }

        int[] sameCnt = {1, 1}; // 0: 아래 개수, 1: 오른쪽 개수

        // 아래로 이동
        int changeX = x + 1;
        if (changeX < N) {
            swap(change, x, y, changeX, y); // 아래 값과 교환
            sameCnt[0] = Math.max(getSameCnt(change, x, y), getSameCnt(change, changeX, y)); // 바꾸기 전과 후 중에 큰거
            swap(change, x, y, changeX, y);
        }

        int changeY = y + 1; // 오른쪽 값과 교환
        if (changeY < N) {
            swap(change, x, y, x, changeY);
            sameCnt[1] = Math.max(getSameCnt(change, x, y), getSameCnt(change, x, changeY));
            swap(change, x, y, x, changeY);
        }

        return Math.max(sameCnt[0], sameCnt[1]);
    }

    public static void swap(char[][] arr, int x1, int y1, int x2, int y2) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    public static int getSameCnt(char[][] candy, int x, int y) {
        char target = candy[x][y];
        int updownCnt = 1, sideCnt = 1;
        int dx = x, dy = y;

        // 위 아래 비교하며 같은거 개수
        while (dx < N - 1 && candy[dx + 1][y] == target) { 
            dx++; 
            updownCnt++; 
        }
        dx = x;
        while (dx > 0 && candy[dx - 1][y] == target) { 
            dx--; 
            updownCnt++; 
        }

        // 양 옆 비교하며 같은거 개수
        while (dy < N - 1 && candy[x][dy + 1] == target) { 
            dy++; 
            sideCnt++; 
        }
        dy = y;
        while (dy > 0 && candy[x][dy - 1] == target) {
             dy--; 
             sideCnt++; 
            }

        return Math.max(sideCnt, updownCnt);
    }
}