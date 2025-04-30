import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Min {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(str.nextToken());
        int W = Integer.parseInt(str.nextToken());
        int arr[] = new int[W];
        str = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        
        int answer = 0;
        int left = 0;
        int right = W - 1;
        int leftMax = arr[left];
        int rightMax = arr[right];
        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(arr[left], leftMax);
                answer += leftMax - arr[left];
            }else{
                right--;
                rightMax = Math.max(arr[right], rightMax);
                answer += rightMax - arr[right];
            }
        }
        System.out.println(answer);
    }
}
