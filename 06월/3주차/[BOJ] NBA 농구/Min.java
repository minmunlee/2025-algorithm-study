import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Min {
    static int team1Score = 0;
    static int team2Score = 0;
    static int team1Time = 0;
    static int team2Time = 0;
    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            int team = Integer.parseInt(str[0]);
            int curTime = convertSec(str[1]);

            if(team1Score > team2Score) {
                team1Time += (curTime - time);
            } else if(team2Score > team1Score) {
                team2Time += (curTime - time);
            }

            if(team == 1){
                team1Score++;
            } else{
                team2Score++;
            } 

            time = curTime;
        }

        if(team1Score > team2Score) {
            team1Time += (2880 - time);
        } else if(team2Score > team1Score) {
            team2Time += (2880 - time);
        }

        System.out.println(formatTime(team1Time));
        System.out.println(formatTime(team2Time));
    }

    static int convertSec(String time) {
        String[] split = time.split(":");
        int min = Integer.parseInt(split[0]);
        int sec = Integer.parseInt(split[1]);
        return min * 60 + sec;
    }

    static String formatTime(int totalSec) {
        int min = totalSec / 60;
        int sec = totalSec % 60;
        return String.format("%02d:%02d", min, sec);
    }
}