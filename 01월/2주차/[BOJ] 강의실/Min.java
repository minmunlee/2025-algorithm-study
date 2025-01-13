import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Min {
    static int room;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3]; // 강의 번호, 강의 시작 시간, 강의 종료 시간
        room = 1;

        for(int i = 0; i < N; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1])); // 시작 시간 기준 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(arr[0]);

        for (int i = 1; i < N; i++) {
            int[] current = arr[i];
            int[] tmp = pq.peek();
            if (tmp[2] <= current[1]) { // 다음 강의 시작 시간이 현재 강의 종료 시간보다 미래일 경우
                pq.poll();
            } 
            pq.offer(current);
        }

        System.out.println(pq.size());
    }
}