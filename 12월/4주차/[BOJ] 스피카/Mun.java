import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    ArrayList<Integer>[] line = new ArrayList[13];
	    for(int i=1;i<=12;i++) {
	        line[i] = new ArrayList<>();
	    }
	    for(int i=0;i<12;i++) {
	        String[] input = br.readLine().split(" ");
	        int x = Integer.parseInt(input[0]);
	        int y = Integer.parseInt(input[1]);
	        line[x].add(y);
	        line[y].add(x);
	    }
	    int Spika = -1;
	    for(int i=1;i<=12;i++) {
	        if(line[i].size() != 1) {
	            continue;
	        }
	        int sCandidate = line[i].get(0);
	        if(line[sCandidate].size() != 3) {
	            continue;
	        }
	        for(int star : line[sCandidate]) {
	            if(line[star].size() == 2) {
	                Spika = sCandidate;
	                break;
	            }
	        }
	        if(Spika > 0) {
	            break;
	        }
	    }
	    System.out.print(Spika);
	}
	
}