import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] Ps = new int[M];
		for(int i=0; i<M; i++) {
			Ps[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(Ps);
		int start = Math.max(0, M-N);
		int price = 0;
		int maxTotal = 0;
		for(int i=start; i<M; i++) {
			int nowTotal = Ps[i] * (M-i);
			if(nowTotal > maxTotal) {
				maxTotal = nowTotal;
				price = Ps[i];
			}
		}
		System.out.print(price+" "+maxTotal);
	}
}