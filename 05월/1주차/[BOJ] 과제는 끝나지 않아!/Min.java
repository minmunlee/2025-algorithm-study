import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int total = 0;

        for(int i = 0; i < N; i++){
            String[] arr = br.readLine().split(" ");
            if(arr[0].equals("1")){
                int a = Integer.parseInt(arr[1]); // 점수
                int b = Integer.parseInt(arr[2]); // 해결 시간
                stack.add(new int[]{a, b - 1});
            }
            if(!stack.isEmpty()){
                int[] tmp = stack.pop();
                int score = tmp[0];
                int end = tmp[1];
                if(--end < 0){
                    total += score;
                }else{
                    stack.add(new int[]{score, end});
                }
            }
        }

        System.out.println(total);
    }
}