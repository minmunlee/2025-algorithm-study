import java.util.*;

class Min {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[col - 1] != o2[col - 1] ? o1[col - 1] - o2[col - 1] : o2[0] - o1[0];
            }
        });
        
        List<Integer> sum = new ArrayList<>();
    
        for(int i = row_begin - 1; i < row_end; i++) {
            sum.add(getNum(data[i], i + 1));
        }
        
        for(int i : sum) {
            answer = i ^ answer;
        }
        return answer;
    }
    
    public static int getNum(int[] arr, int row) {
        int sum = 0;
        for(int n : arr) {
            sum += n % row;
        }
        
        return sum;
    }
}