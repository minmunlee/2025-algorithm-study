import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    int J = Integer.parseInt(br.readLine());
	    int front = 1, back = M, move = 0;
	    for(int i=0;i<J;i++) {
	        int apple = Integer.parseInt(br.readLine());
	        if(apple>=front && apple<=back) {
	            continue;
	        } else if(apple < front) {
	            while(apple!=front) {
	                front--;
	                back--;
	                move++;
	            }
	        } else if(apple > back) {
	            while(apple!=back) {
	                front++;
	                back++;
	                move++;
	            }
	        }
	    }
	    System.out.print(move);
	}
}