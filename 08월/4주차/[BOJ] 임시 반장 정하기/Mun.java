import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int SN = Integer.parseInt(br.readLine());
	    ArrayList<Integer>[][] count = new ArrayList[6][10];
	    for(int i=1;i<=5;i++) {
	        for(int j=1;j<=9;j++) {
	            count[i][j] = new ArrayList<>();
	        }
	    }
	    for(int i=0;i<SN;i++) {
	        String[] input = br.readLine().split(" ");
	        for(int j=0;j<5;j++) {
	            count[j+1][Integer.parseInt(input[j])].add(i+1);
	        }
	    }
	    HashSet<Integer>[] SCount = new HashSet[SN+1];
	    for(int i=1;i<=SN;i++) {
	        SCount[i] = new HashSet<>();
	    }
	    for(int i=1;i<=5;i++) {
	        for(int j=1;j<=9;j++) {
	            if(count[i][j].size() >= 2) {
	                for(int s=0;s<count[i][j].size()-1;s++) {
	                    int a = count[i][j].get(s);
	                    for(int c=s+1;c<count[i][j].size();c++) {
	                        int b = count[i][j].get(c);
	                        SCount[a].add(b);
	                        SCount[b].add(a);
	                    }
	                }
	            }
	        }
	    }
	    int maxC = 0;
	    int maxS = 1;
	    for(int i=1;i<=SN;i++) {
	        if(SCount[i].size() > maxC) {
	            maxC = SCount[i].size();
	            maxS = i;
	        }
	    }
	    System.out.print(maxS);
	}
}
