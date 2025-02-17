import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] nums = new long[N];
		for(int i=0;i<N;i++){
		    nums[i] = Long.parseLong(br.readLine());
		}
		nums = Arrays.stream(nums)
		             .boxed().sorted(Comparator.reverseOrder())
		             .mapToLong(Long::longValue)
		             .toArray();
		long sum = 0;
		boolean haveZero = false;
		int minusEnd = N;
		for(int i=0;i<N;i++) {
		    if(nums[i]<0) {
		        minusEnd = i;
		        break;
		    } else if(haveZero) {
		        continue;
		    } else if(nums[i]==0) {
		        haveZero = true;
		    } else if(nums[i]==1 || i+1==N || nums[i+1]<=1) {
		        sum+=nums[i];
		    } else {
		        sum+=(nums[i]*nums[i+1]);
		        i++;
		    }
		}
		int minusStart = N - 1;
		for(int i=minusStart;i>=minusEnd;i--) {
		    if(i>minusEnd) {
		        sum+=(nums[i]*nums[i-1]);
		        i--;
		    } else if(!haveZero) {
		        sum+=(nums[i]);
		    }
		}
		System.out.print(sum);
	}
}