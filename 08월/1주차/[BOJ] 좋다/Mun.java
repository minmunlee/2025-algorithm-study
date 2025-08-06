import java.io.*;
import java.util.*;

public class Mun{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] number = Arrays.stream(br.readLine().split(" "))
		                        .mapToLong(Long::parseLong).sorted().toArray();
		int count = 0;
        for(int i=0;i<N;i++){
            int first = (i==0)?1:0;
            int second = (i==N-1)?N-2:N-1;
            while(first<second){
                long sum = number[first]+number[second];
                if(sum==number[i]){
                    count++;
                    break;
                }
                if(sum<number[i]){
                    first++;
                    if(first==i) first++;
                }else{
                    second--;
                    if(second==i) second--;
                }
            }
        }
	    System.out.print(count);
	}
}