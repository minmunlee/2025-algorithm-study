import java.util.*;

class Min {
    public int solution(int[] picks, String[] minerals) {
        List<int[]> groups = new ArrayList<>();
        int max = Math.min(minerals.length, (picks[0] + picks[1] + picks[2]) * 5);

        for (int i = 0; i < max; i += 5) {
            int dia = 0;
            int iron = 0; 
            int stone = 0;
            
            for (int j = i; j < i + 5 && j < max; j++) {
                String m = minerals[j];
                if (m.equals("diamond")) {
                    dia += 1; 
                    iron += 5; 
                    stone += 25;
                } else if (m.equals("iron")) {
                    dia += 1; 
                    iron += 1; 
                    stone += 5;
                } else {
                    dia += 1; 
                    iron += 1; 
                    stone += 1;
                }
            }
            groups.add(new int[]{dia, iron, stone});
        }

        groups.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[2] - a[2];
            }
        });

        int answer = 0;
        for (int[] g : groups) {
            if (picks[0] > 0) {
                answer += g[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += g[1];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += g[2];
                picks[2]--;
            }
        }

        return answer;
    }
}