import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Min {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(str.nextToken());
        int M = Integer.parseInt(str.nextToken());
        HashMap<Integer, Integer> score = new HashMap<>(); // 배점
        HashMap<Integer, Integer> info = new HashMap<>(); // 사람별 받은 점수 정보

        str = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            score.put(i, Integer.parseInt(str.nextToken()));
        }

        for(int i = 0; i < M; i++){
            String[] s = br.readLine().split(" ");
            int num = Integer.parseInt(s[0]);
            int getScore = 0;
            for(int j = 1; j <= N; j++){
                if(s[j].equals("O")){
                    getScore += score.get(j);
                }
            }
            info.put(num, getScore);
        }

        int maxScore = -1;
        int studentId = -1;

        for (Map.Entry<Integer, Integer> entry : info.entrySet()) {
            if (entry.getValue() > maxScore || (entry.getValue() == maxScore && entry.getKey() < studentId)) {
                maxScore = entry.getValue();
                studentId = entry.getKey();
            }
        }

        System.out.println(studentId + " " + maxScore);
    }
}