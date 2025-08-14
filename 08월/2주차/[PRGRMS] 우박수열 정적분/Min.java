import java.util.*;
class Min {
    static List<Integer> dot;
    static List<Double> area;
    public double[] solution(int k, int[][] ranges) {
        initDot(k);
        getArea(ranges);
        
        double[] answer = new double[area.size()];
        
        for(int i = 0; i < area.size(); i++) {
            answer[i] = area.get(i);
        }
        
        return answer;
    }
    
    public static void initDot(int k) {
        dot = new ArrayList<>();
        dot.add(k);
        
        while(k != 1) {
            if(k % 2 == 0) {
                k /= 2;
                dot.add(k);
            }else {
                k = k * 3 + 1;
                dot.add(k);
            }
        }
    }
    
    public static void getArea(int[][] ranges) {
        int n = dot.size() - 1;
        area = new ArrayList<>();
        for(int[] arr : ranges) {
            int a = arr[0];
            int b = arr[1];
            int num = n - Math.abs(b);
            double sum = 0;
            if(num < a) {
                area.add(-1.0);
                continue;
            }
            
            for(int i = a; i < num; i++) {
                double r = dot.get(i) + dot.get(i + 1);
                sum += r / 2;
            }
            area.add(sum);
        }
    }
}