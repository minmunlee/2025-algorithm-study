import java.io.*;
import java.util.*;

public class Mun {
    static ArrayList<Set<Integer>> list = new ArrayList<>();
    static int bingoCount = 0;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int[][] board = new int[5][5];
	    for(int i=0;i<5;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=0;j<5;j++) {
	            board[i][j] = Integer.parseInt(input[j]);
	        }
	    }
	    setList(board);
	    int callCount = 0;
	    boolean bingo = false;
	    for(int i=0;i<5;i++) {
	        String[] call = br.readLine().split(" ");
	        if(bingo) continue;
	        for(int j=0;j<5;j++) {
	            check(Integer.parseInt(call[j]));
	            if(bingoCount>=3) {
	                callCount = (i*5) + (j+1);
	                bingo = true;
	                break;
	            }
	        }
	    }
	    System.out.print(callCount);
	}
	
	private static void check(int number) {
	    for(Set<Integer> s : list) {
	        if(s.isEmpty()) continue;
	        if(s.contains(number)) {
	            s.remove(number);
	            if(s.isEmpty()) bingoCount++;
	        }
	    }
	}
	
	private static void setList(int[][] board) {
	    Set<Integer> bingoSet1 = new HashSet<>();
	    Set<Integer> bingoSet2 = new HashSet<>();
	    for(int i=0;i<5;i++) {
	        Set<Integer> bingoSet3 = new HashSet<>();
	        Set<Integer> bingoSet4 = new HashSet<>();
	        for(int j=0;j<5;j++) {
	            bingoSet3.add(board[i][j]);
	            bingoSet4.add(board[j][i]);
	        }
	        list.add(bingoSet3);
	        list.add(bingoSet4);
	        bingoSet1.add(board[i][i]);
	        bingoSet2.add(board[i][4-i]);
	    }
	    list.add(bingoSet1);
	    list.add(bingoSet2);
	}
}