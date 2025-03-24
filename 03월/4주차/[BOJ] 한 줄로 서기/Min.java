import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Min {
    static int[] line;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 사람 수
        int[] arr = new int[N];
        line = new int[N];
        StringTokenizer str = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }

        for(int i = 0; i < N; i++){
            int idx = arr[i]; // 줄 세울 사람 위치
            int chance = arr[i];
            while(true){
                if(line[idx] != 0){ // 줄 세울 위치에 이미 다른 사람이 세워져 있을 경우
                    while(line[idx] != 0){ // 빈 곳이 나올 때 까지
                        idx += 1;
                    }
                }
                if(!checkHeight(chance, idx)){ // idx 위치에 줄 세울 수 있는지
                    idx += 1;
                }else{
                    break;
                }
                  
            }
            line[idx] = i + 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int l : line){
            sb.append(String.valueOf(l)).append(" ");
        }
        System.out.println(sb);
    }

    public static boolean checkHeight(int chance, int idx){
        int cnt = 0;
        for(int i = 0; i < idx; i++){
            if(line[i] == 0) cnt++; // 빈 칸 개수
        }

        return cnt == chance ? true : false; // 원래 있어야할 빈 칸 개수와 비교
    }
}
