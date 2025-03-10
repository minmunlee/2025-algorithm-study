import java.util.*;

class Min {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        boolean[] visited = new boolean[words.length];
        
        while(!queue.isEmpty()){
            answer++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                for (int j = 0; j < words.length; j++) {
                    if (!visited[j] && changeWord(current, words[j])) {
                        if (words[j].equals(target)) {
                            return answer;
                        }
                        queue.add(words[j]);
                        visited[j] = true;
                    }
                }
            }
        }
        return 0;
    }
    public static boolean changeWord(String compare, String current){
        String[] com = compare.split("");
        String[] cur = current.split("");
        int cnt = 0;
        for(int i = 0; i < com.length; i++){
            if(!com[i].equals(cur[i])){
                cnt++;
            }
        }
        return cnt == 1 ? true : false;
    }
}