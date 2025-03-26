import java.util.*;

class Min {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        int min = -300001;
        for(int[] route : routes){
            if(min < route[0]){
                answer++;
                min = route[1];
            }
        }
        return answer;
    }
}
