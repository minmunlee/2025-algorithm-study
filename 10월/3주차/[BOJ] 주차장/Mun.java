import java.io.*;
import java.util.*;

public class Mun {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split(" ");
	    int N = Integer.parseInt(input[0]);
	    int M = Integer.parseInt(input[1]);
	    PriorityQueue<Integer> spaceQue = new PriorityQueue<>();
	    int[] parkingCost = new int[N];
	    for(int i=0;i<N;i++) {
	        spaceQue.add(i);
	        parkingCost[i] = Integer.parseInt(br.readLine());
	    }
	    int[] carCost = new int[M+1];
	    for(int i=1;i<=M;i++) {
	        carCost[i] = Integer.parseInt(br.readLine());
	    }
	    Queue<Integer> carQue = new LinkedList<>();
	    int[] carParking = new int[M+1];
	    int sum = 0;
	    for(int i=0;i<2*M;i++) {
	        int car = Integer.parseInt(br.readLine());
	        if(car > 0 && spaceQue.size() > 0) {
	            int spaceNum = spaceQue.poll();
	            sum+=(carCost[car] * parkingCost[spaceNum]);
	            carParking[car] = spaceNum;
	        } else if(car > 0) {
	            carQue.add(car);
	        } else if(car < 0) {
	            car*=-1;
	            int emSpace = carParking[car];
	            spaceQue.add(emSpace);
	            if(carQue.size() > 0) {
	                int cn = carQue.poll();
	                int sn = spaceQue.poll();
	                sum+=(carCost[cn] * parkingCost[sn]);
	                carParking[cn] = sn;
	            }
	        }
	    }
	    System.out.print(sum);
	}
}