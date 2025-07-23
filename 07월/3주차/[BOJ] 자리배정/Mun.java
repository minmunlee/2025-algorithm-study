import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] size = br.readLine().split(" ");
	    int C = Integer.parseInt(size[0]);
	    int R = Integer.parseInt(size[1]);
	    int target = Integer.parseInt(br.readLine());
	    int[][] seat = new int[R+1][C+1];
	    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	    int num = 1;
	    int x = 0;
	    int y = 1;
	    int dc = 0;
	    
	    while(num <= target) {
	        x+=dir[dc][0];
	        y+=dir[dc][1];
	        if(x<1 || x>R || y<1 || y>C || seat[x][y] > 0) {
	            x-=dir[dc][0];
	            y-=dir[dc][1];
	            dc++;
	            dc = dc%4;
	            x+=dir[dc][0];
	            y+=dir[dc][1];
	        }
	        seat[x][y] = num++;
	    }
	    
	    if(target > C*R) {
	        System.out.print("0");
	    } else {
	        System.out.print(y+" "+x);
	    }
	    
	}

}
