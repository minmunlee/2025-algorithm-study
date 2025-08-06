import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    br.readLine();
	    String[] toppings = br.readLine().split(" ");
	    HashSet<String> set = new HashSet<>();
	    for(String topping : toppings) {
	        if(topping.length() < 6) {
	            continue;
	        }
	        String end = topping.substring(topping.length() - 6, topping.length());
	        if(end.equals("Cheese")) {
	            set.add(topping);
	        }
	    }
	    System.out.print((set.size() >= 4) ? "yummy" : "sad");
	}
}