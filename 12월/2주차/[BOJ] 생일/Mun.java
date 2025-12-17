import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    ArrayList<Integer> birthday = new ArrayList<>();
	    HashMap<Integer, String> nameMap = new HashMap<>();
	    for(int i=0;i<n;i++) {
	        String[] input = br.readLine().split(" ");
	        String name = input[0];
	        int bd = convert(input[3], input[2], input[1]);
	        birthday.add(bd);
	        nameMap.put(bd, name);
	    }
	    birthday.sort((o1, o2) -> o2 - o1);
	    System.out.println(nameMap.get(birthday.get(0)));
	    System.out.print(nameMap.get(birthday.get(n-1)));
	}
	
	private static int convert(String year, String month, String day) { 
	    return Integer.parseInt(year)*10000 + Integer.parseInt(month)*100 + Integer.parseInt(day);
	}
}