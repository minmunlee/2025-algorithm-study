import java.io.*;
import java.util.*;

public class Mun {
    static class Shape {
        int garo;
        int[] wList;
        
        public Shape(int garo, int[] wList) {
            this.garo = garo;
            this.wList = wList;
        }
    }
    
    static ArrayList<Shape>[] blocks = new ArrayList[8];
    static int C, P, count = 0;
    static int[] field;
    
	public static void main(String[] args) throws IOException {
	    init();
	    set();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] info = br.readLine().split(" ");
	    C = Integer.parseInt(info[0]);
	    P = Integer.parseInt(info[1]);
	    field = new int[C];
	    String[] h = br.readLine().split(" ");
	    for(int i=0;i<C;i++) {
	        field[i] = Integer.parseInt(h[i]);
	    }
	    ArrayList<Shape> sList = blocks[P];
	    for(Shape s : sList) {
	        getCountBy(s.garo, s.wList);
	    }
	    System.out.print(count);
	}
	
	private static void getCountBy(int garo, int[] w) {
	    for(int i=0;i<=C-garo;i++){
	        int now = field[i];
	        boolean fit = true;
	        for(int j=1;j<garo;j++) {
	            if(field[i+j] == now + w[j]) {
	                continue;
	            }
	            fit = false;
	            break;
	        }
	        if(fit) {
	            count++;
	        }
	    }
	}

	private static void set() {
	    blocks[1].add(new Shape(1, new int[]{0}));
	    blocks[1].add(new Shape(4, new int[]{0, 0, 0, 0}));
	    
	    blocks[2].add(new Shape(2, new int[]{0, 0}));
	    
	    blocks[3].add(new Shape(3, new int[]{0, 0, 1}));
	    blocks[3].add(new Shape(2, new int[]{0, -1}));
	    
	    blocks[4].add(new Shape(3, new int[]{0, -1, -1}));
	    blocks[4].add(new Shape(2, new int[]{0, 1}));
	    
	    blocks[5].add(new Shape(3, new int[]{0, 0, 0}));
	    blocks[5].add(new Shape(2, new int[]{0, 1}));
	    blocks[5].add(new Shape(3, new int[]{0, -1, 0}));
	    blocks[5].add(new Shape(2, new int[]{0, -1}));
	    
	    blocks[6].add(new Shape(3, new int[]{0, 0, 0}));
	    blocks[6].add(new Shape(2, new int[]{0, 0}));
	    blocks[6].add(new Shape(3, new int[]{0, 1, 1}));
	    blocks[6].add(new Shape(2, new int[]{0, -2}));
	    
	    blocks[7].add(new Shape(3, new int[]{0, 0, 0}));
	    blocks[7].add(new Shape(2, new int[]{0, 2}));
	    blocks[7].add(new Shape(3, new int[]{0, 0, -1}));
	    blocks[7].add(new Shape(2, new int[]{0, 0}));
	}
	
	private static void init() {
	    for(int i=1;i<=7;i++) {
	        blocks[i] = new ArrayList<>();
	    }
	}
	
}