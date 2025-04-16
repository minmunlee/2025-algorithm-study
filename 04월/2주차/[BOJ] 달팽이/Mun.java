import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    int target = Integer.parseInt(br.readLine());
	    int[][] table = new int[N+1][N+1];
	    
	    int x = (N-1)/2;
	    int y = (N-1)/2;
	    
	    int number = 1;
	    int w = 0;
	    int d = 0;
	    int w_count = 0;
	    int a_count = -1;
	    
	    String con = "";
	    
	    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	    
	    while(number <= N*N) {  
	        if(number == target) {
	            con = (y+1)+" "+(x+1);
	        }
	        table[y][x] = number++;

	        w_count++;
	        a_count++;
	        
	        if(a_count==w*4) {
	            d = 0;
	            w+=2;
	            w_count = 0;
	            a_count = 0;
	            y--;
	            continue;
	        }
	        if(w_count==w) {
	            d++;
	            w_count = 0;
	        }
	        
	        y+=dir[d][0];
	        x+=dir[d][1];
	    };
	    
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<N;i++) {
	        for(int j=0;j<N;j++) {
	            sb.append(table[i][j]).append(" ");
	        }
	        sb.append("\n");
	    }
	    sb.append(con);
	    System.out.print(sb.toString());
	}
}