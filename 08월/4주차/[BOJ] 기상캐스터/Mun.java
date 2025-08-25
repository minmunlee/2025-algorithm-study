import java.io.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] sizeInput = br.readLine().split(" ");
	    int H = Integer.parseInt(sizeInput[0]);
	    int W = Integer.parseInt(sizeInput[1]);
	    String[][] map = new String[H][W];
	    for(int i=0;i<H;i++) {
	        map[i] = br.readLine().split("");
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<H;i++) {
	        int come = -1;
	        for(int j=0;j<W;j++) {
	            if(come > -1) {
	                come++;
	            }
	            if(map[i][j].equals("c")) {
	                come = 0;
	            }
	            sb.append(come).append(" ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb.toString());
	}
}