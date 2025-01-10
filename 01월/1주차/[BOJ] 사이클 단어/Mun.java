import java.io.*;
import java.util.*;

public class Mun {
    static HashSet<String> wordSet = new HashSet<>();
    static HashSet<Integer> lengthSet = new HashSet<>();
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++) {
	        String word = br.readLine();
	        int wordLength = word.length();
	        if(lengthSet.contains(wordLength) && containValue(word, wordLength)) {
	            continue;
	        }
	        lengthSet.add(wordLength);
	        wordSet.add(word);
	    }
	    System.out.print(wordSet.size());
	}
	
	private static boolean containValue(String value, int size) {
	    if(wordSet.contains(value)) return true;
	    for(int i=0;i<size-1;i++) {
	        char first = value.charAt(0);
	        value = value.substring(1, size) + first;
	        if(wordSet.contains(value)) {
	            return true;
	        }
	    }
	    return false;
	}
}