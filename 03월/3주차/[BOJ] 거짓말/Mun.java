import java.io.*;
import java.util.*;

public class Mun {
    
    static HashSet<Integer>[] people2party;
	static HashSet<Integer>[] party2people;
    static boolean[] visitedParty;
	static boolean[] visitedPeople;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine(), " ");
	    int k_num = Integer.parseInt(st.nextToken());
	    HashSet<Integer> knows = new HashSet<>();
	    for(int i=0;i<k_num;i++) {
	        knows.add(Integer.parseInt(st.nextToken()));
	    }
	    
	    people2party = new HashSet[N+1];
	    party2people = new HashSet[M];
	    for(int i=1;i<=N;i++) {
	        people2party[i] = new HashSet<>();
	    }
	    
	    for(int i=0;i<M;i++) {
	        party2people[i] = new HashSet<>();
	        
	        st = new StringTokenizer(br.readLine(), " ");
	        int num = Integer.parseInt(st.nextToken());
	        for(int j=0;j<num;j++) {
	            int p = Integer.parseInt(st.nextToken());
	            party2people[i].add(p);
	            people2party[p].add(i);
	        }
	    }
	    
	    visitedParty = new boolean[M];
	    visitedPeople = new boolean[N+1];
	    for(int k : knows) {
	        nav(k);
	    }
	    int count = 0;
	    for(boolean v : visitedParty) {
	        if(!v) {
	            count++;
	        }
	    }
	    System.out.print(count);
	}
	
	
	private static void nav(int now_person) {
	    for(int party : people2party[now_person]) {
	        if(visitedParty[party]) {
	            continue;
	        }
	        visitedParty[party] = true;
	        for(int person : party2people[party]) {
	            if(visitedPeople[person]) {
	                continue;
	            }
	            visitedPeople[person] = true;
	            nav(person);
	        }
	    }
	}
}