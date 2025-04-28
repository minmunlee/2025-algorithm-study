import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Min {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        StringTokenizer str;
        int cnt = 0;
    
        for(int i = 0; i < 5; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for(int i = 0; i < 5; i++){
            str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                int num = Integer.parseInt(str.nextToken());
                checkNum(num);
                cnt++;
                if (countBingo() >= 3) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }

    public static void checkNum(int num){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(num == arr[i][j]){
                    arr[i][j] = 0;
                    break;
                }
            }
        }
    }

    public static int countBingo() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 0) { // 가로
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) count++;
        }

        for (int j = 0; j < 5; j++) {
            boolean isBingo = true;
            for (int i = 0; i < 5; i++) { // 세로
                if (arr[i][j] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) count++;
        }
    
        boolean isBingo1 = true;
        for (int i = 0; i < 5; i++) { // 오른쪽 대각선
            if (arr[i][i] != 0) {
                isBingo1 = false;
                break;
            }
        }
        if (isBingo1) count++;
    
        boolean isBingo2 = true;
        for (int i = 0; i < 5; i++) { // 왼쪽 대각선
            if (arr[i][4 - i] != 0) {
                isBingo2 = false;
                break;
            }
        }
        if (isBingo2) count++;
    
        return count;
    }
}