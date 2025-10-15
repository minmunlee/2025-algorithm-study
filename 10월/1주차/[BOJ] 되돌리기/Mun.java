import java.io.*;

public class Mun {
    static class Command {
        String command;
        String word;
        int returnTime;
        int runTime;
        
        public Command(String[] s) {
            this.command = s[0];
            this.runTime = Integer.parseInt(s[2]);
            if(s[0].equals("type")) {
                this.word = s[1];
            } else {
                this.returnTime = Integer.parseInt(s[1]);
            }
        }
    }
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    Command[] cmdList = new Command[N];
	    for(int i=0;i<N;i++) {
	        cmdList[i] = new Command(br.readLine().split(" "));
	    }
	    boolean[] deleted = new boolean[N];
	    for(int i=N-1;i>=0;i--) {
	        if(deleted[i] || cmdList[i].command.equals("type")) {
	            continue;
	        }
	        deleted[i] = true;
	        int reTime = cmdList[i].runTime - cmdList[i].returnTime;
	        for(int t=i-1;t>=0;t--) {
	            if(cmdList[t].runTime < reTime) {
	                break;
	            }
	            deleted[t] = true;
	        }
	    }
	    StringBuilder sb = new StringBuilder("");
	    for(int i=0;i<N;i++) {
	        if(deleted[i]) {
	            continue;
	        }
	        sb.append(cmdList[i].word);
	    }
	    System.out.print(sb.toString());
	}
}