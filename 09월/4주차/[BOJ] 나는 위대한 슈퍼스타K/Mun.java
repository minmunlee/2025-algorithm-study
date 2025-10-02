import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] info = br.readLine().split(" ");
	    int N = Integer.parseInt(info[0]);
	    int M = Integer.parseInt(info[1]);
	    int K = Integer.parseInt(info[2]);
	    double[] maxAbility = new double[N+1];
	    String[] first = br.readLine().split(" ");
	    int mi = N * 2;
	    for(int i=0;i<mi;i+=2) {
	        int number = Integer.parseInt(first[i]);
	        double ability = Double.parseDouble(first[i+1]);
	        maxAbility[number] = ability;
	    }
	    for(int m=1;m<M;m++) {
	        String[] abilities = br.readLine().split(" ");
	        for(int i=0;i<mi;i+=2) {
	            int number = Integer.parseInt(abilities[i]);
	            double ability = Double.parseDouble(abilities[i+1]);
	            if(maxAbility[number] < ability) {
	                maxAbility[number] = ability;
	            }
	        }
	    }
	    Arrays.sort(maxAbility);
	    double sum = 0;
	    for(int i=0;i<K;i++) {
	        sum+=maxAbility[N-i];
	    }
	    System.out.printf(String.format("%.1f", sum));
	}
}