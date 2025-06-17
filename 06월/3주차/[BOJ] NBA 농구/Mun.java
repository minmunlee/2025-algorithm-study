import java.io.*;

public class Mun {

	public static void main(String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    int[] teamScore = new int[3];
	    int count = 0;
	    int start = 0;
	    for(int i=0;i<N;i++) {
	        String[] input = br.readLine().split(" ");
	        int team = Integer.parseInt(input[0]);
	        if(count == 0){
	            start = convertToInt(input[1].split(":"));
	        }
	        count+=(team==1)?1:-1;
	        if(count == 0) {
	            int end = convertToInt(input[1].split(":"));
	            teamScore[(team==1)?2:1]+=(end-start);
	        }
	    }
	    if(count!=0) {
	        int end = convertToInt(new String[]{"48","0"});
	        teamScore[(count>0)?1:2]+=(end-start);
	    }
	    System.out.println(convertToString(teamScore[1]));
	    System.out.print(convertToString(teamScore[2]));
	}
	
	private static int convertToInt(String[] time) {
	    return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
	}
	
	private static String convertToString(int score) {
	    return String.format("%02d:%02d", score/60,  score%60);
	}

}