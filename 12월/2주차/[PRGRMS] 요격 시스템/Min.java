import java.util.*;

class Min {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        
        int tmp = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            if(tmp <= targets[i][0]) {
                answer += 1;
                tmp = targets[i][1];
            }
        }
        return answer;
    }
}